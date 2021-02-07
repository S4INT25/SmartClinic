package com.lucky.smartclinicadmin.ui.fragments.patients


import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.lucky.smartclinicadmin.R
import com.lucky.smartclinicadmin.application.GlideApp
import com.lucky.smartclinicadmin.utils.pathToReference
import kotlinx.android.synthetic.main.patient_profile_layout.*

class PatientProfileFragment : Fragment(R.layout.patient_profile_layout) {
    private val args by navArgs<PatientProfileFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        IV_edit.setOnClickListener {
            showPopup(it)
        }

        imageViewUserBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        val patient = args.patient
        try {
            if (patient.photoUrl.isNotBlank()) {
                GlideApp.with(requireActivity())
                    .load(pathToReference(patient.photoUrl))
                    .into(imageViewUserProfile)

            }
            (patient.firstName + " " + patient.lastName).also { textViewUsername.text = it }
            textViewUserAge.text = patient.dob
            textViewUserProfession.text = patient.occupation
            TV_userAddress.text = patient.address
            TV_userEmail.text = patient.email
            TV_userPhoneNumber.text = patient.phoneNumber.toString()
            "${patient.Height} METERS".also { TV_userHeight.text = it }
            "${patient.weight} KG".also { TV_userWeight.text = it }
            TV_userNrc.text = patient.nrcNumber
            TV_userUID.text = patient.uid
            TV_userBio.text = patient.dob

        } catch (e: Exception) {
            Toast.makeText(requireContext(), "something went wrong", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }

    }

    private fun showPopup(v: View) {
        val popup = PopupMenu(requireContext(), v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.edit_pateint_menu, popup.menu)
        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.MI_edit -> {
                    Toast.makeText(requireContext(), "haha", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.MI_delete -> {
                    Toast.makeText(requireContext(), "nice", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    Toast.makeText(requireContext(), "something went wrong", Toast.LENGTH_SHORT)
                        .show()
                    true
                }
            }

        }
        popup.show()

    }

}