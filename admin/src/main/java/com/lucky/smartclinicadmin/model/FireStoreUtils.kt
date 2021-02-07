package com.lucky.smartclinicadmin.model

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.ktx.toObject
import com.lucky.smartclinicadmin.items.DoctorItem
import com.xwray.groupie.kotlinandroidextensions.Item
object FireStoreUtils {
    private const val COLLECTION_USERS_PATIENTS_REF = "users/user_patient/patients"
    private const val COLLECTION_USERS_DOCTORS_REF = "users/user_doctors/doctors"
    private const val TAG = "FireStoreUtils"
    private val fireStoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }

    //get  doctors collection document
    fun getDoctorsListenerRegistration(
        context: Context,
        onComplete: (List<Item>) -> Unit
    ): ListenerRegistration {
        return fireStoreInstance.collection(COLLECTION_USERS_DOCTORS_REF)
            .addSnapshotListener { querySnapshot, error ->
                if (error != null) return@addSnapshotListener
                val doctorItems = mutableListOf<Item>()
                querySnapshot?.documents?.forEach {
                    doctorItems.add(DoctorItem(context, it.toObject<Doctor>()!!))
                }
                onComplete(doctorItems)
            }
    }

    //get  patients collection document
    fun getPatientsCollection(
        context: Context,
        onComplete: (List<Item>) -> Unit
    ): ListenerRegistration {
        return fireStoreInstance.collection(COLLECTION_USERS_PATIENTS_REF)
            .addSnapshotListener { querySnapshot, error ->
                if (error != null) return@addSnapshotListener
                val patientItems = mutableListOf<Item>()
                querySnapshot?.documents?.forEach {
                    patientItems.add(DoctorItem(context, it.toObject<Doctor>()!!))
                }
                onComplete(patientItems)
            }
    }



}