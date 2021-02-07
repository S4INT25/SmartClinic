package com.lucky.smartclinicadmin.utils

import android.content.Context
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.storage.FirebaseStorage
import com.lucky.smartclinicadmin.items.DoctorItem
import com.lucky.smartclinicadmin.items.PatientItem
import com.lucky.smartclinicadmin.model.Doctor
import com.lucky.smartclinicadmin.model.Patient
import com.xwray.groupie.kotlinandroidextensions.Item


private const val COLLECTION_USERS_PATIENTS_REF = "users/user_patient/patients"
private const val COLLECTION_USERS_DOCTORS_REF = "users/user_doctors/doctors"
private val fireStoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }

//get  doctors collection document
internal fun getDoctorsListenerRegistration(
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


internal fun verifyDoctor(context: Context, id: String, data: MutableMap<String, Any>) {
    fireStoreInstance.collection(COLLECTION_USERS_DOCTORS_REF).document(id).update(data)
        .addOnCompleteListener {

            if (it.isSuccessful) {
                Toast.makeText(context, "Doctor verified", Toast.LENGTH_SHORT).show()
            }
        }

}

internal fun updateDoctor(
    id: String,
    fields: MutableMap<String, Any>,
    onComplete: (task: Task<Void>) -> Unit
) {
    fireStoreInstance.collection(COLLECTION_USERS_DOCTORS_REF).document(id).update(fields)
        .addOnCompleteListener {
            onComplete(it)
        }

}

internal fun deleteDoctor(id: String, onComplete: (task: Task<Void>) -> Unit) {
    fireStoreInstance.collection(COLLECTION_USERS_DOCTORS_REF).document(id).delete()
        .addOnCompleteListener {
            onComplete(it)
        }
}

//get  patients collection document
internal fun getPatientsCollection(
    context: Context,
    onComplete: (List<Item>) -> Unit
): ListenerRegistration {
    return fireStoreInstance.collection(COLLECTION_USERS_PATIENTS_REF)
        .addSnapshotListener { querySnapshot, error ->
            if (error != null) return@addSnapshotListener
            val patientItems = mutableListOf<Item>()
            querySnapshot?.documents?.forEach {
                patientItems.add(PatientItem(context, it.toObject<Patient>()!!))
            }
            onComplete(patientItems)
        }
}

//storage
private val storageInstance: FirebaseStorage by lazy { FirebaseStorage.getInstance() }
internal   fun pathToReference(path: String) = storageInstance.getReference(path)


