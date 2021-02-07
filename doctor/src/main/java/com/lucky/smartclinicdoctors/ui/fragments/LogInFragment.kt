package com.lucky.smartclinicdoctors.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.iid.FirebaseInstanceId
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.service.MyFirebaseMessagingService
import com.lucky.smartclinicdoctors.utils.FireBaseAuthUtil
import kotlinx.android.synthetic.main.fragment_log_in.*
import kotlinx.android.synthetic.main.fragment_log_in.view.*

class LogInFragment : Fragment(R.layout.fragment_log_in) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar.isVisible =  false
        TV_signUp.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
        }

        login_btn.setOnClickListener {
            login_btn.isEnabled = false
            progressBar.isVisible =  true
            val email = view.TI_email.editText?.text.toString()
            val password = view.TI_password.editText?.text.toString()

                try {
                     FireBaseAuthUtil.login(email, password)
                    {
                        FirebaseInstanceId.getInstance().instanceId.addOnCompleteListener {
                            if (it.isSuccessful) {
                                MyFirebaseMessagingService.addTokenToFireStore(it.result!!.token)
                            }
                            progressBar.isVisible = false
                            findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
                        }
                    }
                } catch (e: Exception) {
                    login_btn.isEnabled = true
                    progressBar.isVisible = false
                    Toast.makeText(requireContext(), "something went wrong ${e.message}", Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }

        }

    }
    companion object {
        private val TAG = LogInFragment::class.java.name
    }
}