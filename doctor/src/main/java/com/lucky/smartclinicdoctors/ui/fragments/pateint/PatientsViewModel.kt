package com.lucky.smartclinicdoctors.ui.fragments.pateint

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ListenerRegistration
import com.lucky.smartclinicdoctors.utils.FireStoreUtils
import com.xwray.groupie.kotlinandroidextensions.Item

class PatientsViewModel(private val context:Application):AndroidViewModel(context)
{
    private val _patients =  MutableLiveData<List<Item>>()
    private lateinit var listener:ListenerRegistration
    fun patients():MutableLiveData<List<Item>>
    {
     listener = FireStoreUtils.addPatientsEngagedWithChatListener(context)
        {
            _patients.value =  it
        }
        return _patients
    }

    override fun onCleared() {
        super.onCleared()
        FireStoreUtils.removeListener(listener)
    }
}