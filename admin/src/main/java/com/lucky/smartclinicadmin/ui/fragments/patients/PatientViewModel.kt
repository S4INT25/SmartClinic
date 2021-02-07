package com.lucky.smartclinicadmin.ui.fragments.patients

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.lucky.smartclinicadmin.utils.getPatientsCollection

import com.xwray.groupie.kotlinandroidextensions.Item

class PatientViewModel(private val context: Application) : AndroidViewModel(context)
{
    private val _patients = MutableLiveData<List<Item>>()

    fun getPatientsList():MutableLiveData<List<Item>>
    {
        getPatientsCollection(context)
        {
            _patients.value =  it
        }
        return _patients
    }


}