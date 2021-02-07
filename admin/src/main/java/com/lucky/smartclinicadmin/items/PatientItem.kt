package com.lucky.smartclinicadmin.items

import android.content.Context
import com.lucky.smartclinicadmin.R
import com.lucky.smartclinicadmin.application.GlideApp
import com.lucky.smartclinicadmin.model.Patient
import com.lucky.smartclinicadmin.utils.pathToReference
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_patient.*

class PatientItem (val context: Context, val patient: Patient):Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        if (patient.photoUrl.isNotBlank())
        {
            try {
                GlideApp.with(context)
                    .load(pathToReference(patient.photoUrl))
                    .placeholder(R.drawable.ic_profile)
                    .into(viewHolder.circleImageViewPatient)
            }catch (e:Exception)
            {
                e.printStackTrace()
            }

        }
         viewHolder.textViewItemPatientName.text = patient.firstName
         viewHolder.textViewItemPatientBio.text =patient.bio
         viewHolder.textViewItemPatientProfessional.text =  patient.occupation
    }

    override fun getLayout(): Int  = R.layout.item_patient

}