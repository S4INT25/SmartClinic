package com.lucky.smartclinic.ui.fragments.home.doctor

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.lucky.smartclinic.utils.FireStoreUtils
import com.xwray.groupie.kotlinandroidextensions.Item

class DoctorViewModel(private val context:Application):AndroidViewModel(context)
{
    private val _doctorsList = MutableLiveData<List<Item>>()
    val emptyDatabase:MutableLiveData<Boolean> = MutableLiveData(true)
    fun checkIfDataBaseEmpty(items:List<Item>){
        emptyDatabase.value =  items.isEmpty()
    }

    fun doctors():MutableLiveData<List<Item>>
    {
        FireStoreUtils.getDoctors(context){
            Log.d(TAG, "doctors: list of items is ${it.size}")
            _doctorsList.value =  it
        }
        return _doctorsList
    }

    companion object{
        private const val TAG = "DoctorViewModel"
    }

}