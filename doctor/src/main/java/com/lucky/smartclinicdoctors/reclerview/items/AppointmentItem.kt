package com.lucky.smartclinicdoctors.reclerview.items

import android.content.Context
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.application.GlideApp
import com.lucky.smartclinicdoctors.model.Appointment
import com.lucky.smartclinicdoctors.utils.StorageUtil
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_appointment.*

class AppointmentItem ( val AppointmentId:String,val context: Context, val appointment: Appointment):Item()
{
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.textViewItemDate.text = "DATE: ${appointment.date}"
        viewHolder.textViewItemTime.text = "TIME: ${appointment.time}"
        viewHolder.textViewItemPatient.text = appointment.patientName
        viewHolder.TV_appointmentNote.text =  "NOTE: ${appointment.note}"
        viewHolder.TV_clinic.text =  appointment.clinicName
        viewHolder.TV_location.text =  appointment.clinicLocation
        GlideApp.with(context)
            .load(StorageUtil.pathToReference(appointment.patientPhotoUrl))
            .placeholder(R.drawable.ic_profile).into(viewHolder.imageView)
    }

    override fun getLayout(): Int  =  R.layout.item_appointment

}