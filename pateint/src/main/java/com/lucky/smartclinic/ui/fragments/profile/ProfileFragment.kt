package com.lucky.smartclinic.ui.fragments.profile
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lucky.smartclinic.R
import com.lucky.smartclinic.application.GlideApp
import com.lucky.smartclinic.ui.activities.MainActivity
import com.lucky.smartclinic.utils.FireStoreUtils
import com.lucky.smartclinic.utils.StorageUtil
import kotlinx.android.synthetic.main.user_profile_layout.*

class ProfileFragment : Fragment(R.layout.user_profile_layout) {

    private var pictureJustChanged = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val model:ProfileViewModel  by viewModels()
        try {
            model.getUser().observe(viewLifecycleOwner){user->
                textViewUsername.text =  user.firstName
                textViewUserProfession.text = user.occupation
                textViewUserGender.text =  user.sex
                textViewUserAge.text = user.dob
                textViewUserAddress.text = user.bio
                if (!pictureJustChanged && user.photoUrl != null)
                    GlideApp.with(this)
                        .load(StorageUtil.pathToReference(user.photoUrl))
                        .placeholder(R.drawable.ic_baseline_person_pin_24)
                        .into(imageViewUserProfile)
            }
        }catch (e:Exception)
        {
            Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT).show()
        }


        SignOutBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Signing out....", Toast.LENGTH_SHORT).show()
            FireStoreUtils.firebaseAuth.signOut()
            val intentStartMainActivity =  Intent(requireContext(), MainActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intentStartMainActivity)
        }


    }

    companion object{
        const val TAG = "PROFILE FRAGMENT"
        const val RC_SELECT_IMAGE = 1
    }
}