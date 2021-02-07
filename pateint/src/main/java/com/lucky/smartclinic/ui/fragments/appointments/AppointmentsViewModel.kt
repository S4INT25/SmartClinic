package com.lucky.smartclinic.ui.fragments.appointments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.lucky.smartclinic.utils.FireStoreUtils
import com.xwray.groupie.kotlinandroidextensions.Item

class AppointmentsViewModel(val context: Application) : AndroidViewModel(context) {
    private val _appointments = MutableLiveData<List<Item>>()

    fun getAppointments(): MutableLiveData<List<Item>> {
        FireStoreUtils.addAppointmentsListener(context) {
            _appointments.value = it
        }
        return _appointments
    }

}