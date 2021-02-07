package com.lucky.smartclinic.ui.fragments.home.news

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucky.smartclinic.R
import com.lucky.smartclinic.model.item.NewsItem
import com.lucky.smartclinic.repository.SmartClinicRepository
import com.lucky.smartclinic.ui.fragments.home.HomeFragmentDirections
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.fragment_news.*


/**
 * Show a list of latest news about health
 */
class NewsFragment : Fragment(R.layout.fragment_news) {

    private var shouldInitRecyclerView = true
    private lateinit var newsSection: Section
    private val newsViewModel: NewsViewModel by viewModels {
        NewsViewModelFactory(
            SmartClinicRepository()
        )
    }

    override fun onResume() {
        super.onResume()
        shouldInitRecyclerView = true
        fetchNewsData()


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        swipeRefreshLayout.setOnRefreshListener {
            PB_news.isVisible =  true
            newsViewModel.onRefreshed()
            swipeRefreshLayout.isRefreshing = false
        }
    }



    private fun updateRecyclerView(items: List<Item>) {
        if (items.isEmpty()) {
            V_error.isVisible = true
            TV_error.isVisible = true
            rv_news.isVisible = false
            PB_news.isVisible = false
        } else {

            fun init() {
                PB_news.isVisible = false
                rv_news.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = GroupAdapter<GroupieViewHolder>().apply {
                        newsSection = Section(items)
                        add(newsSection)
                        setOnItemClickListener(onItemClick)
                    }
                }
                PB_news.isVisible = false
                shouldInitRecyclerView = false
            }

            fun updateItems() = newsSection.update(items)

            if (shouldInitRecyclerView) init() else updateItems()
        }

    }

    private val onItemClick = OnItemClickListener { item, _ ->
        if (item is NewsItem) {
            val action = HomeFragmentDirections.actionNavHomeToNewsDetailsFragment(item.newsArticle)
            findNavController().navigate(action)
        }

    }

    private fun fetchNewsData() {

        lifecycleScope.launchWhenCreated {
            newsViewModel.news.asLiveData().observe(viewLifecycleOwner){newFragmentState ->
                when (newFragmentState) {
                    is NewsViewModel.NewFragmentState.Success -> {
                        val items = mutableListOf<Item>()
                        newFragmentState.news.articles.forEach {
                            items.add(NewsItem(requireContext(), it))
                        }
                        updateRecyclerView(items)
                        PB_news.isVisible = false
                        TV_error.isVisible = false
                    }
                    is NewsViewModel.NewFragmentState.Empty -> PB_news.isVisible = true

                    is NewsViewModel.NewFragmentState.Error -> {
                        TV_error.isVisible = true
                        TV_error.text = newFragmentState.error.string()
                        PB_news.isVisible = false
                        Toast.makeText(requireContext(), "something went wrong", Toast.LENGTH_SHORT)
                            .show()
                        Log.d(TAG, "fetchNewsData: ${newFragmentState.error}")
                    }
                    is NewsViewModel.NewFragmentState.LocalError -> {
                        PB_news.isVisible = false
                        Toast.makeText(
                            requireContext(),
                            "No internet connection ${newFragmentState.error.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                        TV_error.isVisible = true
                        TV_error.text = newFragmentState.error.message
                    }

                }
            }
        }
    }



    companion object {
        val TAG: String? = NewsFragment::class.simpleName
    }

}
