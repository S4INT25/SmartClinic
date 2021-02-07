package com.lucky.smartclinicdoctors.ui.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.Timestamp
import com.google.firebase.iid.FirebaseInstanceId
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.application.GlideApp
import com.lucky.smartclinicdoctors.model.Doctor
import com.lucky.smartclinicdoctors.ui.fragments.appointments.AppointmentDialog
import com.lucky.smartclinicdoctors.ui.fragments.appointments.MyDatePickerDialog
import com.lucky.smartclinicdoctors.utils.FireBaseAuthUtil
import com.lucky.smartclinicdoctors.utils.FireStoreUtils
import com.lucky.smartclinicdoctors.utils.StorageUtil
import kotlinx.android.synthetic.main.fragment_sign_up.*
import java.io.ByteArrayOutputStream

class RegisterDoctorFragment : Fragment(R.layout.fragment_sign_up) {
    private lateinit var pdfUri: Uri
    private lateinit var selectedImageBytes: ByteArray
    private var profileJustChanged = false
    private var documentSelected = false
    private var deviceToken = mutableListOf<String>()
    private lateinit var myDatePickerDialog: MyDatePickerDialog


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myDatePickerDialog = MyDatePickerDialog()
        ET_dob.editText!!.isEnabled = false
        ET_dob.setStartIconOnClickListener {
            showDatePickerDialog()
        }

        val items = listOf("Male", "Female", "None")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        (ET_sex.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.physicians_list,
            R.layout.list_item
        ).apply {
            (ET_profession.editText as? AutoCompleteTextView)?.setAdapter(this)
        }

        sign_up_progress_bar.visibility = View.INVISIBLE
        selectHcpzDocument()
        selectProfileImage()

        BTN_register.setOnClickListener {
            try {
                //get device id
                deviceToken.clear()
                FirebaseInstanceId.getInstance().instanceId.addOnCompleteListener {
                    if (it.isSuccessful) {
                        deviceToken.add(it.result!!.token)
                    }
                }
                sign_up_progress_bar.isVisible = true
                BTN_register.isEnabled = false
                val firstName = ET_firstname.editText!!.text.toString()
                val lastName = ET_lastname.editText!!.text.toString()
                val sex = ET_sex?.editText!!.text.toString()
                val email = ET_email.editText!!.text.toString()
                val nrc = ET_nrc.editText!!.text.toString()
                val address = ET_address.editText!!.text.toString()
                val phoneNumber = user_phone_ET.editText!!.text.toString()
                val dob = ET_dob.editText!!.text.toString()
                val bio = ET_bio.editText!!.text.toString()
                val profession = ET_profession.editText!!.text.toString()
                val password = ET_password.editText!!.text.toString()
                val confirmPassword = ET_confirmPassword.editText!!.text.toString()
                if ((password == confirmPassword) and profileJustChanged and documentSelected) {
                    FireBaseAuthUtil.signUp(email, password) { firebaseUser ->
                        //save profile image
                        StorageUtil.uploadProfilePhoto(selectedImageBytes) { photoUrl ->
                            //save document
                            StorageUtil.uploadPdfFile(pdfUri) { hpczUrl ->
                                val doctor = Doctor(
                                    firebaseUser.uid,
                                    firstName,
                                    lastName,
                                    sex,
                                    dob,
                                    nrc,
                                    firebaseUser.email!!,
                                    phoneNumber,
                                    address,
                                    bio,
                                    profession,
                                    true,
                                    Timestamp.now().seconds,
                                    hpczUrl,
                                    photoUrl,
                                    false,
                                    deviceToken
                                )
                                //save user to fireStore db
                                addDoctorToFireStore(doctor)
                            }
                        }

                    }
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Failed to sign up... \n make sure you fill in all the fields",
                        Toast.LENGTH_LONG
                    ).show()
                    sign_up_progress_bar.isVisible = false
                    BTN_register.isEnabled = true
                }
            } catch (e: Exception) {
                Toast.makeText(
                    requireContext(),
                    "Failed to sign up... \n make sure you fill in all the fields",
                    Toast.LENGTH_LONG
                ).show()
                e.printStackTrace()
                sign_up_progress_bar.isVisible = true
                BTN_register.isEnabled = true
            }


        }

    }

    private fun selectHcpzDocument() {
        BTN_pdf.setOnClickListener {
            val intent = Intent().apply {
                type = "application/pdf"
                action = Intent.ACTION_GET_CONTENT
            }
            startActivityForResult(intent, RC_SELECT_PDF)
        }
    }

    private fun selectProfileImage() {
        IB_profile.setOnClickListener {
            val intent = Intent().apply {
                type = "image/*"
                action = Intent.ACTION_GET_CONTENT
                putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/jpeg", "image/png"))
            }
            startActivityForResult(Intent.createChooser(intent, "Select image"), RC_SELECT_IMAGE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_SELECT_PDF && resultCode == RESULT_OK && data != null) {
            pdfUri = data.data!!
            documentSelected = true
            TV_pdf.text = "okay"
        }
        if (requestCode == AppointmentDialog.RQC_DATE) {
            if (data != null) {
                ET_dob.editText!!.setText(data.getStringExtra("date"))
                ET_dob.editText!!.isEnabled = true
            }
        }
        saveAndLoadProfilePicture(requestCode, resultCode, data)
    }

    private fun saveAndLoadProfilePicture(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_SELECT_IMAGE && resultCode == RESULT_OK &&
            data != null && data.data != null
        ) {
            val selectedImagePath = data.data
            val selectedImageBmp = MediaStore.Images.Media
                .getBitmap(activity?.contentResolver, selectedImagePath)

            val outputStream = ByteArrayOutputStream()
            selectedImageBmp.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
            selectedImageBytes = outputStream.toByteArray()
            GlideApp.with(this)
                .load(selectedImageBytes)
                .into(circleImageView)
            profileJustChanged = true
        }
    }

    private fun addDoctorToFireStore(doctor: Doctor) {
        FireStoreUtils.initCurrentUserIfFirstTime(doctor)
        {
            Toast.makeText(requireContext(), "Account created logging in... ", Toast.LENGTH_SHORT)
                .show()
            sign_up_progress_bar.visibility = View.INVISIBLE
            findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
        }
    }

    private fun showDatePickerDialog() {
        this.parentFragmentManager.let {
            myDatePickerDialog.setTargetFragment(this, AppointmentDialog.RQC_DATE)
            myDatePickerDialog.show(it, "timePicker")
        }
    }

    companion object {
        private const val TAG = "RegisterDoctorFragment"
        private const val RC_SELECT_PDF = 44
        private const val RC_SELECT_IMAGE = 55
    }


}