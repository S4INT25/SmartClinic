package com.lucky.smartclinic.ui.fragments.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.lucky.smartclinic.R
import com.lucky.smartclinic.adaptors.HomeViewPagerAdaptor
import com.lucky.smartclinic.ui.fragments.home.doctor.DoctorsListFragment
import com.lucky.smartclinic.ui.fragments.home.news.NewsFragment
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTabLayOutWithViewPager()
    }
    private fun setUpTabLayOutWithViewPager() {
        val fragments= mutableListOf(NewsFragment(), DoctorsListFragment())
        tabs_view_pager.adapter = HomeViewPagerAdaptor(fragments,childFragmentManager, lifecycle)
        TabLayoutMediator(tl_fragments, tabs_view_pager) { tab, position ->
           when(position){
               0 -> tab.text ="News"
               1 -> tab.text ="Doctors"
           }
        }.attach()

    }
}