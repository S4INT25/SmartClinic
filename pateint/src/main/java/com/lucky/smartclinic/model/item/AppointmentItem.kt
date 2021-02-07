package com.lucky.smartclinic.model.item

import android.content.Context
import com.lucky.smartclinic.R
import com.lucky.smartclinic.application.GlideApp
import com.lucky.smartclinic.model.Appointment
import com.lucky.smartclinic.utils.StorageUtil
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_appointment.*
import java.util.*

class AppointmentItem(val context: Context, private val appointment: Appointment) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val date = "DATE: ${appointment.date}"
        val time = "TIME: ${appointment.time}"
        val doctorName = "DR ${appointment.doctorName}".toUpperCase(Locale.ROOT)
        val note = appointment.note
        viewHolder.TV_appointmentDate.text = date
        viewHolder.TV_appointmentTime.text = time
        viewHolder.TV_appointmentDoctorName.text = doctorName
        viewHolder.TV_appointmentNote.text = note
        viewHolder.TV_appointmentAddress.text = appointment.clinicLocation
        if (appointment.doctorPhotoUrl.isNotBlank()) {
            GlideApp.with(context)
                .load(StorageUtil.pathToReference(appointment.doctorPhotoUrl))
                .placeholder(R.drawable.ic_profile).into(viewHolder.imageView)
        }

    }

    override fun getLayout(): Int = R.layout.item_appointment

}