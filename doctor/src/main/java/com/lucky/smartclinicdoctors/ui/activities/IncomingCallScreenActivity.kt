package com.lucky.smartclinicdoctors.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.service.SinchService
import com.lucky.smartclinicdoctors.utils.AudioPlayer


class IncomingCallScreenActivity : BaseActivity() {
    private var mCallId: String? = null
    private var mAudioPlayer: AudioPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.incoming)
        findViewById<Button>(R.id.answerButton).apply {
            setOnClickListener { answerClicked() }
        }
        findViewById<Button>(R.id.declineButton).apply {
            setOnClickListener { declineClicked() }
        }
        mAudioPlayer = AudioPlayer(this)
        mAudioPlayer!!.playRingtone()
        mCallId = intent.getStringExtra(SinchService.CALL_ID)
    }

    override fun onServiceConnected() {
        try {
            val call = sinchServiceInterface!!.getCall(mCallId)
            val remoteUser = findViewById<TextView>(R.id.remoteUser)
            val callerName = "${call.headers["callerName"]}"
            remoteUser.text = callerName
        } catch (e: Exception) {
            Log.e(TAG, "Started with invalid callId, aborting")
            finish()
        }
    }

    private fun answerClicked() {
        mAudioPlayer!!.stopRingtone()
        try {
            val call = sinchServiceInterface!!.getCall(mCallId)
            if (call.details.isVideoOffered) {
                call.answer()
                val intent = Intent(this, VideoCallScreenActivity::class.java)
                intent.putExtra(SinchService.CALL_ID, mCallId)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_TASK_ON_HOME
                startActivity(intent)
            } else {
                call.answer()
                val intent = Intent(this, VoiceCallScreenActivity::class.java)
                intent.putExtra(SinchService.CALL_ID, mCallId)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_TASK_ON_HOME
                startActivity(intent)
            }
        } catch (e: Exception) {
            Toast.makeText(this, "unable to answer call", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
            finish()
        }

    }

    private fun declineClicked() {
        mAudioPlayer!!.stopRingtone()
        val call = sinchServiceInterface!!.getCall(mCallId)
        call.hangup()
        finish()
    }

    companion object {
        private const val TAG = "IncomingCallScreenActivity"
    }
}