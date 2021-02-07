package com.lucky.smartclinicadmin.ui.activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lucky.smartclinicadmin.R


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}


