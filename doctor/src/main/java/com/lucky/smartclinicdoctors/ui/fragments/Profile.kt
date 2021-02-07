package com.lucky.smartclinicdoctors.ui.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.application.GlideApp
import com.lucky.smartclinicdoctors.utils.FireBaseAuthUtil
import com.lucky.smartclinicdoctors.utils.FireStoreUtils
import com.lucky.smartclinicdoctors.utils.StorageUtil
import kotlinx.android.synthetic.main.doctor_profile_layout.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream

class Profile : Fragment(R.layout.doctor_profile_layout)  {

    private lateinit var selectedImageBytes: ByteArray
    private var pictureJustChanged = false

    override fun onStart() {
        super.onStart()
        try{
            FireStoreUtils.getCurrentUser {
                textViewDoctorAddress.text =  it.address
                textViewDoctorAge.text =  it.dob
                textViewDoctorBio.text =  it.bio
                textViewDoctorName.text =  it.firstName
                textViewDoctorGender.text =  it.sex
                textViewUserProfession.text = it.profession
                if(it.photoUrl.isNotBlank())
                {
                    GlideApp.with(requireActivity())
                        .load(StorageUtil.pathToReference(it.photoUrl))
                        .placeholder(R.drawable.ic_profile)
                        .into(imageViewDoctorProfile)
                }

            }
        }catch (e:Exception)
        {
            e.printStackTrace()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageViewDoctorBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        BTN_logOut.setOnClickListener {
            FireBaseAuthUtil.firebaseAuth.signOut()
            Toast.makeText(requireContext(), "Logging out", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_profile_to_splashScreenFragment)

        }
        selectProfileImage()
    }
    private fun selectProfileImage() {
        imageViewDoctorProfile.setOnClickListener {
            val intent = Intent().apply {
                type = "image/*"
                action = Intent.ACTION_GET_CONTENT
                putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/jpeg", "image/png"))
            }
            startActivityForResult(Intent.createChooser(intent, "Select image"), RC_SELECT_IMAGE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        saveAndLoadProfilePicture(requestCode,resultCode,data)
    }

    private fun saveAndLoadProfilePicture(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_SELECT_IMAGE && resultCode == Activity.RESULT_OK &&
            data != null && data.data != null) {
            val selectedImagePath = data.data
            val selectedImageBmp = MediaStore.Images.Media
                .getBitmap(activity?.contentResolver, selectedImagePath)

            val outputStream = ByteArrayOutputStream()
            selectedImageBmp.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
            selectedImageBytes = outputStream.toByteArray()
            GlideApp.with(this)
                .load(selectedImageBytes)
                .into(imageViewDoctorProfile)

            pictureJustChanged = true
            //save image to firebase and update user profile image url
            GlobalScope.launch {
                 StorageUtil.uploadProfilePhoto(selectedImageBytes){
                    FireStoreUtils.updateCurrentUser(it)
                }

            }

        }
    }


    companion object{
        const val TAG = "PROFILE FRAGMENT"
        const val RC_SELECT_IMAGE = 1
    }
}