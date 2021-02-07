package com.lucky.smartclinic.ui.fragments.home.doctor

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.lucky.smartclinic.R
import com.lucky.smartclinic.model.Doctor
import kotlinx.android.synthetic.main.fragment_about_docotor.*

class AboutDoctorFragment(val doctor: Doctor) : Fragment(R.layout.fragment_about_docotor) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TV_about.text =  doctor.bio
    }
}