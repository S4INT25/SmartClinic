package com.lucky.smartclinic.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.lucky.smartclinic.R
import com.lucky.smartclinic.ui.activities.HomeActivity
import com.lucky.smartclinic.ui.activities.MainActivity
import com.lucky.smartclinic.utils.FireStoreUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen)
{
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(4000L)
            try {
                if(FireStoreUtils.firebaseAuth.currentUser ==  null)
                {
                    view.findNavController().navigate(R.id.action_splashScreenFragment_to_logInFragment)
                } else{
                    val intentStartHomeActivity =  Intent(requireContext(),HomeActivity::class.java)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intentStartHomeActivity)
                    MainActivity().finish()
                }
            }catch (e:Exception)
            {
               e.printStackTrace()
            }

        }

        }
}