package com.lucky.smartclinicdoctors.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

object FireBaseAuthUtil {

    internal val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    fun login(email:String, password:String,onComplete:(FirebaseUser)->Unit)
    {
      firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
          if (it.isSuccessful)
          {
              onComplete(it.result!!.user!!)
          }
      }
    }

    fun signUp(email:String, password:String,onComplete:(FirebaseUser)->Unit)
    {
       firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
           if (it.isSuccessful)
           {
               onComplete(it.result!!.user!!)
           }
       }
    }

}