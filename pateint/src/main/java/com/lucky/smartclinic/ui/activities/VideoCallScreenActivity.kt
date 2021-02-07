package com.lucky.smartclinic.ui.activities

import android.media.AudioManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.lucky.smartclinic.R
import com.lucky.smartclinic.service.SinchService
import com.lucky.smartclinic.utils.AudioPlayer
import com.sinch.android.rtc.PushPair
import com.sinch.android.rtc.calling.Call
import com.sinch.android.rtc.calling.CallState
import com.sinch.android.rtc.video.VideoCallListener
import java.util.*

class VideoCallScreenActivity : BaseActivity() {
    private var mAudioPlayer: AudioPlayer? = null
    private var mTimer: Timer? = null
    private var mDurationTask: UpdateCallDurationTask? = null
    private var mCallId: String? = null
    private var mAddedListener = false
    private var mLocalVideoViewAdded = false
    private var mRemoteVideoViewAdded = false
    private var mCallDuration: TextView? = null
    private var mCallState: TextView? = null
    private var mCallerName: TextView? = null
    private var mToggleVideoViewPositions = false

    private inner class UpdateCallDurationTask : TimerTask() {
        override fun run() {
            runOnUiThread { updateCallDuration() }
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putBoolean(ADDED_LISTENER, mAddedListener)
        savedInstanceState.putBoolean(VIEWS_TOGGLED, mToggleVideoViewPositions)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        mAddedListener = savedInstanceState.getBoolean(ADDED_LISTENER)
        mToggleVideoViewPositions = savedInstanceState.getBoolean(VIEWS_TOGGLED)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_callscreen)
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
        val call = sinchServiceInterface!!.getCall(mCallId!!)
        if (!mAddedListener) {
            call.addCallListener(SinchCallListener())
            mAddedListener = true
        }
        updateUI()
    }

    private fun updateUI() {
        if (sinchServiceInterface == null) {
            return  // early
        }
        val call = sinchServiceInterface!!.getCall(mCallId!!)
        val callerName = "DR  ${call.headers["callerName"]}"
        mCallerName!!.text =  callerName
        mCallState!!.text = call.state.toString()
        if (call.details.isVideoOffered) {
            setVideoViewsVisibility(true, call.state == CallState.ESTABLISHED)
        }
    }

    public override fun onStop() {
        super.onStop()
        mDurationTask!!.cancel()
        mTimer!!.cancel()
        removeVideoViews()
    }

    public override fun onStart() {
        super.onStart()
        mTimer = Timer()
        mDurationTask = UpdateCallDurationTask()
        mTimer!!.schedule(mDurationTask, 0, 500)
        updateUI()
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

    private fun getVideoView(localView: Boolean): ViewGroup {
        var myLocalView = localView
        if (mToggleVideoViewPositions) {
            myLocalView = !myLocalView
        }
        return if (myLocalView) findViewById(R.id.localVideo) else findViewById(R.id.remoteVideo)
    }

    private fun addLocalView() {
        if (mLocalVideoViewAdded || sinchServiceInterface == null) {
            return  //early
        }
        val vc = sinchServiceInterface!!.videoController
        if (vc != null) {
            runOnUiThread {
                val localView = getVideoView(true)
                localView.addView(vc.localView)
                localView.setOnClickListener { vc.toggleCaptureDevicePosition() }
                mLocalVideoViewAdded = true
                vc.setLocalVideoZOrder(!mToggleVideoViewPositions)
            }
        }
    }

    private fun addRemoteView() {
        if (mRemoteVideoViewAdded || sinchServiceInterface == null) {
            return  //early
        }
        val vc = sinchServiceInterface!!.videoController
        if (vc != null) {
            runOnUiThread {
                val remoteView = getVideoView(false)
                remoteView.addView(vc.remoteView)
                remoteView.setOnClickListener {
                    removeVideoViews()
                    mToggleVideoViewPositions = !mToggleVideoViewPositions
                    addRemoteView()
                    addLocalView()
                }
                mRemoteVideoViewAdded = true
                vc.setLocalVideoZOrder(!mToggleVideoViewPositions)
            }
        }
    }

    private fun removeVideoViews() {
        if (sinchServiceInterface == null) {
            return  // early
        }
        val vc = sinchServiceInterface!!.videoController
        if (vc != null) {
            runOnUiThread {
                (vc.remoteView.parent as ViewGroup).removeView(vc.remoteView)
                (vc.localView.parent as ViewGroup).removeView(vc.localView)
                mLocalVideoViewAdded = false
                mRemoteVideoViewAdded = false
            }
        }
    }

    private fun setVideoViewsVisibility(localVideoVisibile: Boolean, remoteVideoVisible: Boolean) {
        if (sinchServiceInterface == null) return
        if (!mRemoteVideoViewAdded) {
            addRemoteView()
        }
        if (!mLocalVideoViewAdded) {
            addLocalView()
        }
        val vc = sinchServiceInterface!!.videoController
        if (vc != null) {
            runOnUiThread {
                vc.localView.visibility = if (localVideoVisibile) View.VISIBLE else View.GONE
                vc.remoteView.visibility = if (remoteVideoVisible) View.VISIBLE else View.GONE
            }
        }
    }

    private inner class SinchCallListener : VideoCallListener {
        override fun onCallEnded(call: Call) {
            val cause = call.details.endCause
            Log.d(TAG, "Call ended. Reason: $cause")
            mAudioPlayer!!.stopProgressTone()
            volumeControlStream = AudioManager.USE_DEFAULT_STREAM_TYPE
            val endMsg = "Call ended: " + call.details.toString()
            Toast.makeText(this@VideoCallScreenActivity, "call ended", Toast.LENGTH_LONG).show()
            Log.d(TAG, "onCallEnded: $endMsg")
            endCall()
        }

        override fun onCallEstablished(call: Call) {
            Toast.makeText(this@VideoCallScreenActivity, "connected", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "Call established")
            mAudioPlayer!!.stopProgressTone()
            mCallState!!.text = call.state.toString()
            volumeControlStream = AudioManager.STREAM_VOICE_CALL
            val audioController = sinchServiceInterface!!.audioController
            audioController!!.enableSpeaker()
            if (call.details.isVideoOffered) {
                setVideoViewsVisibility(true, true)
            }
            Log.d(TAG, "Call offered video: " + call.details.isVideoOffered)
        }

        override fun onCallProgressing(call: Call) {
            Log.d(TAG, "Call progressing")
            mAudioPlayer!!.playProgressTone()
        }

        override fun onShouldSendPushNotification(call: Call, pushPairs: List<PushPair>) {
            // Send a push through your push provider here, e.g. GCM
        }

        override fun onVideoTrackAdded(call: Call) {}
        override fun onVideoTrackPaused(call: Call) {}
        override fun onVideoTrackResumed(call: Call) {}
    }

    companion object {
        private const val TAG = "VideoCallScreenActivity"
        const val ADDED_LISTENER = "addedListener"
        const val VIEWS_TOGGLED = "viewsToggled"
    }
}