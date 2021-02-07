package com.lucky.smartclinic.model.item

import android.content.Context
import com.lucky.smartclinic.R
import com.lucky.smartclinic.application.GlideApp
import com.lucky.smartclinic.model.Doctor
import com.lucky.smartclinic.utils.StorageUtil
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.doctor_item_view.*
import java.util.*

class DoctorItem (private val context: Context,  val doctor: Doctor):Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val doctorName = "DR ${doctor.firstName}".toUpperCase(Locale.ROOT)
        viewHolder.textViewItemDoctorName.text = doctorName
        viewHolder.textViewItemBoi.text =  doctor.address
        viewHolder.textViewItemProfessional.text = doctor.profession
        if(doctor.photoUrl.isNotBlank())
        {
            GlideApp.with(context)
                .load(StorageUtil.pathToReference(doctor.photoUrl))
                .placeholder(R.drawable.ic_profile)
                .into(viewHolder.circleImageView)
        }
    }
    override fun getLayout(): Int  = R.layout.doctor_item_view

}