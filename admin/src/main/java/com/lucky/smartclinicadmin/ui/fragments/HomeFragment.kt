package com.lucky.smartclinicadmin.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lucky.smartclinicadmin.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment :Fragment(R.layout.fragment_home)
{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CV_patient.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_patientsListFragment)
        }
        CV_doctor.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_doctorListFragmentFragment)
        }
    }

}