package com.lucky.smartclinic.ui.activities

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.lucky.smartclinic.R


class MainActivity :AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.activity_main)
    }

}


