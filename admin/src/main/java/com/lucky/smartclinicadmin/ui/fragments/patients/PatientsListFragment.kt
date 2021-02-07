package com.lucky.smartclinicadmin.ui.fragments.patients

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucky.smartclinicadmin.R
import com.lucky.smartclinicadmin.items.PatientItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.fragment_patients_list.*
import kotlinx.android.synthetic.main.tool_bar.*

class PatientsListFragment : Fragment(R.layout.fragment_patients_list) {
    private var shouldInitRecyclerView = true
    private lateinit var patientsSection: Section
    private val viewModel by viewModels<PatientViewModel>()

    override fun onResume() {
        super.onResume()
            shouldInitRecyclerView = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            viewModel.getPatientsList().observe(viewLifecycleOwner, this::updateRecyclerView)
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Check your internet connection", Toast.LENGTH_SHORT)
                .show()
            Log.d(TAG, "onViewCreated: ${e.printStackTrace()}")
        }
        Toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        Toolbar.menu.removeItem(R.id.MI_edit)

    }


    private fun updateRecyclerView(items: List<Item>) {
        if (items.isEmpty()) {
            PB_patients.isVisible = false
            TV_admin.isVisible = true
        } else {
            val onItemClick = OnItemClickListener { item, _ ->
                if (item is PatientItem) {
                    val action =
                        PatientsListFragmentDirections.actionPatientsListFragmentToPatientProfileFragment(
                            item.patient
                        )
                    findNavController().navigate(action)
                }
            }

            fun init() {
                recycler_view_chats.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = GroupAdapter<GroupieViewHolder>().apply {
                        patientsSection = Section(items)
                        add(patientsSection)
                        setOnItemClickListener(onItemClick)
                    }
                }
                TV_admin.isVisible = false
                PB_patients.isVisible = false
                shouldInitRecyclerView = false
            }

            fun updateItems() = patientsSection.update(items)
            if (shouldInitRecyclerView) init() else updateItems()
        }

    }

    companion object {
        private const val TAG = "PatientsListFragment"
    }


}