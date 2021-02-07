package com.lucky.smartclinicdoctors.ui.fragments.appointments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.reclerview.items.AppointmentItem
import com.lucky.smartclinicdoctors.utils.FireStoreUtils
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.OnItemLongClickListener
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.fragment_appointments.*


class AppointmentsFragment : Fragment(R.layout.fragment_appointments) {

    private var shouldInitRecyclerView = true
    private lateinit var appointmentsSection: Section
    private val appointmentViewModel by viewModels<AppointmentViewModel>()

    override fun onResume() {
        super.onResume()
        shouldInitRecyclerView =  true
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SRL_appointmentRefresh.setOnRefreshListener {
            appointmentViewModel.appointments().observe(viewLifecycleOwner,this::updateRecyclerView)
            SRL_appointmentRefresh.isRefreshing = false
        }
        appointmentViewModel.appointments().observe(viewLifecycleOwner,this::updateRecyclerView)
    }



    private fun updateRecyclerView(items: List<Item>) {
        fun init() {
            if (items.isEmpty())
            {
                recyclerViewAppointments.isVisible = false
                TV_noappointments.isVisible =  true
            }
            recyclerViewAppointments.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = GroupAdapter<GroupieViewHolder>().apply {
                    appointmentsSection = Section(items)
                    add(appointmentsSection)
                    setOnItemLongClickListener(onItemLongClickListener)
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


    private val onItemLongClickListener =  OnItemLongClickListener{
        item, view ->
        if (item is AppointmentItem) {
            DeleteDialog(item.AppointmentId).show(parentFragmentManager,"delete")
        }
        true
    }


    companion object{
        private const val TAG = "AppointmentsFragment"
    }

class DeleteDialog(private val id:String) : DialogFragment()
    {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
           return activity.let {
               val builder = AlertDialog.Builder(it)
               builder.setTitle("Delete Appointment")
               builder.setMessage("do you want to delete this appointment ")
               builder.setPositiveButton("yes") { _, _ ->
                   FireStoreUtils.deletedAppointment(id,requireContext())
               }
               builder.setNegativeButton("no"){ dialog,_ ->
                   dialog.dismiss()
               }
               builder.create()
           }
        }
    }

}