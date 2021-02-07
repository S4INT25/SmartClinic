package com.lucky.smartclinicadmin.adaptors

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdaptor(private val fragments: MutableList<Fragment>, fm: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(fm,lifecycle ) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}