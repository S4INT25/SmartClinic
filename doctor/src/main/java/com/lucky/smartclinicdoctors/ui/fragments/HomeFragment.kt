package com.lucky.smartclinicdoctors.ui.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.adaptors.ViewPagerAdaptor
import com.lucky.smartclinicdoctors.ui.fragments.appointments.AppointmentsFragment
import com.lucky.smartclinicdoctors.ui.fragments.pateint.PatientsListFragment
import com.lucky.smartclinicdoctors.utils.FireStoreUtils
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.main_app_bar.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     try{
         FireStoreUtils.getCurrentUser { doctor ->
             homeTopAppBar.title = "Smart Clinic"
             if(doctor.verified)
             {
                 TV_verified.isVisible =  false
                 setUpTabLayOutWithViewPager()
                 homeTopAppBar.setOnMenuItemClickListener {
                     when (it.itemId){
                         R.id.profile -> {
                             val action = HomeFragmentDirections.actionHomeFragmentToProfile2(doctor)
                             findNavController().navigate(action)
                             true}
                         else -> { Toast.makeText(requireContext(), "nope", Toast.LENGTH_SHORT).show()
                             true}
                     }
                 }
             }else{
                 Toast.makeText(requireContext(), "Wait until verified", Toast.LENGTH_LONG).show()
                 TV_verified.isVisible =  true
             }
         }

     }catch (e: NullPointerException)
     {
        //findNavController().navigate()
     }


    }
    private fun setUpTabLayOutWithViewPager() {

        val fragments= mutableListOf(PatientsListFragment(), AppointmentsFragment())
        tabs_view_pager.adapter = ViewPagerAdaptor(fragments,childFragmentManager, lifecycle)
        TabLayoutMediator(tabs, tabs_view_pager) { tab, position ->
            when(position){
                0 -> tab.text = "Patients"
                1-> tab.text = "Appointment"
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu,menu)
    }

    companion object
    {
        private const val TAG = "HomeFragment"
    }

}