package com.lucky.smartclinic.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.firebase.iid.FirebaseInstanceId
import com.lucky.smartclinic.R
import com.lucky.smartclinic.model.Patient
import com.lucky.smartclinic.ui.activities.HomeActivity
import com.lucky.smartclinic.utils.FireStoreUtils
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.ButtonCreateAccount.setOnClickListener {
            ButtonCreateAccount.isEnabled = false
            ProgressBarSignUp.isVisible = true
            val userName = user_name_edit_text.editText?.text.toString()
            val emailAddress = user_Email_edit_text.editText?.text.toString()
            val password = user_password_edit_text.editText?.text.toString()
            if (userName.isNotBlank() and emailAddress.isNotBlank() and password.isNotBlank()) {
                registerUser(userName, emailAddress, password)
            } else {
                Toast.makeText(requireContext(), "Fill in the required fields ", Toast.LENGTH_LONG)
                    .show()
                ProgressBarSignUp.isVisible = false
                ButtonCreateAccount.isEnabled = true
            }

        }

    }


    private fun registerUser(userName: String, emailAddress: String, password: String) {
        FireStoreUtils.firebaseAuth.createUserWithEmailAndPassword(emailAddress, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // add user to fireStore db
                    createUser(
                        FireStoreUtils.firebaseAuth.currentUser!!.uid,
                        userName,
                        emailAddress
                    )
                } else {
                    Toast.makeText(requireContext(), task.exception.toString(), Toast.LENGTH_SHORT)
                        .show()
                    task.exception?.printStackTrace()
                    ButtonCreateAccount.isEnabled = true
                    ProgressBarSignUp.isVisible = false
                }
            }
    }

    private fun createUser(uid: String?, userName: String, emailAddress: String) {
        val tokens = mutableListOf<String>()
        FirebaseInstanceId.getInstance().instanceId.addOnCompleteListener {
            if (it.isSuccessful) {
                tokens.add(it.result!!.token)
            }
            FireStoreUtils.initCurrentUserIfFirstTime(
                Patient(
                    uid,
                    userName,
                    "",
                    "",
                    emailAddress,
                    0,
                    "",
                    "",
                    "",
                    0.0,
                    0.0,
                    "",
                    "",
                    "",
                    true,
                    0,
                    null,
                    tokens
                )
            )
            {
                val intentStartHomeActivity = Intent(requireContext(), HomeActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intentStartHomeActivity)
                ProgressBarSignUp.isVisible = false
            }
        }
    }
}