package com.lucky.smartclinic.ui.fragments.profile

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lucky.smartclinic.model.Patient
import com.lucky.smartclinic.utils.FireStoreUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileViewModel(private val context: Application) : AndroidViewModel(context) {


    private val currentUser:MutableLiveData<Patient> by lazy { MutableLiveData() }

    fun getUser():LiveData<Patient>
    {
        GlobalScope.launch(Dispatchers.IO) {
            FireStoreUtils.getCurrentUser({
                currentUser.value = it
            }, {
                Toast.makeText(context, "User not found", Toast.LENGTH_SHORT).show()
            })
        }
        return currentUser
    }

}