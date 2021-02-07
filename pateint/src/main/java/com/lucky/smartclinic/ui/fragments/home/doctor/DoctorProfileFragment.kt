package com.lucky.smartclinic.ui.fragments.home.doctor

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.lucky.smartclinic.R
import com.lucky.smartclinic.adaptors.HomeViewPagerAdaptor
import com.lucky.smartclinic.application.GlideApp
import com.lucky.smartclinic.utils.StorageUtil
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.doctor_profile_layout.*
import java.util.*


class DoctorProfileFragment : Fragment(R.layout.doctor_profile_layout) {
   private val args by navArgs<DoctorProfileFragmentArgs>()

    override fun onStart() {
        super.onStart()
        setUpTabLayOutWithViewPager()
      if (args.doctor.photoUrl.isNotBlank())
      {
          GlideApp.with(requireActivity())
              .load(StorageUtil.pathToReference(args.doctor.photoUrl))
              .into(imageViewDoctorProfile)
      }
        val fullName =  "${args.doctor.firstName} ${args.doctor.lastName}".toUpperCase(Locale.ROOT)
        TV_doctorName.text =  fullName
        TV_doctorProfession.text =  args.doctor.profession

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().toolbar.isVisible =  false
        requireActivity().toolbar.subtitle = ""
        imageViewDoctorBack.setOnClickListener {
            requireActivity().onBackPressed()
            requireActivity().toolbar.isVisible =  true
        }
        imageViewDoctorMessage.setOnClickListener{
            requireActivity().toolbar.isVisible =  true
            val action  =
                DoctorProfileFragmentDirections.actionDoctorProfileFragmentToChatFragment(
                    args.doctor
                )
            findNavController().navigate(action)
        }

    }

    private fun setUpTabLayOutWithViewPager() {
        val fragments= mutableListOf(ContactDetailsFragment(args.doctor), AboutDoctorFragment(args.doctor))
        tabs_view_pager.adapter = HomeViewPagerAdaptor(fragments,requireActivity().supportFragmentManager, lifecycle)
        TabLayoutMediator(doctortabs, tabs_view_pager) { tab, position ->
            when(position){
                0 -> tab.text = "Contact"
                1-> tab.text = "About"
            }
        }.attach()
    }


}