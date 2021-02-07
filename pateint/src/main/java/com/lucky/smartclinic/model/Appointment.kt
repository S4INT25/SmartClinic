package com.lucky.smartclinic.model


data class Appointment(
    val doctorName:String = "",
    val doctorPhotoUrl:String = "",
    val patientName:String = "",
    val patientPhotoUrl:String= "",
    val clinicName:String = "",
    val clinicLocation:String ="",
    val note:String= "",
    val date:String= "",
    val time:String= "", )