package com.lucky.smartclinicdoctors.reclerview.items


import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.model.DoctorsNote
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.doctor_note_dialog.view.*
import kotlinx.android.synthetic.main.item_doctor_note.view.*


class DoctorNoteItem(private  val doctorNote:DoctorsNote) : Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.TV_noteDoctorsName.text =   doctorNote.doctorName
        viewHolder.itemView.TV_noteDob.text =   doctorNote.doctorDob
        viewHolder.itemView.TV_noteDoctorsTitle.text =   doctorNote.doctorTitle
        viewHolder.itemView.TV_noteDoctorsEmail.text =   doctorNote.doctorEmail
        viewHolder.itemView.TV_noteDoctorsPhoneNumber.text =   doctorNote.doctorPhone
        viewHolder.itemView.TV_noteClinic.text =   doctorNote.clinicName
        viewHolder.itemView.TV_noteDiagnosis.text =   doctorNote.diagnosis
        viewHolder.itemView.TV_notePrescription.text =   doctorNote.prescription
        viewHolder.itemView.TV_noteDate.text =   doctorNote.date
    }

    override fun getLayout(): Int  =  R.layout.item_doctor_note


}
