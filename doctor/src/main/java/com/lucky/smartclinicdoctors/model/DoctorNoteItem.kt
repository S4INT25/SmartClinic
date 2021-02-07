package com.lucky.smartclinicdoctors.model

import com.lucky.smartclinicdoctors.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_doctor_note.*

class DoctorNoteItem(private val doctorsNote: DoctorsNote):Item()
{
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.TV_noteDoctorsName.text = doctorsNote.doctorName
        viewHolder.TV_noteDob.text = doctorsNote.doctorDob
        viewHolder.TV_noteDoctorsTitle.text = doctorsNote.doctorTitle
        viewHolder.TV_noteDoctorsEmail.text = doctorsNote.doctorEmail
        viewHolder.TV_noteDoctorsPhoneNumber.text = doctorsNote.doctorPhone
        viewHolder.TV_itemNoteDate.text = doctorsNote.date
        viewHolder.TV_noteClinic.text = doctorsNote.clinicName
        viewHolder.TV_noteDiagnosis.text = doctorsNote.diagnosis
        viewHolder.TV_notePrescription.text = doctorsNote.prescription
    }

    override fun getLayout(): Int  = R.layout.item_doctor_note

}