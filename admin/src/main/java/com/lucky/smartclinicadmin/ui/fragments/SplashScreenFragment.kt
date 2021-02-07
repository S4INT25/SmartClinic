package com.lucky.smartclinicadmin.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.lucky.smartclinicadmin.R
import com.lucky.smartclinicadmin.utils.FireBaseAuthUtil
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(3000L)
                if (FireBaseAuthUtil.currentUser == null) {
                    findNavController().navigate(R.id.action_splashScreenFragment_to_startScreenFragment)
                }
                 else{
                    findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
                }

        }
    }

}