package com.lucky.smartclinicdoctors.ui.fragments.pateint

import android.app.AlertDialog
import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputLayout
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.application.GlideApp
import com.lucky.smartclinicdoctors.utils.FireStoreUtils
import com.lucky.smartclinicdoctors.utils.StorageUtil
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.patient_general_medical.*
import kotlinx.android.synthetic.main.patient_profile_layout.*


class PatientProfileFragment : Fragment(R.layout.patient_profile_layout) {
    private val args by navArgs<PatientProfileFragmentArgs>()
    private var shouldInitRecyclerView = true
    private lateinit var notesSection: Section

    override fun onStart() {
        super.onStart()

        textViewUsername.text = args.patient.firstName
        textViewUserProfession.text = args.patient.occupation
        TV_userGender.text = args.patient.sex
        TV_userDob.text = args.patient.dob
        TV_userBio.text = args.patient.bio
        TV_userAddress.text = args.patient.address
        TV_userPhoneNumber.text = args.patient.phoneNumber.toString()
        TV_userEmail.text = args.patient.email
        TV_patientAllergies.text = args.patient.allergies
        TV_patientProblems.text = args.patient.medicalProblem
        TV_patientMedication.text = args.patient.medication
        if (args.patient.photoUrl != null)
            GlideApp.with(this)
                .load(StorageUtil.pathToReference(args.patient.photoUrl!!))
                .placeholder(R.drawable.ic_baseline_person_pin_24)
                .into(imageViewUserProfile)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.patient.uid?.let { FireStoreUtils.getReportNotes(it, this::updateRecyclerView) }
        imageViewUserBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        IV_edit.setOnClickListener {
            showPopup(it)
        }

    }

    private fun updateRecyclerView(items: List<Item>) {
        if (items.isEmpty()) {
            Toast.makeText(requireContext(), "No Appointment Notes", Toast.LENGTH_SHORT).show()
        }
        fun init() {
            RV_notes.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = GroupAdapter<GroupieViewHolder>().apply {
                    notesSection = Section(items)
                    add(notesSection)
                }
            }
        }

        fun updateItems() = notesSection.update(items)
        if (shouldInitRecyclerView)
            init()
        else
            updateItems()
    }

    private fun showPopup(v: View) {
        val popup = PopupMenu(requireContext(), v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.update_patient_menu, popup.menu)
        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.update -> {
                    val view =
                        requireActivity().layoutInflater.inflate(R.layout.update_user_layout, null)
                    val builder = AlertDialog.Builder(requireContext()).apply {
                        setView(view)
                    }

                    val medication =
                        view.findViewById<TextInputLayout>(R.id.OTF_medication).editText?.text
                    val medicalProblems =
                        view.findViewById<TextInputLayout>(R.id.OTF_medicalProblems).editText?.text
                    val allergies =
                        view.findViewById<TextInputLayout>(R.id.OTF_allergies).editText?.text
                    builder.setPositiveButton("update") { dialogInterface, i ->
                        if (medication.isNullOrEmpty() and medicalProblems.isNullOrEmpty() and allergies.isNullOrEmpty()) {
                            Toast.makeText(
                                requireContext(),
                                "fill in the required fields",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            val data = mutableMapOf<String, Any>(
                                "medication" to medication.toString(),
                                "medicalProblem" to medicalProblems.toString(),
                                "allergies" to allergies.toString()
                            )
                            FireStoreUtils.updateUser(args.patient.uid!!, data)
                            {
                                if (it.isSuccessful) {
                                    TV_patientAllergies.text = allergies
                                    TV_patientProblems.text = medicalProblems
                                    TV_patientMedication.text = medication
                                    Toast.makeText(
                                        requireContext(),
                                        "updating user",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    Toast.makeText(
                                        requireContext(),
                                        "failed to update user",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }

                    }
                    builder.setNegativeButton("cancel") { dialogInterface, _ ->
                        dialogInterface.cancel()
                    }
                    builder.create()
                    builder.show()

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