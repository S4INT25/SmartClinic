package com.lucky.smartclinicdoctors.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.*
import com.lucky.smartclinic.model.TextMessage
import com.lucky.smartclinicdoctors.model.*
import com.lucky.smartclinicdoctors.reclerview.items.AppointmentItem
import com.lucky.smartclinicdoctors.reclerview.items.ImageMessageItem
import com.lucky.smartclinicdoctors.reclerview.items.PatientItem
import com.lucky.smartclinicdoctors.reclerview.items.TextMessageItem
import com.lucky.smartclinicdoctors.utils.FireBaseAuthUtil.currentUser
import com.xwray.groupie.kotlinandroidextensions.Item

object FireStoreUtils {

    //convert Time stamp
    private const val SECOND_MILLIS = 1000
    private const val MINUTE_MILLIS = 60 * SECOND_MILLIS
    private const val HOUR_MILLIS = 60 * MINUTE_MILLIS
    private const val DAY_MILLIS = 24 * HOUR_MILLIS
    private const val TAG = "FireStoreUtils"
    private const val COLLECTION_USERS_PATIENTS_REF = "users/user_patient/patients"
    private const val COLLECTION_USERS_DOCTORS_REF = "users/user_doctors/doctors"
    private val fireStoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val chatChannelsCollectionRef = fireStoreInstance.collection("chatChannels")


    //get current doctors document
    private val currentDoctorDocumentRef: DocumentReference
        get() = fireStoreInstance.document(
            COLLECTION_USERS_DOCTORS_REF +
                    "/${currentUser!!.uid}"
        )

    //patients collection
    private val patientsCollectionRef: CollectionReference
        get() = fireStoreInstance.collection(COLLECTION_USERS_PATIENTS_REF)


    fun initCurrentUserIfFirstTime(doctor: Doctor, onComplete: () -> Unit) {
        currentDoctorDocumentRef.get().addOnSuccessListener { documentSnapshot ->
            if (!documentSnapshot.exists()) {
                currentDoctorDocumentRef.set(doctor).addOnSuccessListener {
                    onComplete()
                }
            } else {
                onComplete()
            }
        }

    }

    fun getCurrentUser(onComplete: (Doctor) -> Unit) {
        currentDoctorDocumentRef.get().addOnCompleteListener {
            if(it.isSuccessful)
            {
                onComplete(it.result!!.toObject(Doctor::class.java)!!)
            }
        }
    }


    fun updateCurrentUser(profilePicturePath: String? = null) {
        val userFieldMap = mutableMapOf<String, Any>()
        if (profilePicturePath != null)
            userFieldMap["photoUrl"] = profilePicturePath
        currentDoctorDocumentRef.update(userFieldMap)
    }

    fun updateOnlineStatus(isOnline: Boolean) {
        val userFieldMap = mutableMapOf<String, Any>()
        userFieldMap["isOnline"] = isOnline
        currentDoctorDocumentRef.update(userFieldMap)
    }

    fun setLastSeen(lastSeen: Long) {
        val userFieldMap = mutableMapOf<String, Any>()
        userFieldMap["lastSeen"] = lastSeen
        currentDoctorDocumentRef.update(userFieldMap)
    }


    fun addPatientsEngagedWithChatListener(
        context: Context,
        onListen: (List<Item>) -> Unit
    ): ListenerRegistration {
        val engagedWith: MutableList<DocumentSnapshot> = mutableListOf()
        currentDoctorDocumentRef.collection("engagedChatChannels")
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    Toast.makeText(context, "failed to retrieve patients \n make Sure you have an Active internet connection", Toast.LENGTH_SHORT).show()
                    Log.d(
                        TAG,
                        "addPatientsEngagedWithChatListener: ${firebaseFirestoreException.message} "
                    )
                    return@addSnapshotListener
                }
                querySnapshot!!.documents.forEach {
                    engagedWith.add(it)
                }
            }

        return fireStoreInstance.collection(COLLECTION_USERS_PATIENTS_REF)
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    return@addSnapshotListener
                }
                val items = mutableListOf<Item>()
                querySnapshot!!.documents.forEach {
                    for (index in engagedWith.indices) {
                        if (it.id == engagedWith[index].id) {
                            items.add(PatientItem(context, it.toObject(Patient::class.java)!!))
                        }
                    }
                }
                onListen(items)
            }
    }

    fun removeListener(registration: ListenerRegistration) = registration.remove()


    fun getOrCreateChatChannel(otherUserId: String, onComplete: (channelId: String) -> Unit) {
        currentDoctorDocumentRef.collection("engagedChatChannels")
            .document(otherUserId).get().addOnSuccessListener {
                if (it.exists()) {
                    onComplete(it["channelId"] as String)
                    return@addOnSuccessListener
                }

                val currentUserId = currentUser!!.uid

                val newChannel = chatChannelsCollectionRef.document()

                newChannel.set(ChatChannel(mutableListOf(currentUserId, otherUserId)))

                currentDoctorDocumentRef
                    .collection("engagedChatChannels")
                    .document(otherUserId)
                    .set(mapOf("channelId" to newChannel.id))

                fireStoreInstance.collection(COLLECTION_USERS_PATIENTS_REF).document(otherUserId)
                    .collection("engagedChatChannels")
                    .document(currentUserId)
                    .set(mapOf("channelId" to newChannel.id))
                onComplete(newChannel.id)
            }
    }


    fun updateUser(id: String,data:MutableMap<String,Any>,onComplete: (Task<Void>) -> Unit)
    {
        fireStoreInstance.collection(COLLECTION_USERS_PATIENTS_REF).document(id).update(data).addOnCompleteListener {
            onComplete(it)
        }
    }

    fun addAppointment(appointment: Appointment, otherUserId: String) {

        currentDoctorDocumentRef.collection("appointments").add(appointment)

        patientsCollectionRef.document(otherUserId).collection("appointments").add(appointment)

    }

    fun addReportNote(context: Context, doctorsNote: DoctorsNote, otherUserId: String) {
        patientsCollectionRef.document(otherUserId).collection("report notes").add(doctorsNote)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(context, "report added", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun getReportNotes(
        patientsUserId: String,
        onListen: (List<Item>) -> Unit
    ): ListenerRegistration {
      return  patientsCollectionRef.document(patientsUserId).collection("report notes")
            .addSnapshotListener { value, error ->
                val items = mutableListOf<Item>()
                if(error !=  null) return@addSnapshotListener
                value!!.documents.forEach {documentSnapshot ->
                    items.add(DoctorNoteItem(documentSnapshot.toObject(DoctorsNote::class.java)!!))
                }
                onListen(items)
            }
    }

    fun deletedAppointment(id: String, context: Context) {
        currentDoctorDocumentRef.collection("appointments").document(id).delete()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(context, "Appointment deleted!!!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(
                        context,
                        "Appointment deleted unsuccessfully !!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun addAppointmentsListener(
        context: Context,
        onListen: (List<Item>) -> Unit
    ): ListenerRegistration {
        return currentDoctorDocumentRef.collection("appointments")
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    Log.e("FIRESTORE", "ChatMessagesListener error.", firebaseFirestoreException)
                    return@addSnapshotListener
                }
                val items = mutableListOf<Item>()
                querySnapshot!!.documents.forEach {
                    items.add(
                        AppointmentItem(
                            it.id,
                            context,
                            it.toObject(Appointment::class.java)!!
                        )
                    )
                }
                onListen(items)
            }
    }


    fun addChatMessagesListener(
        channelId: String, context: Context,
        onListen: (List<Item>) -> Unit
    ): ListenerRegistration {

        return chatChannelsCollectionRef.document(channelId).collection("messages")
            .orderBy("date")
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    Log.e(
                        TAG,
                        "ChatMessagesListener error.",
                        firebaseFirestoreException
                    )
                    return@addSnapshotListener
                }
                val items = mutableListOf<Item>()
                querySnapshot!!.documents.forEach {
                    if (it["type"] == MessageType.TEXT)
                        items.add(
                            TextMessageItem(
                                context,
                                it.toObject(TextMessage::class.java)!!
                            )
                        )
                    else
                        items.add(
                            ImageMessageItem(
                                context,
                                it.toObject(ImageMessage::class.java)!!
                            )
                        )
                    return@forEach
                }
                onListen(items)
            }
    }

    fun sendMessage(message: Message, channelId: String) {
        chatChannelsCollectionRef.document(channelId)
            .collection("messages")
            .add(message)
    }

    fun getLastSeen(lastSeenTime: Long): String? {
        var time = lastSeenTime
        if (time < 1000000000000L) {
            // if timestamp given in seconds, convert to millis
            time *= 1000
        }
        val now = System.currentTimeMillis()
        if (time > now || time <= 0) {
            return null
        }

        val diff = now - time
        return when {
            diff < MINUTE_MILLIS -> {
                "just now"
            }
            diff < 2 * MINUTE_MILLIS -> {
                "a minute ago"
            }
            diff < 50 * MINUTE_MILLIS -> {
                " ${diff / MINUTE_MILLIS} minutes ago"
            }
            diff < 90 * MINUTE_MILLIS -> {
                "an hour ago"
            }
            diff < 24 * HOUR_MILLIS -> {
                "${diff / HOUR_MILLIS} hours ago"
            }
            diff < 48 * HOUR_MILLIS -> {
                "yesterday"
            }
            else -> {
                " ${diff / DAY_MILLIS} days ago"
            }
        }
    }

    //region FCM
    fun getFCMRegistrationTokens(onComplete: (tokens: MutableList<String>) -> Unit) {
        currentDoctorDocumentRef.get().addOnSuccessListener {
            if(it.exists())
            {
                val user = it.toObject(Patient::class.java)!!
                onComplete(user.deviceTokens)
            }
        }
    }

    fun setFCMRegistrationTokens(registrationTokens: MutableList<String>) {
        currentDoctorDocumentRef.update(mapOf("deviceTokens" to registrationTokens))
    }
    //endregion FCM

}