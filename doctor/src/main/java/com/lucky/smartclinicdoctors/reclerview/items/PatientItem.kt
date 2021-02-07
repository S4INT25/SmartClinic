package com.lucky.smartclinicdoctors.reclerview.items

import android.content.Context
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.application.GlideApp
import com.lucky.smartclinicdoctors.model.Patient
import com.lucky.smartclinicdoctors.utils.FireStoreUtils
import com.lucky.smartclinicdoctors.utils.StorageUtil
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_patient.*

class PatientItem (val context: Context, val patient: Patient):Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        updateLastSeen(viewHolder)
        if (patient.photoUrl !=  null)
        {
            GlideApp.with(context)
                .load(StorageUtil.pathToReference(patient.photoUrl))
                .placeholder(R.drawable.ic_profile)
                .into(viewHolder.circleImageViewPatient)
        }

        val fullName = "${patient.firstName} ${patient.lastName}"
         viewHolder.textViewItemPatientName.text = fullName
         viewHolder.textViewItemPatientBio.text =patient.bio
         viewHolder.textViewItemPatientProfessional.text =  patient.occupation
    }

    override fun getLayout(): Int  = R.layout.item_patient

    private fun updateLastSeen(viewHolder: GroupieViewHolder) {

        try {

            val lastSeen = FireStoreUtils.getLastSeen(patient.lastSeen)
            if (patient.isOnline) {viewHolder.TV_status.text = "online" }
             viewHolder.TV_status.text = lastSeen
        }catch (e:java.lang.Exception)
        {
            e.printStackTrace()
            return
        }

    }

}