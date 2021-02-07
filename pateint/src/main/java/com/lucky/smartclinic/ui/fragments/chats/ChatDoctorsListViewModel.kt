package com.lucky.smartclinic.ui.fragments.chats

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.lucky.smartclinic.utils.FireStoreUtils
import com.xwray.groupie.kotlinandroidextensions.Item

class ChatDoctorsListViewModel(private val context:Application) : AndroidViewModel(context) {


    private val  _doctorsList =  MutableLiveData<List<Item>>()

    fun doctorList(): MutableLiveData<List<Item>>
    {
        FireStoreUtils.addDoctorsEngagedWithChatListener(context){
            _doctorsList.value = it
        }
        return _doctorsList
    }




}