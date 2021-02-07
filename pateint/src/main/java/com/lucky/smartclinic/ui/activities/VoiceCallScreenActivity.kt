package com.lucky.smartclinic.ui.activities

import android.media.AudioManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.lucky.smartclinic.R
import com.lucky.smartclinic.service.SinchService
import com.lucky.smartclinic.utils.AudioPlayer
import com.sinch.android.rtc.AudioController
import com.sinch.android.rtc.PushPair
import com.sinch.android.rtc.calling.Call
import com.sinch.android.rtc.calling.CallListener
import java.util.*

class VoiceCallScreenActivity : BaseActivity() {
    private var mAudioPlayer: AudioPlayer? = null
    private var mTimer: Timer? = null
    private var mDurationTask: UpdateCallDurationTask? = null
    private var mCallId: String? = null
    private var mCallDuration: TextView? = null
    private var mCallState: TextView? = null
    private var mCallerName: TextView? = null

    private inner class UpdateCallDurationTask : TimerTask() {
        override fun run() {
            runOnUiThread { updateCallDuration() }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.voice_callscreen)
        mAudioPlayer = AudioPlayer(this)
        mCallDuration = findViewById(R.id.callDuration)
        mCallerName = findViewById(R.id.remoteUser)
        mCallState = findViewById(R.id.callState)
         findViewById<Button>(R.id.hangupButton).apply {
            setOnClickListener { endCall() }
        }

        mCallId = intent.getStringExtra(SinchService.CALL_ID)
    }

    public override fun onServiceConnected() {

        try {
            val call = sinchServiceInterface!!.getCall(mCallId)
            call.addCallListener(SinchCallListener())
            val callerName = "DR  ${call.headers["callerName"]}"
            mCallerName!!.text = callerName
            mCallState!!.text = call.state.toString()
        }catch (e: Exception)
        {
            Log.e(TAG, "Started with invalid callId, aborting.")
            finish()
            e.printStackTrace()
        }
    }

    public override fun onPause() {
        super.onPause()
        mDurationTask!!.cancel()
        mTimer!!.cancel()
    }

    public override fun onResume() {
        super.onResume()
        mTimer = Timer()
        mDurationTask = UpdateCallDurationTask()
        mTimer!!.schedule(mDurationTask, 0, 500)
    }

    override fun onBackPressed() {
        // User should exit activity by ending call, not by going back.
    }

    private fun endCall() {
        mAudioPlayer!!.stopProgressTone()
        val call = sinchServiceInterface!!.getCall(mCallId!!)
        call.hangup()
        finish()
    }

    private fun formatTimeSpan(totalSeconds: Int): String {
        val minutes = totalSeconds / 60.toLong()
        val seconds = totalSeconds % 60.toLong()
        return String.format(Locale.US, "%02d:%02d", minutes, seconds)
    }

    private fun updateCallDuration() {
        val call = sinchServiceInterface!!.getCall(mCallId!!)
        mCallDuration!!.text = formatTimeSpan(call.details.duration)
    }

    internal inner class SinchCallListener : CallListener {
        override fun onCallEnded(call: Call) {
            val cause = call.details.endCause
            Log.d(TAG, "Call ended. Reason: $cause")
            mAudioPlayer!!.stopProgressTone()
            volumeControlStream = AudioManager.USE_DEFAULT_STREAM_TYPE
            val endMsg = "Call ended: " + call.details.toString()
            Toast.makeText(this@VoiceCallScreenActivity, endMsg, Toast.LENGTH_LONG).show()
            Log.d(TAG, "Call ended. Reason: $endMsg")
            endCall()
        }

        override fun onCallEstablished(call: Call) {
            Log.d(TAG, "Call established")
            mAudioPlayer!!.stopProgressTone()
            mCallState!!.text = call.state.toString()
            volumeControlStream = AudioManager.STREAM_VOICE_CALL
            val audioController = sinchServiceInterface!!.audioController
            audioController!!.disableSpeaker()
            audioController.enableAutomaticAudioRouting(
                true,
                AudioController.UseSpeakerphone.SPEAKERPHONE_AUTO
            )
        }

        override fun onCallProgressing(call: Call) {
            Log.d(TAG, "Call progressing")
            mAudioPlayer!!.playProgressTone()
        }

        override fun onShouldSendPushNotification(call: Call, pushPairs: List<PushPair>) {
            // Send a push through your push provider here, e.g. GCM
        }
    }

    companion object {
        private const val TAG = "VoiceCallScreenActivity"
    }
}