package com.lucky.smartclinic.ui.fragments.home.doctor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.lucky.smartclinic.R

class AppointmentBottomSheet: BottomSheetDialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  layoutInflater.inflate(R.layout.make_appointment_sheet,container,false)
        return  view
    }
}