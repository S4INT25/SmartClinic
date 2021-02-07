package com.lucky.smartclinicadmin.ui.fragments.doctors

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.lucky.smartclinicadmin.R
import com.lucky.smartclinicadmin.application.GlideApp
import com.lucky.smartclinicadmin.utils.*
import kotlinx.android.synthetic.main.doctor_profile.*
import kotlinx.android.synthetic.main.tool_bar.*

class DoctorProfile : Fragment(R.layout.doctor_profile) {
    private val args by navArgs<DoctorProfileArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toolbar.inflateMenu(R.menu.doctor_profile)
        if (args.doctor.verified) {
            Toolbar.menu.removeItem(R.id.MI_approve)

        }
        Toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        updateUser()

        Toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.MI_edit -> {
                    BT_update.isVisible = true
                    OTF_doctorEmail.editText?.isEnabled = true
                    OTF_doctorPhoneNumber.editText?.isEnabled = true
                    OTF_doctorAddress.editText?.isEnabled = true
                    true
                }

                R.id.MI_approve -> {
                    val data =  mutableMapOf<String,Any>("verified" to true)
                    verifyDoctor(requireContext(),args.doctor.uid,data)
                    Toast.makeText(requireContext(), "approved", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.MI_delete -> {
                    val dialog = AlertDialog.Builder(requireContext())
                    dialog.setTitle("Delete User")
                    dialog.setMessage("Are you sure you want to delete this User")
                    dialog.setPositiveButton("delete") { _, _ ->
                       deleteDoctor(args.doctor.uid) {
                            if (it.isSuccessful) {
                                PB_doctor.isVisible = false
                                Toast.makeText(requireContext(), "User Deleted", Toast.LENGTH_SHORT)
                                    .show()
                                findNavController().navigate(R.id.action_doctorProfileFragment_to_homeFragment)
                            } else {
                                PB_doctor.isVisible = false
                                Toast.makeText(
                                    requireContext(),
                                    "failed to delete User",
                                    Toast.LENGTH_SHORT
                                ).show()
                                PB_doctor.isVisible = false
                            }
                        }


                    }
                    dialog.setNegativeButton(
                        "cancel"
                    ) { dialogInterface, i ->
                        dialogInterface.dismiss()
                        PB_doctor.isVisible = false
                    }
                    dialog.show()
                    true
                }

                else -> {
                    Toast.makeText(requireContext(), "mmmmm", Toast.LENGTH_SHORT).show()
                    false
                }
            }
        }
        val fullName = "DR.${args.doctor.firstName} ${args.doctor.lastName}"
        OTF_doctorAddress.editText!!.setText(args.doctor.address)
        OTF_doctorFullName.editText!!.setText(fullName)
        OTF_doctorDob.editText!!.setText(args.doctor.dob)
        OTF_doctorEmail.editText!!.setText(args.doctor.email)
        OTF_doctorGender.editText!!.setText(args.doctor.sex)
        OTF_doctorPhoneNumber.editText!!.setText(args.doctor.phoneNumber)
        TV_doctor_bio.text = args.doctor.bio
        GlideApp.with(requireContext())
            .load(pathToReference(args.doctor.photoUrl))
            .placeholder(R.drawable.ic_doctor)
            .into(IV_doctorProfilePic)
    }

    private fun updateUser() {
        BT_update.setOnClickListener {
            PB_doctor.isVisible = true
            BT_update.isVisible = false
            val number = OTF_doctorPhoneNumber.editText?.text
            val email = OTF_doctorEmail.editText?.text
            val address = OTF_doctorAddress.editText?.text
            if (number.isNullOrEmpty() && email.isNullOrEmpty() and address.isNullOrEmpty()) {
                PB_doctor.isVisible = false
                OTF_doctorAddress.error = "can't be empty"
                OTF_doctorPhoneNumber.error = "can't be empty"
                OTF_doctorEmail.error = "can't be empty"
                return@setOnClickListener

            } else {
                val data = mutableMapOf<String, Any>(
                    "phoneNumber" to number.toString(),
                    "email" to email.toString(),
                    "address" to address.toString()
                )
               updateDoctor(args.doctor.uid, data) {
                    if (it.isSuccessful) {
                        PB_doctor.isVisible = false
                        OTF_doctorEmail.editText?.isEnabled = false
                        OTF_doctorPhoneNumber.editText?.isEnabled = false
                        OTF_doctorAddress.editText?.isEnabled = false
                        Toast.makeText(requireContext(), "Updated", Toast.LENGTH_SHORT).show()
                    } else {
                        PB_doctor.isVisible = false
                        BT_update.isVisible = true
                        Toast.makeText(
                            requireContext(),
                            "${it.exception!!.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

        }
    }

    companion object {
        private const val TAG = "DoctorProfile"
    }


}