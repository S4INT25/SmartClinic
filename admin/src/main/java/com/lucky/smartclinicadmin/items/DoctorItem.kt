package com.lucky.smartclinicadmin.items

import android.content.Context
import com.lucky.smartclinicadmin.R
import com.lucky.smartclinicadmin.application.GlideApp
import com.lucky.smartclinicadmin.model.Doctor
import com.lucky.smartclinicadmin.utils.pathToReference
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.doctor_item_view.*


class DoctorItem(val context: Context, val doctor: Doctor) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val doctorName = "DR: ${doctor.firstName} ${doctor.lastName}"
        viewHolder.textViewItemDoctorName.text = doctorName
        viewHolder.textViewItemBoi.text = doctor.bio
        viewHolder.textViewItemProfessional.text = doctor.profession

        if (doctor.photoUrl.isNotBlank()) {
            GlideApp.with(context)
                .load(pathToReference(doctor.photoUrl))
                .placeholder(R.drawable.ic_profile)
                .into(viewHolder.circleImageView)
        }
    }

    override fun getLayout(): Int = R.layout.doctor_item_view

}