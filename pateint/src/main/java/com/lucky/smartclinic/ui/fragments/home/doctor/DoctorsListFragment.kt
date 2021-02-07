package com.lucky.smartclinic.ui.fragments.home.doctor

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucky.smartclinic.R
import com.lucky.smartclinic.model.item.DoctorItem
import com.lucky.smartclinic.ui.fragments.UpdateUserDetailsFragment
import com.lucky.smartclinic.ui.fragments.home.HomeFragmentDirections
import com.lucky.smartclinic.utils.FireStoreUtils
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.Section
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_doctors.*


class DoctorsListFragment : Fragment(R.layout.fragment_doctors), SearchView.OnQueryTextListener {

    private var shouldInitRecyclerView = true
    private lateinit var doctorsSection: Section
    private val doctorViewModel by viewModels<DoctorViewModel>()

    override fun onStart() {
        super.onStart()
        SRL_refresh.setOnRefreshListener {
            getDoctors()
            SRL_refresh.isRefreshing = false
        }
    }

    override fun onResume() {
        shouldInitRecyclerView = true
        try {
            requireActivity().toolbar.menu.removeItem(R.id.app_bar_search)
        } catch (e: Exception) {
            Log.d(TAG, "onViewCreated: ${e.printStackTrace()}")
            return
        }
        finally {
            setUpSearch()

        }
        super.onResume()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        doctorViewModel.emptyDatabase.observe(viewLifecycleOwner) {
            when (it) {
                true -> {
                    TV_noDoctors.isVisible = true
                    PB_doctorList.isVisible = true
                }
                false -> {
                    TV_noDoctors.isVisible = false
                    PB_doctorList.isVisible = false
                }
            }
        }
        getDoctors()
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    private fun setUpSearch() {
        val menuItem = activity?.let { it ->
            it.toolbar!!.inflateMenu(R.menu.doctors_list)
            it.toolbar!!.menu!!.findItem(R.id.app_bar_search)
        }
        val searchView = menuItem!!.actionView as SearchView
        searchView.apply {
            isSubmitButtonEnabled = true
            setOnQueryTextListener(this@DoctorsListFragment)
        }
        val searchAutoComplete =
            searchView.findViewById<SearchView.SearchAutoComplete>(androidx.appcompat.R.id.search_src_text)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.physicians_list,
            android.R.layout.simple_expandable_list_item_1
        ).apply {
            searchAutoComplete.setAdapter(this)
        }
        searchAutoComplete.setDropDownBackgroundResource(R.drawable.white_background)
        searchAutoComplete.dropDownAnchor = R.id.app_bar_search
        searchAutoComplete.setOnItemClickListener { adapterView, view, i, l ->
            val query = adapterView.getItemAtPosition(i) as String
            searchAutoComplete.setText(query)
        }
    }

    private fun getDoctors() {
        try {
            doctorViewModel.doctors().observe(viewLifecycleOwner) {
                doctorViewModel.checkIfDataBaseEmpty(it)
                updateRecyclerView(it)
            }

        } catch (e: Exception) {
            Toast.makeText(
                requireContext(),
                "Check your internet connection and try again",
                Toast.LENGTH_SHORT
            ).show()
            Log.e(TAG, "onViewCreated: ${e.printStackTrace()}")
        }
    }

    private fun updateRecyclerView(items: List<com.xwray.groupie.kotlinandroidextensions.Item>) {
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

        if (shouldInitRecyclerView)
            init()
        else
            updateItems()

    }

    private val onItemClick = OnItemClickListener { item, _ ->

        if (item is DoctorItem) {
            FireStoreUtils.getCurrentUser({
                if (it.photoUrl.isNullOrEmpty()) {
                    UpdateUserDetailsFragment().show(parentFragmentManager, "Update")
                } else {
                    val action =
                        HomeFragmentDirections.actionNavHomeToDoctorProfileFragment(item.doctor)
                    findNavController().navigate(action)
                }
            }, {
                Toast.makeText(requireContext(), "No user", Toast.LENGTH_SHORT).show()
                requireActivity().onBackPressed()
            })
        }

    }

    companion object {
        private const val TAG = "DoctorsListFragment"
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        p0?.let {

            val list = listOf(it)
            FireStoreUtils.queryDoctor(requireContext(), list, this::updateRecyclerView)
        }
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        p0?.let {
            val list = listOf(it)
            FireStoreUtils.queryDoctor(requireContext(), list, this::updateRecyclerView)
        }
        return true
    }

    override fun onPause() {
        super.onPause()
        requireActivity().toolbar.menu.removeItem(R.id.app_bar_search)
    }
}