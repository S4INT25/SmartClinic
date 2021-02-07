package com.lucky.smartclinicdoctors.model

data class DoctorsNote(
    val doctorName: String = "",
    val doctorEmail: String = "",
    val doctorPhone: String = "",
    val doctorTitle: String = "",
    val doctorDob: String = "",
    val diagnosis: String = "",
    val prescription: String = "",
    val clinicName:String = "",
    val date: String = ""
) {
}