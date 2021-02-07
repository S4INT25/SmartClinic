package com.lucky.smartclinicdoctors.utils

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.tasks.await
import java.util.*


object StorageUtil {
    private val storageInstance: FirebaseStorage by lazy { FirebaseStorage.getInstance() }


    private val currentUserRef: StorageReference
        get() = storageInstance.reference
                .child(FireBaseAuthUtil.currentUser?.uid ?: throw NullPointerException("UID is null."))

    fun uploadPdfFile(uri: Uri,onComplete:(String)->Unit){
        val ref = storageInstance.reference.child("pdf/hpczDocument/${FireBaseAuthUtil.currentUser!!.email}")
       ref.putFile(uri).addOnCompleteListener{
           if(it.isSuccessful)
           {
               onComplete(it.result!!.metadata!!.path)
           }
        }
    }

    fun uploadProfilePhoto(imageBytes: ByteArray,onComplete:(String)->Unit) {
        val ref = currentUserRef.child("profilePictures/${UUID.nameUUIDFromBytes(imageBytes)}")
         ref.putBytes(imageBytes).addOnCompleteListener {
             if(it.isSuccessful)
             {
                 onComplete(it.result!!.metadata!!.path)
             }
         }
    }
    suspend fun uploadImageMessage(imageBytes: ByteArray):String {
        val ref = currentUserRef.child("messages/${UUID.nameUUIDFromBytes(imageBytes)}")
       return ref.putBytes(imageBytes).await().metadata?.path?: ""
    }

    fun pathToReference(path: String) = storageInstance.getReference(path)
}