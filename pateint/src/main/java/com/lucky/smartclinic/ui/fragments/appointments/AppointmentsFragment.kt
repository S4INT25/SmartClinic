package com.lucky.smartclinic.ui.fragments.appointments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucky.smartclinic.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.fragment_appointment.*

class AppointmentsFragment : Fragment(R.layout.fragment_appointment) {
    
    private var shouldInitRecyclerView = true
    private lateinit var appointmentsSection: Section
    private val viewModel by viewModels<AppointmentsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            viewModel.getAppointments().observe(viewLifecycleOwner,this::updateRecyclerView)
        }catch (e:Exception)
        {
            Log.e(TAG, "onViewCreated: ${e.printStackTrace()}" )
        }

    }



    private fun updateRecyclerView(items: List<Item>) {
        fun init() {
            if(items.isEmpty())
            {
                textView3.text =  "No Appointments"
            }
            recyclerViewAppointments.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = GroupAdapter<GroupieViewHolder>().apply {
                    appointmentsSection = Section(items)
                    add(appointmentsSection)
                }
            }
            shouldInitRecyclerView = false
        }

        fun updateItems() = appointmentsSection.update(items)
        if (shouldInitRecyclerView)
            init()
        else
            updateItems()
    }

    companion object{
        private const val TAG = "AppointmentsFragment"
    }


}