package com.lucky.smartclinic.ui.fragments

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import com.google.android.material.textfield.TextInputLayout
import com.lucky.smartclinic.R
import com.lucky.smartclinic.application.GlideApp
import com.lucky.smartclinic.ui.fragments.profile.ProfileFragment
import com.lucky.smartclinic.utils.FireStoreUtils
import com.lucky.smartclinic.utils.StorageUtil
import java.io.ByteArrayOutputStream


class UpdateUserDetailsFragment : DialogFragment(){

    private lateinit var selectedImageBytes: ByteArray
    private var pictureJustChanged = false
    private lateinit var profileImage:ImageView

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let { FragmentActivity ->
            val view = requireActivity().layoutInflater.inflate(R.layout.fragment_update_user_details, null)
            profileImage =  view.findViewById(R.id.circleImageView)
            val profileBtn =  view.findViewById<ImageButton>(R.id.IB_profile)
            val progressBar =  view.findViewById<ProgressBar>(R.id.progressBar2)
            val updateButton =  view.findViewById<Button>(R.id.BTN_update)
            profileBtn.setOnClickListener{
                val intent = Intent().apply {
                    type = "image/*"
                    action = Intent.ACTION_GET_CONTENT
                    putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/jpeg", "image/png"))
                }
                startActivityForResult(Intent.createChooser(intent, "Select image"),
                    ProfileFragment.RC_SELECT_IMAGE
                )
            }

            updateButton.setOnClickListener {
                if(view.findViewById<TextInputLayout>(R.id.ET_phoneNumber).editText?.text.isNullOrEmpty()
                    && view.findViewById<TextInputLayout>(R.id.ET_weight).editText?.text.isNullOrEmpty()
                    && view.findViewById<TextInputLayout>(R.id.ET_height).editText?.text.isNullOrEmpty()
                ){
                    Toast.makeText(requireContext(), "Fill in the required fields", Toast.LENGTH_SHORT).show()
                    progressBar.isVisible =  false

                }else{
                    progressBar.isVisible =  true
                    updateUser(view, progressBar)
                    }
            }

            val builder = AlertDialog.Builder(FragmentActivity).apply {
                setView(view)
                setMessage("Add Required Details")
            }
            builder.create()
        }?: throw IllegalStateException("Activity cannot be null")
    }

    private fun updateUser(view: View, progressBar: ProgressBar) {

        try {
            val firstName =
                view.findViewById<TextInputLayout>(R.id.ET_firstname).editText!!.text.toString()
            val lastName =
                view.findViewById<TextInputLayout>(R.id.ET_lastname).editText!!.text.toString()
            val phoneNumber =
                view.findViewById<TextInputLayout>(R.id.ET_phoneNumber).editText?.text.toString().toLong()
            val nrcNumber =
                view.findViewById<TextInputLayout>(R.id.ET_nrc).editText!!.text.toString()
            val address =
                view.findViewById<TextInputLayout>(R.id.ET_address).editText!!.text.toString()
            val weight =
                view.findViewById<TextInputLayout>(R.id.ET_weight).editText?.text.toString()
                    .toDouble()
            val height =
                view.findViewById<TextInputLayout>(R.id.ET_height).editText?.text.toString()
                    .toDouble()
            val dob =
                view.findViewById<TextInputLayout>(R.id.ET_dob).editText!!.text.toString()
            val bio =
                view.findViewById<TextInputLayout>(R.id.ET_bio).editText!!.text.toString()
            val occupation =
                view.findViewById<TextInputLayout>(R.id.ET_profession).editText!!.text.toString()
            val sex =
                view.findViewById<TextInputLayout>(R.id.ET_sex).editText!!.text.toString()

            StorageUtil.uploadProfilePhoto(selectedImageBytes) {
                progressBar.isVisible = true
                FireStoreUtils.updateCurrentUser(
                    requireContext(),
                    firstName,
                    lastName,
                    phoneNumber,
                    nrcNumber,
                    dob,
                    sex,
                    address,
                    bio,
                    occupation,
                    weight,
                    height,
                    it
                )
                {
                    Toast.makeText(requireContext(), "updated", Toast.LENGTH_SHORT).show()
                    progressBar.isVisible = false
                    this.dismiss()
                }
            }
        }catch (e:Exception)
        {
            Toast.makeText(requireContext(), "something went wrong make sure all field are provided", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
            progressBar.isVisible = false
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
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
            try {
                GlideApp.with(requireActivity())
                    .load(selectedImageBytes).into(profileImage)
                pictureJustChanged = true

            }catch (e:Exception)
            {
                e.printStackTrace()
            }

        }
    }


companion object{
    private const val TAG = "UpdateUserDetailsFragment"
    const val RC_SELECT_IMAGE = 1
}
}