package com.lucky.smartclinicdoctors.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Doctor(
    val uid: String,
    val firstName: String,
    val lastName: String,
    val sex:String,
    val dob:String,
    val nrc:String,
    val email: String,
    val phoneNumber: String,
    val address:String = "",
    val bio:String = "",
    val profession: String,
    val isOnline:Boolean,
    val lastSeen:Long,
    val hpczDocumentUrl:String,
    val photoUrl: String,
    val verified:Boolean,
    val deviceTokens: MutableList<String>
):Parcelable{
    constructor():this("","","","","","","","","","","",false,0,"","", false,mutableListOf())
}
