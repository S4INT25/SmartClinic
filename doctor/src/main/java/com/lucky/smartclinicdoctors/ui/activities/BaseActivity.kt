package com.lucky.smartclinicdoctors.ui.activities

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.os.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.lucky.smartclinicdoctors.service.SinchService

abstract class BaseActivity : AppCompatActivity(), ServiceConnection {

    var sinchServiceInterface: SinchService.SinchServiceInterface? = null

    override fun onStart() {
        super.onStart()
        bindService()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
//        window.addFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//                    or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
//                    or WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
//                    or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
//                    or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
//        )
    }

    override fun onServiceConnected(componentName: ComponentName, iBinder: IBinder) {
        if (SinchService::class.java.name == componentName.className) {
            sinchServiceInterface = iBinder as SinchService.SinchServiceInterface
            onServiceConnected()
        }
    }

    override fun onServiceDisconnected(componentName: ComponentName) {
        if (SinchService::class.java.name == componentName.className) {
            sinchServiceInterface = null
            onServiceDisconnected()
        }
    }

    protected open fun onServiceConnected() {
        // for subclasses
    }

    private fun onServiceDisconnected() {
        // for subclasses
    }

    private val handlerThread =  HandlerThread("Messenger").apply { start() }

    private val handler =  object : Handler(handlerThread.looper){
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                SinchService.MESSAGE_PERMISSIONS_NEEDED -> {
                    val bundle = msg.data
                    val requiredPermission = bundle.getString(SinchService.REQUIRED_PERMISSION)
                    ActivityCompat.requestPermissions(this@BaseActivity, arrayOf(requiredPermission), 0)
                }
            }
        }
    }

    private val messenger = Messenger(handler)

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        var granted = grantResults.isNotEmpty()
        for (grantResult in grantResults) {
            granted = granted and (grantResult == PackageManager.PERMISSION_GRANTED)
        }
        if (granted) {
            Toast.makeText(this, "You may now place a call", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(
                this,
                "This application needs permission to use your microphone and camera to function properly.",
                Toast.LENGTH_LONG
            ).show()
        }
        sinchServiceInterface!!.retryStartAfterPermissionGranted()
    }

    private fun bindService() {
        val serviceIntent = Intent(this, SinchService::class.java)
        serviceIntent.putExtra(SinchService.MESSENGER, messenger)
        applicationContext.bindService(serviceIntent, this, BIND_AUTO_CREATE)
    }
}