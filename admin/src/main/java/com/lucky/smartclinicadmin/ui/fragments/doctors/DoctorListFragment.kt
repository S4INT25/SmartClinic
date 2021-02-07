package com.lucky.smartclinicadmin.ui.fragments.doctors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ListenerRegistration
import com.lucky.smartclinicadmin.R
import com.lucky.smartclinicadmin.items.DoctorItem
import com.lucky.smartclinicadmin.utils.getDoctorsListenerRegistration
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.fragment_doctors_list.*
import kotlinx.android.synthetic.main.tool_bar.*

class DoctorListFragmentFragment : Fragment(R.layout.fragment_doctors_list) {

    private lateinit var doctorListenerRegistration: ListenerRegistration
    private var shouldInitRecyclerView = true
    private lateinit var doctorsSection: Section


    override fun onResume() {
        super.onResume()
        Toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        Toolbar.menu.removeItem(R.id.MI_edit)
        Toolbar.menu.removeItem(R.id.MI_approve)
        Toolbar.menu.removeItem(R.id.MI_delete)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try {
            doctorListenerRegistration = getDoctorsListenerRegistration(
                requireContext(),
                this::updateRecyclerView
            )
        } catch (e: Exception) {
            Toast.makeText(
                requireContext(),
                "Check your internet connection and try again",
                Toast.LENGTH_SHORT
            ).show()
            e.printStackTrace()
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun updateRecyclerView(items: List<Item>) {

        if (items.isEmpty()) {
            TV_noDoctors.isVisible = true
            PB_doctorList.isVisible = false
        } else {
            fun init() {
                recyclerViewDoctorsList.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = GroupAdapter<GroupieViewHolder>().apply {
                        doctorsSection = Section(items)
                        add(doctorsSection)
                        setOnItemClickListener(onItemClick)
                    }
                }
                shouldInitRecyclerView = false
                PB_doctorList.isVisible = false
            }

            fun updateItems() = doctorsSection.update(items)

            if (shouldInitRecyclerView) init() else updateItems()
        }


    }

    private val onItemClick = OnItemClickListener { item, _ ->
        if (item is DoctorItem) {
            val action =
                DoctorListFragmentFragmentDirections.actionDoctorListFragmentFragmentToDoctorProfileFragment(
                    item.doctor
                )
            findNavController().navigate(action)

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        doctorListenerRegistration.remove()
        shouldInitRecyclerView = true
    }

}