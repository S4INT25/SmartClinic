package com.lucky.smartclinic.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.iid.FirebaseInstanceId
import com.lucky.smartclinic.R
import com.lucky.smartclinic.service.MyFirebaseMessagingService
import com.lucky.smartclinic.ui.activities.HomeActivity
import com.lucky.smartclinic.utils.FireStoreUtils
import kotlinx.android.synthetic.main.fragment_log_in.*
import kotlinx.android.synthetic.main.fragment_log_in.view.*

class LogInFragment : Fragment(R.layout.fragment_log_in) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.login_btn.setOnClickListener {
            login_btn.isEnabled = false
            user_Email_edit_text.isErrorEnabled = false
            user_password_edit_text.isErrorEnabled = false
            view.progressBar.isVisible = true
            val email = view.user_Email_edit_text.editText?.text.toString()
            val password = view.user_password_edit_text.editText?.text.toString()
            if (email.isNotBlank() and password.isNotBlank()) {
                try {
                    loginUser(email, password)
                } catch (e: Exception) {
                    progressBar.isVisible = false
                    login_btn.isEnabled = true
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            } else {
                login_btn.isEnabled = true
                user_Email_edit_text.error = "required"
                user_password_edit_text.error = "required"
                view.progressBar.isVisible = false
            }


        }
        //go to login page
        textViewSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
        }
    }

    private fun loginUser(email: String, password: String) {
        FireStoreUtils.firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    //add device token
                    FirebaseInstanceId.getInstance().instanceId.addOnCompleteListener {
                        if (it.isSuccessful) {
                            MyFirebaseMessagingService.addTokenToFireStore(it.result!!.token)
                        }
                        val intentStartHomeActivity =
                            Intent(requireContext(), HomeActivity::class.java)
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intentStartHomeActivity)
                    }

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        requireContext(), "Authentication failed ${task.exception!!.message}.",
                        Toast.LENGTH_SHORT
                    ).show()
                    progressBar.isVisible = false
                    login_btn.isEnabled = true
                }

            }
    }

    companion object {
        private const val TAG = "LogInFragment"
    }
}