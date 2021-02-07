package com.lucky.smartclinicdoctors.model
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Patient(
    val uid:String?,
    val userName:String,
    val firstName:String,
    val lastName:String,
    val email: String,
    val phoneNumber:Long,
    val nrcNumber:String,
    val address:String,
    val sex:String,
    val weight:Double,
    val Height:Double,
    val dob:String,
    val occupation:String,
    val bio:String,
    val isOnline:Boolean,
    val lastSeen:Long,
    val photoUrl:String?,
    val medication:String,
    val medicalProblem:String,
    val allergies:String,
    val deviceTokens:MutableList<String>
):Parcelable
{
    constructor():this("","","","","",0,"","","None",56.7,1.8,"","","i love using this app",true,0,null,"","","", mutableListOf())
}
