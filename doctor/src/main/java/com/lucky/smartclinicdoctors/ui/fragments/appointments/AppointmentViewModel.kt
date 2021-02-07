package com.lucky.smartclinicdoctors.ui.fragments.appointments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ListenerRegistration
import com.lucky.smartclinicdoctors.utils.FireStoreUtils
import com.xwray.groupie.kotlinandroidextensions.Item


class AppointmentViewModel(private val context: Application) : AndroidViewModel(context)
{
    private val _appointments = MutableLiveData<List<Item>>()
    private lateinit var _listener:ListenerRegistration

    fun appointments(): MutableLiveData<List<Item>>{
     _listener = FireStoreUtils.addAppointmentsListener(context){ list ->
            _appointments.value =  list
        }

        return _appointments
    }

    override fun onCleared() {
        super.onCleared()
        FireStoreUtils.removeListener(_listener)
    }
    }