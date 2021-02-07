package com.lucky.smartclinicdoctors.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.lucky.smartclinicdoctors.utils.FireBaseAuthUtil
import com.lucky.smartclinicdoctors.utils.FireStoreUtils


class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        if (FireBaseAuthUtil.currentUser != null)
            addTokenToFireStore(token)
    }

    companion object {
        fun addTokenToFireStore(newRegistrationToken: String?) {
            if (newRegistrationToken == null) throw NullPointerException("FCM token is null.")

            FireStoreUtils.getFCMRegistrationTokens { tokens ->
                if (tokens.contains(newRegistrationToken))
                    return@getFCMRegistrationTokens

                tokens.add(newRegistrationToken)
                FireStoreUtils.setFCMRegistrationTokens(tokens)
            }
        }
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (remoteMessage.notification != null) {
            //TODO: Show notification if we're not online
            Log.d("FCM", remoteMessage.data.toString())
        }
    }
}