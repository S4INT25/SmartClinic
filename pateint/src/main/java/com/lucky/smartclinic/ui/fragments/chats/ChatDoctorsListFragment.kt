package com.lucky.smartclinic.ui.fragments.chats

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucky.smartclinic.R
import com.lucky.smartclinic.model.item.DoctorItem

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.Section
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_doctor_chats_list.*


class ChatDoctorsListFragment : Fragment(R.layout.fragment_doctor_chats_list) {
    private var shouldInitRecyclerView = true
    private lateinit var doctorsSection: Section
    private val chatListViewMode by viewModels<ChatDoctorsListViewModel>()

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ${requireActivity().toolbar.isVisible}")
        requireActivity().toolbar.subtitle = ""
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try {
            chatListViewMode.doctorList().observe(viewLifecycleOwner, this::updateRecyclerView)
        } catch (e: Exception) {
            requireActivity().toolbar.isVisible = true
            TV_noChat.isVisible = true
            PB_chat.isVisible = false
            recycler_view_doc.isVisible = false
            Toast.makeText(
                requireContext(),
                "Check your internet connection and try again",
                Toast.LENGTH_SHORT
            ).show()
            e.printStackTrace()
        }
        requireActivity().toolbar.isVisible = true
        return super.onCreateView(inflater, container, savedInstanceState)


    }

    private fun updateRecyclerView(items: List<com.xwray.groupie.kotlinandroidextensions.Item>) {
        if (items.isEmpty()) {
            TV_noChat.isVisible = true
            PB_chat.isVisible = false
            recycler_view_doc.isVisible = false
        }
        fun init() {
            recycler_view_doc.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = GroupAdapter<GroupieViewHolder>().apply {
                    doctorsSection = Section(items)
                    add(doctorsSection)
                    setOnItemClickListener(onItemClick)
                }
            }
            PB_chat.isVisible = false
            shouldInitRecyclerView = false
        }

        fun updateItems() = doctorsSection.update(items)

        if (shouldInitRecyclerView)
            init()
        else
            updateItems()

    }

    private val onItemClick = OnItemClickListener { item, _ ->
        if (item is DoctorItem) {
            val action = ChatDoctorsListFragmentDirections.actionNavChatsToChatFragment(item.doctor)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        shouldInitRecyclerView = true
    }

    companion object
    {
        private const val TAG = "ChatDoctorsListFragment"
    }
}