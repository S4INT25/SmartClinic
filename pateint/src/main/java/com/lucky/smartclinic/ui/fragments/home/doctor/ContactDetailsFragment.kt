package com.lucky.smartclinic.ui.fragments.home.doctor

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.lucky.smartclinic.R
import com.lucky.smartclinic.model.Doctor
import kotlinx.android.synthetic.main.fragment_contact_details.*


class ContactDetailsFragment(val doctor: Doctor) : Fragment(R.layout.fragment_contact_details) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TV_address.text =  doctor.address
        TV_PhoneNumber.text =  doctor.phoneNumber
        TV_email.text =  doctor.email
    }
}