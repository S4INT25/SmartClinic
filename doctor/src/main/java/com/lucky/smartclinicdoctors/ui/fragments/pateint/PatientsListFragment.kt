package com.lucky.smartclinicdoctors.ui.fragments.pateint

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.reclerview.items.PatientItem
import com.lucky.smartclinicdoctors.ui.fragments.HomeFragmentDirections
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.OnItemLongClickListener
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.fragment_chat_list.*


class PatientsListFragment : Fragment(R.layout.fragment_chat_list) {

    private var shouldInitRecyclerView = true
    private lateinit var doctorsSection: Section
    private val patientsViewModel  by viewModels<PatientsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try {
            patientsViewModel.patients().observe(viewLifecycleOwner,this::updateRecyclerView)
        }catch (e:Exception)
        {
            Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT).show()
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        SRL_refresh.setOnRefreshListener {
            patientsViewModel.patients().observe(viewLifecycleOwner,this::updateRecyclerView)
            SRL_refresh.isRefreshing =  false
        }
    }




    private fun updateRecyclerView(items: List<Item>) {
        if (items.isEmpty())
        {   //hide progress bar
            PB_patients.isVisible =  false
            //show no patients textView
            TV_noPatient.isVisible =  true
        }else{
            fun init() {
                TV_noPatient.isVisible =  false
                recycler_view_chats.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = GroupAdapter<GroupieViewHolder>().apply {
                        doctorsSection = Section(items)
                        add(doctorsSection)
                        setOnItemLongClickListener(onItemLongClickListener)
                    }
                }
                PB_patients.isVisible =  false
                shouldInitRecyclerView = false
            }
            fun updateItems() = doctorsSection.update(items)
            if (shouldInitRecyclerView) init() else updateItems()
        }
    }

    private val onItemLongClickListener =  OnItemLongClickListener{
            item, _ ->
        if (item is PatientItem) {
              AlertDialog.Builder(requireContext()).apply {
                setTitle("Patient")
                setPositiveButton("MANAGE"){
                        dialog,_ ->
                    val action  = HomeFragmentDirections.actionHomeFragmentToPateintProfileFragment(item.patient)
                    findNavController().navigate(action)
                    dialog.dismiss()
                }
                setNegativeButton("CHAT"){
                        dialog, _ ->
                    val action = HomeFragmentDirections.actionHomeFragmentToChatFragment(item.patient)
                    findNavController().navigate(action)
                    dialog.dismiss()
                }
                create()
                show()
            }

        }
        true

    }



    override fun onPause() {
        super.onPause()
        shouldInitRecyclerView = true

    }

    companion object
    {
        private const val TAG = "PatientsListFragment"
    }

}