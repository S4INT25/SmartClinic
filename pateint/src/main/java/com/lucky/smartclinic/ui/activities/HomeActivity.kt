package com.lucky.smartclinic.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import com.lucky.smartclinic.R
import com.lucky.smartclinic.application.GlideApp
import com.lucky.smartclinic.model.Patient
import com.lucky.smartclinic.service.SinchService
import com.lucky.smartclinic.ui.fragments.chats.ChatFragment
import com.lucky.smartclinic.utils.FireStoreUtils
import com.lucky.smartclinic.utils.StorageUtil
import com.sinch.android.rtc.SinchError
import kotlinx.android.synthetic.main.nav_header_main.*

class HomeActivity : BaseActivity(),
    SinchService.StartFailedListener,
    ChatFragment.SinchCallListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var headers: MutableMap<String, String>
    private lateinit var patient:Patient

    override fun onResume() {
        super.onResume()
            headers = HashMap()
        try {
            FireStoreUtils.getCurrentUser({
                patient =  it
                headers["callerName"] = "${it.firstName}  ${it.lastName} "
                setProfilePicInNavHeader()
            },
                { error ->
                    Toast.makeText(this, "user not found", Toast.LENGTH_SHORT).show()

                    Log.e(TAG, "onResume: ${error.printStackTrace()}" )
                })

        } catch (e: Exception) {
            Log.e(TAG, "onStart: ${e.printStackTrace()}")
            return
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.homeNavigationView)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_profile, R.id.nav_chats, R.id.nav_appointment
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun setProfilePicInNavHeader() {
        try {
            GlideApp.with(this)
                .load(patient.photoUrl?.let { photoPath ->
                    StorageUtil.pathToReference(photoPath) })
                .placeholder(R.drawable.ic_baseline_person_pin_24)
                .into(navHeaderProfilePic)
            userName_TV.text = patient.firstName
            userEmailAdress_TV.text = patient.email
        } catch (e: Exception) {
            Log.e(TAG, "setProfilePicInNavHeader: ${e.printStackTrace()}")
            return
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    override fun onStarted() {
        Log.d(TAG, "onStarted: sinch service started")
    }

    override fun onStartFailed(error: SinchError) {
        Log.e(TAG, "onStartFailed  ${error.message}")
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        try {
            sinchServiceInterface!!.startClient(FireStoreUtils.firebaseAuth.currentUser!!.uid)
            sinchServiceInterface!!.setStartListener(this)
        } catch (e: Exception) {
            Log.d(TAG, "onServiceConnected: ${e.printStackTrace()}")
            return
        }

    }

    override fun makeCall(id: String, name: String, callType: Int) {
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
                    Log.e(TAG, "makeCall: ${e.printStackTrace()}")
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
                    Log.e(TAG, "makeCall: ${e.printStackTrace()}")
                    return
                }
            }

        }

    }

    override fun onStop() {
       updateStatusAndSetLastSeen()
        super.onStop()
    }

    private fun updateStatusAndSetLastSeen()
    {
        try {
            FireStoreUtils.updateOnlineStatus(false)

        } catch (e: Exception) {

            Log.e(TAG, "onStop: ${e.printStackTrace()}")
            return
        }
    }

    companion object {
        private const val TAG = "HomeActivity"
    }

}