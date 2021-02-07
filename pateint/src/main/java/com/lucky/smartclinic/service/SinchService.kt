package com.lucky.smartclinic.service

import android.Manifest
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.*
import android.util.Log
import com.lucky.smartclinic.ui.activities.IncomingCallScreenActivity
import com.sinch.android.rtc.*
import com.sinch.android.rtc.calling.Call
import com.sinch.android.rtc.calling.CallClient
import com.sinch.android.rtc.calling.CallClientListener
import com.sinch.android.rtc.video.VideoController

class SinchService : Service() {
    private var messenger: Messenger? = null
    private val mSinchServiceInterface: SinchServiceInterface = SinchServiceInterface()
    var mSinchClient: SinchClient? = null
    var mUserId: String? = null
    var mListener: StartFailedListener? = null
    private var mSettings: PersistedSettings? = null
    override fun onCreate() {
        super.onCreate()
        mSettings = PersistedSettings(applicationContext)
        attemptAutoStart()
    }

    fun attemptAutoStart() {
        val userName = mSettings!!.username
        if (userName!!.isNotEmpty() && messenger != null) {
            start(userName)
        }
    }

    override fun onDestroy() {
        if (mSinchClient != null && mSinchClient!!.isStarted) {
            mSinchClient!!.terminateGracefully()
        }
        super.onDestroy()
    }

    fun start(userName: String?) {
        var permissionsGranted = true
        if (mSinchClient == null) {
            mSettings!!.username = userName
            mUserId = userName
            createClient(userName)
        }
        try {
            //mandatory checks
            mSinchClient!!.checkManifest()
            //auxiliary check
            if (applicationContext.checkCallingOrSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                throw MissingPermissionException(Manifest.permission.CAMERA)
            }
        } catch (e: MissingPermissionException) {
            permissionsGranted = false
            if (messenger != null) {
                val message = Message.obtain()
                val bundle = Bundle()
                bundle.putString(REQUIRED_PERMISSION, e.requiredPermission)
                message.data = bundle
                message.what = MESSAGE_PERMISSIONS_NEEDED
                try {
                    messenger!!.send(message)
                } catch (e1: RemoteException) {
                    e1.printStackTrace()
                }
            }
        }
        if (permissionsGranted) {
            Log.d(TAG, "Starting SinchClient")
            mSinchClient!!.start()
        }
    }

    private fun createClient(userName: String?) {
        mSinchClient = Sinch.getSinchClientBuilder().context(applicationContext).userId(userName)
            .applicationKey(APP_KEY)
            .applicationSecret(APP_SECRET)
            .environmentHost(ENVIRONMENT).build()
        mSinchClient!!.setSupportCalling(true)
        mSinchClient!!.startListeningOnActiveConnection()
        mSinchClient!!.addSinchClientListener(MySinchClientListener())
        mSinchClient!!.callClient.addCallClientListener(SinchCallClientListener())
    }

    fun stop() {
        if (mSinchClient != null) {
            mSinchClient!!.terminateGracefully()
            mSinchClient = null
        }
    }

    val isStarted: Boolean
        get() = mSinchClient != null && mSinchClient!!.isStarted

    override fun onBind(intent: Intent): IBinder? {
        messenger = intent.getParcelableExtra(MESSENGER)
        return mSinchServiceInterface
    }

    inner class SinchServiceInterface : Binder() {

        fun callUser(userId: String): Call {
            return mSinchClient!!.callClient.callUser(userId)
        }
        fun callUser(userId: String?, headers: MutableMap<String, String>): Call? {
            return mSinchClient!!.callClient.callUser(userId, headers)
        }


        fun callUserVideo(userId: String?, headers: MutableMap<String, String>): Call? {
            return mSinchClient!!.callClient.callUserVideo(userId, headers)
        }

        val userName: String
            get() = mUserId!!

        fun retryStartAfterPermissionGranted() {
            attemptAutoStart()
        }

        private val isStarted: Boolean
            get() = this@SinchService.isStarted

        fun startClient(userName: String) {
            start(userName)
        }

        fun stopClient() {
            stop()
        }

        fun setStartListener(listener: StartFailedListener) {
            mListener = listener
        }

        fun getCall(callId: String?): Call {
            return mSinchClient!!.callClient.getCall(callId)
        }

        val videoController: VideoController?
            get() = if (!isStarted) {
                null
            } else mSinchClient!!.videoController
        val audioController: AudioController?
            get() = if (!isStarted) {
                null
            } else mSinchClient!!.audioController
    }

    interface StartFailedListener {
        fun onStartFailed(error: SinchError)
        fun onStarted()
    }

    internal inner class MySinchClientListener : SinchClientListener {
        override fun onClientFailed(client: SinchClient, error: SinchError) {
            if (mListener != null) {
                mListener!!.onStartFailed(error)
            }
            mSinchClient!!.terminate()
            mSinchClient = null
        }

        override fun onClientStarted(client: SinchClient) {
            Log.d(TAG, "SinchClient started")
            if (mListener != null) {
                mListener!!.onStarted()
            }
        }

        override fun onClientStopped(client: SinchClient) {
            Log.d(TAG, "SinchClient stopped")
        }

        override fun onLogMessage(level: Int, area: String, message: String) {
            when (level) {
                Log.DEBUG -> Log.d(area, message)
                Log.ERROR -> Log.e(area, message)
                Log.INFO -> Log.i(area, message)
                Log.VERBOSE -> Log.v(area, message)
                Log.WARN -> Log.w(area, message)
            }
        }

        override fun onRegistrationCredentialsRequired(
            client: SinchClient,
            clientRegistration: ClientRegistration
        ) {
        }
    }

    internal inner class SinchCallClientListener : CallClientListener {
        override fun onIncomingCall(callClient: CallClient, call: Call) {
            Log.d(TAG, "Incoming call")
            val intent = Intent(this@SinchService, IncomingCallScreenActivity::class.java)
            intent.putExtra(CALL_ID, call.callId)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            this@SinchService.startActivity(intent)
        }
    }

    private class PersistedSettings(context: Context) {
        private val mStore: SharedPreferences
        var username: String?
            get() = mStore.getString("Username", "")
            set(username) {
                val editor = mStore.edit()
                editor.putString("Username", username)
                editor.apply()
            }

        companion object {
            private const val PREF_KEY = "Sinch"
        }

        init {
            mStore = context.getSharedPreferences(PREF_KEY, MODE_PRIVATE)
        }
    }

    companion object {
        private const val APP_KEY = "c504dbe0-5af3-441e-8db4-db8fc5438027"
        private const val APP_SECRET = "NZEuukKn0EOUfnSs/UuG0g=="
        private const val ENVIRONMENT = "clientapi.sinch.com"
        const val MESSAGE_PERMISSIONS_NEEDED = 1
        const val REQUIRED_PERMISSION = "REQUIRED_PESMISSION"
        const val MESSENGER = "MESSENGER"
        const val CALL_ID = "CALL_ID"
        private const val TAG = "SinchService"
    }
}