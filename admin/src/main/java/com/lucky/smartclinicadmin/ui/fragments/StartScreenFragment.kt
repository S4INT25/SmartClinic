package com.lucky.smartclinicadmin.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lucky.smartclinicadmin.R
import com.lucky.smartclinicadmin.utils.FireBaseAuthUtil
import kotlinx.android.synthetic.main.fragment_start_screenragment.*


class StartScreenFragment : Fragment(R.layout.fragment_start_screenragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        BTN_login.setOnClickListener {
            progressBar.isVisible =  true
            val email =  ET_adminEmail.editText?.text.toString()
            val password =  ET_adminPassword.editText?.text.toString()
            if(email.isNotEmpty() and password.isNotEmpty() and (email == "admin@gmail.com") and (password == "password"))
            {
                    FireBaseAuthUtil.login(email, password){
                       findNavController().navigate(R.id.action_startScreenFragment_to_homeFragment)
                   }
//                FireBaseAuthUtil.signUp(email, password){
//                       findNavController().navigate(R.id.action_startScreenFragment_to_homeFragment)
//                   }
            }else{
                Toast.makeText(requireContext(), "Email or password cannot be empty", Toast.LENGTH_SHORT).show()
                progressBar.isVisible =  false
            }
        }

    }
}