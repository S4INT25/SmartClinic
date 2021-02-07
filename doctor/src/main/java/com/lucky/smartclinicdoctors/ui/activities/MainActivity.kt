package com.lucky.smartclinicdoctors.ui.activities


import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.firebase.Timestamp
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.model.Appointment
import com.lucky.smartclinicdoctors.model.Doctor
import com.lucky.smartclinicdoctors.model.DoctorsNote
import com.lucky.smartclinicdoctors.service.SinchService
import com.lucky.smartclinicdoctors.ui.fragments.appointments.AppointmentDialog
import com.lucky.smartclinicdoctors.ui.fragments.appointments.DoctorsNoteDialog
import com.lucky.smartclinicdoctors.ui.fragments.pateint.ChatFragment
import com.lucky.smartclinicdoctors.utils.FireBaseAuthUtil
import com.lucky.smartclinicdoctors.utils.FireStoreUtils
import com.sinch.android.rtc.SinchError
import java.util.*


class MainActivity : BaseActivity(),
    SinchService.StartFailedListener,
    ChatFragment.SinchCallListener,
    AppointmentDialog.AppointmentDialogListener,
    DoctorsNoteDialog.DoctorNoteDialogListener {
    private lateinit var doctor: Doctor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        if (isConnected)
        {
            try {
                FireStoreUtils.updateOnlineStatus(true)
                FireStoreUtils.getCurrentUser {
                    doctor =  it
                }
            }catch (e:Exception)
            {
                Log.e(TAG, "onCreate: ${e.printStackTrace()}" )
            }

        }else{
            Toast.makeText(this, "you have no active internet connection", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStarted() {
        Log.d(TAG, "onStarted: sinch service started")
    }

    override fun onStartFailed(error: SinchError?) {
        if (error != null) {
            Log.e(TAG, "onStartFailed  ${error.message}")
        }
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        try {
            try {
                sinchServiceInterface!!.startClient(FireBaseAuthUtil.currentUser!!.uid)
            } catch (e: Exception) {
                Log.d(TAG, "onServiceConnected: ${e.message}")
            }
            sinchServiceInterface!!.setStartListener(this)
        } catch (e: Exception) {
            e.printStackTrace()
            return
        }

    }


    override fun makeCall(id: String, name: String, callType: Int) {
        val headers: MutableMap<String, String> = HashMap()
        headers["callerName"] = doctor.firstName
        when (callType) {
            ChatFragment.VIDEO_CALL -> {
                try {
                    val callId = sinchServiceInterface!!.callUserVideo(id, headers)!!.callId
                    Intent(this, VideoCallScreenActivity::class.java).apply {
                        putExtra(SinchService.CALL_ID, callId)
                        putExtra("userName", name)
                        startActivity(this)
                    }

                } catch (e: Exception) {
                    Toast.makeText(this, "failed to make call", Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                    return
                }

            }
            ChatFragment.VOICE_CALL -> {
                try {
                    val callId = sinchServiceInterface!!.callUser(id, headers)!!.callId
                     Intent(this, VoiceCallScreenActivity::class.java).apply {
                        putExtra(SinchService.CALL_ID, callId)
                        putExtra("userName", name)
                        startActivity(this)
                    }

                } catch (e: Exception) {
                    Toast.makeText(this, "failed to make call", Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                    return
                }
            }
        }

    }

    override fun onStop() {
        try {
            FireStoreUtils.setLastSeen(Timestamp.now().seconds)
            FireStoreUtils.updateOnlineStatus(false)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        super.onStop()
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onDialogPositiveClick(dialog: DialogFragment, data: Intent) {
        saveAppointmentToFireStore(data, doctor)
    }

    private fun saveAppointmentToFireStore(data: Intent, doc: Doctor) {
        val doctorName = "${doc.firstName} ${doc.lastName}"
        try {
            val note = data.getStringExtra("note")
            val patientName = data.getStringExtra("patient")
            val date = data.getStringExtra("date")
            val time = data.getStringExtra("time")
            val patientsUid = data.getStringExtra("uid")
            val patientPhotoUrl = data.getStringExtra("photoUrl")
            val type = data.getStringExtra("type")
            val clinic = data.getStringExtra("clinic")
            val location = data.getStringExtra("location")
            val appointment = Appointment(
                doctorName,
                doc.photoUrl,
                patientName!!,
                patientPhotoUrl!!,
                clinic!!,
                location!!,
                note!!,
                date!!,
                time!!,
                type!!,
            )
            FireStoreUtils.addAppointment(appointment, patientsUid!!)
            Toast.makeText(this, "Appointment added", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "something went wrong failed to add appointment",
                Toast.LENGTH_SHORT
            ).show()
            e.printStackTrace()
            return
        }
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
    }


    override fun onDialogNotePositiveClick(dialog: DialogFragment, data: Intent) {
        saveAppointmentNote(data)
    }

    private fun saveAppointmentNote(data: Intent) {
        try {
            val patientsUid = data.getStringExtra("uid")
            val doctorName = data.getStringExtra("doctorName")
            val doctorEmail = data.getStringExtra("doctorEmail")
            val doctorPhone = data.getStringExtra("doctorPhone")
            val doctorTitle = data.getStringExtra("doctorTitle")
            val doctorDob = data.getStringExtra("doctorDob")
            val date = data.getStringExtra("date")
            val clinic = data.getStringExtra("clinicName")
            val diagnosis = data.getStringExtra("diagnosis")
            val prescription = data.getStringExtra("prescription")
            val appointmentReport = DoctorsNote(
                doctorName!!,
                doctorEmail!!,
                doctorPhone!!,
                doctorTitle!!,
                doctorDob!!,
                diagnosis!!,
                prescription!!,
                clinic!!,
                date!!
            )
            FireStoreUtils.addReportNote(this, appointmentReport, patientsUid!!)
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }


    }

    override fun onDialogNoteNegativeClick(dialog: DialogFragment) {
    }


}


