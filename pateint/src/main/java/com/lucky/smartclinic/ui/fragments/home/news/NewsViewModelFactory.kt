package com.lucky.smartclinic.ui.fragments.home.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucky.smartclinic.repository.SmartClinicRepository

class NewsViewModelFactory(private val newsRepository: SmartClinicRepository) : ViewModelProvider.Factory

{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return  NewsViewModel(newsRepository) as T
    }

}