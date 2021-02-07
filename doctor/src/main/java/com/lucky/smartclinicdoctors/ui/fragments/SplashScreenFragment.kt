package com.lucky.smartclinicdoctors.ui.fragments
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.utils.FireBaseAuthUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen)
{
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        GlobalScope.launch(Dispatchers.Main) {
            delay(4000L)
            try {
                if(FireBaseAuthUtil.currentUser != null)
                {
                    findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
                }else
                {
                    findNavController().navigate(R.id.action_splashScreenFragment_to_logInFragment)
                }

            }catch (e:Exception)
            {
                e.printStackTrace()

            }

        }
    }
}