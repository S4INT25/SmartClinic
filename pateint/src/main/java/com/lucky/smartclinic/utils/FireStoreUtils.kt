package com.lucky.smartclinic.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*
import com.lucky.smartclinic.model.*
import com.lucky.smartclinic.model.item.AppointmentItem
import com.lucky.smartclinic.model.item.DoctorItem
import com.lucky.smartclinic.model.item.ImageMessageItem
import com.lucky.smartclinic.model.item.TextMessageItem
import com.xwray.groupie.kotlinandroidextensions.Item


/**
 * Firebase utils object for getting and storing data
 */
object FireStoreUtils {
    private const val SECOND_MILLIS = 1000
    private const val MINUTE_MILLIS = 60 * SECOND_MILLIS
    private const val HOUR_MILLIS = 60 * MINUTE_MILLIS
    private const val DAY_MILLIS = 24 * HOUR_MILLIS
    private const val COLLECTION_USERS_PATIENTS_REF = "users/user_patient/patients"
    private const val COLLECTION_USERS_DOCTORS_REF = "users/user_doctors/doctors"
    const val TAG = "FireStoreUtils"
    private val fireStoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    internal val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }


    private val currentUserDocRefs: DocumentReference
        get() = fireStoreInstance.document(
            COLLECTION_USERS_PATIENTS_REF +
                    "/${firebaseAuth.currentUser?.uid ?: throw NullPointerException("UID is null")}"
        )


    private val chatChannelsCollectionRef = fireStoreInstance.collection("chatChannels")


    /**
     * add user for the first time
     */
    fun initCurrentUserIfFirstTime(patient: Patient, onComplete: () -> Unit) {
        currentUserDocRefs.get().addOnSuccessListener { documentSnapshot ->
            if (!documentSnapshot.exists()) {
                currentUserDocRefs.set(patient).addOnSuccessListener {
                    onComplete()
                }
            } else {
                onComplete()
            }
        }

    }


    /**
     * get current user document
     */
    fun getCurrentUser(onComplete: (Patient) -> Unit, onFailure: (error: Exception) -> Unit) {
        try {
            currentUserDocRefs.get()
                .addOnSuccessListener {
                    it.toObject(Patient::class.java)?.let { it1: Patient -> onComplete(it1) }
                }
        } catch (e: Exception) {
            onFailure(e)
        }

    }


    /**
     * update current user(patient) information
     */
    fun updateCurrentUser(
        context: Context,
        firstName: String,
        lastName: String,
        phoneNumber: Long,
        nrcNumber: String,
        dob: String,
        sex: String,
        address: String,
        bio: String,
        occupation: String,
        weight: Double,
        height: Double,
        profilePicturePath: String?, onComplete: () -> Unit
    ) {
        try {
            val userFieldMap = mutableMapOf<String, Any>()
            if (firstName.isNotBlank()) userFieldMap["firstName"] = firstName
            if (lastName.isNotBlank()) userFieldMap["lastName"] = lastName
            if (nrcNumber.isNotBlank()) userFieldMap["nrcNumber"] = nrcNumber
            if (dob.isNotBlank()) userFieldMap["dob"] = dob
            if (sex.isNotBlank()) userFieldMap["sex"] = sex
            if (bio.isNotBlank()) userFieldMap["bio"] = bio
            if (address.isNotBlank()) userFieldMap["address"] = address
            if (occupation.isNotBlank()) userFieldMap["occupation"] = occupation
            if (profilePicturePath != null) userFieldMap["photoUrl"] = profilePicturePath
            userFieldMap["weight"] = weight
            userFieldMap["height"] = height
            userFieldMap["phoneNumber"] = phoneNumber
            currentUserDocRefs.update(userFieldMap).addOnCompleteListener {
                if (it.isSuccessful) {
                    onComplete()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "failed to update fields", Toast.LENGTH_SHORT).show()
        }

    }


    /**
     * listen  to changes on doctors collection
     */
    fun getDoctors(context: Context, onListen: (List<Item>) -> Unit): ListenerRegistration {
        return fireStoreInstance.collection(COLLECTION_USERS_DOCTORS_REF)
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    Log.e(TAG, "Users listener error.", firebaseFirestoreException)
                    return@addSnapshotListener
                }
                val items = mutableListOf<Item>()
                querySnapshot!!.documents.forEach {
                    items.add(DoctorItem(context, it.toObject(Doctor::class.java)!!))
                }

                onListen(items)
            }
    }

    fun addDoctorsEngagedWithChatListener(
        context: Context,
        onListen: (List<Item>) -> Unit
    ): ListenerRegistration {
        val engagedWith: MutableList<DocumentSnapshot> = mutableListOf()
        currentUserDocRefs.collection("engagedChatChannels")
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
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

        return fireStoreInstance.collection(COLLECTION_USERS_DOCTORS_REF)
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    return@addSnapshotListener
                }
                val items = mutableListOf<Item>()
                querySnapshot!!.documents.forEach {
                    for (index in engagedWith.indices) {
                        if (it.id == engagedWith[index].id) {
                            items.add(DoctorItem(context, it.toObject(Doctor::class.java)!!))
                        }
                    }
                }
                onListen(items)
            }
    }

    fun queryDoctor(context: Context, query: List<String>, onListen: (List<Item>) -> Unit) {
        fireStoreInstance.collection(COLLECTION_USERS_DOCTORS_REF)
            .whereIn("profession", query).addSnapshotListener { data, error ->
                if (error != null) {
                    return@addSnapshotListener
                }
                val items = mutableListOf<Item>()
                data!!.documents.forEach {
                    items.add(DoctorItem(context, it.toObject(Doctor::class.java)!!))
                    Log.d(TAG, "queryDoctor: $items")
                }
                onListen(items)
            }
    }


    /**
     *  remove listener for changes on doctors collection
     */
    fun removeListener(registration: ListenerRegistration): Unit = registration.remove()


    /**
     * create chat channel for the first time
     * get chat channel if already created
     */
    fun getOrCreateChatChannel(otherUserId: String, onComplete: (channelId: String) -> Unit) {
        currentUserDocRefs.collection("engagedChatChannels")
            .document(otherUserId).get().addOnSuccessListener {
                if (it.exists()) {
                    onComplete(it["channelId"] as String)
                    return@addOnSuccessListener
                }

                val currentUserId = (firebaseAuth.currentUser
                    ?: return@addOnSuccessListener).uid

                val newChannel = chatChannelsCollectionRef.document()

                newChannel.set(ChatChannel(mutableListOf(currentUserId, otherUserId)))
                currentUserDocRefs
                    .collection("engagedChatChannels")
                    .document(otherUserId)
                    .set(mapOf("channelId" to newChannel.id))

                fireStoreInstance.collection(COLLECTION_USERS_DOCTORS_REF).document(otherUserId)
                    .collection("engagedChatChannels")
                    .document(currentUserId)
                    .set(mapOf("channelId" to newChannel.id))
                onComplete(newChannel.id)
            }
    }

    /**
     * Add Chat message listener on messages collection
     */
    fun addChatMessagesListener(
        channelId: String, context: Context,
        onListen: (List<Item>) -> Unit
    ): ListenerRegistration {

        return chatChannelsCollectionRef.document(channelId).collection("messages")
            .orderBy("date")
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    Log.e(TAG, "ChatMessagesListener error.", firebaseFirestoreException)
                    return@addSnapshotListener
                }
                val items = mutableListOf<Item>()
                querySnapshot!!.documents.forEach {
                    if (it["type"] == MessageType.TEXT)
                        items.add(
                            TextMessageItem(
                                context,
                                it.toObject(TextMessage::class.java) ?: return@forEach
                            )
                        )
                    else
                        items.add(
                            ImageMessageItem(
                                context,
                                it.toObject(ImageMessage::class.java) ?: return@forEach
                            )
                        )
                    return@forEach
                }
                onListen(items)
            }
    }

    /**
     * save message to message document
     */
    fun sendMessage(message: Message, channelId: String) {
        chatChannelsCollectionRef.document(channelId)
            .collection("messages")
            .add(message)
    }

    fun addAppointmentsListener(
        context: Context,
        onListen: (List<Item>) -> Unit
    ): ListenerRegistration {
        return currentUserDocRefs.collection("appointments")
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    Log.e("FIRESTORE", "AppointmentListener error.", firebaseFirestoreException)
                    return@addSnapshotListener
                }
                val items = mutableListOf<Item>()
                querySnapshot!!.documents.forEach {
                    items.add(AppointmentItem(context, it.toObject(Appointment::class.java)!!))
                }
                onListen(items)
            }
    }

    fun updateOnlineStatus(isOnline: Boolean) {
        val userFieldMap = mutableMapOf<String, Any>()
        userFieldMap["isOnline"] = isOnline
        currentUserDocRefs.update(userFieldMap)
    }


    fun setLastSeen(lastSeen: Long) {
        val userFieldMap = mutableMapOf<String, Any>()
        userFieldMap["lastSeen"] = lastSeen
        currentUserDocRefs.update(userFieldMap)
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

    /**
     * region FCM
     */
    fun getFCMRegistrationTokens(onComplete: (tokens: MutableList<String>) -> Unit) {
        currentUserDocRefs.get().addOnSuccessListener { documentSnapshot ->
            documentSnapshot.toObject(Patient::class.java)?.let {
                onComplete(it.deviceTokens)
            }
        }
    }

    /**
     * set FCM registration Token on users document snapshot
     */
    fun setFCMRegistrationTokens(registrationTokens: MutableList<String>) {
        currentUserDocRefs.update(mapOf("deviceTokens" to registrationTokens))
    }


}