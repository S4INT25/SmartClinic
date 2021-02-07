package com.lucky.smartclinicdoctors.ui.fragments.appointments

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.lucky.smartclinicdoctors.R
import java.util.*

class DoctorsNoteDialog: DialogFragment()
{
    private lateinit var listener: DoctorNoteDialogListener
    private  lateinit var clinicEditText: EditText
    private lateinit var noteDateTextView: TextView
    private  lateinit var diagnosisEditText: EditText
    private lateinit var buttonNoteDate: Button
    private lateinit var prescriptionEditText: EditText
    private lateinit var myDatePickerDialog: MyDatePickerDialog


    interface DoctorNoteDialogListener {
        fun onDialogNotePositiveClick(dialog: DialogFragment, data: Intent)
        fun onDialogNoteNegativeClick(dialog: DialogFragment)
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        myDatePickerDialog =  MyDatePickerDialog()
        return activity?.let { fragmentActivity ->
            // Get the layout inflater
            val view = requireActivity().layoutInflater.inflate(R.layout.doctor_note_dialog, null)
            getViews(view)
            view.apply {
                buttonNoteDate =  findViewById(R.id.buttonNoteDate)
                buttonNoteDate.setOnClickListener {
                    showDatePickerDialog()
                }
                // setting default values for dialog
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)
                val dateString = "$day/$month/$year"
                clinicEditText.setText(requireArguments().getString("patientName"))
                noteDateTextView.text =  dateString
            }
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(fragmentActivity)
            builder.setView(view)
            builder.setMessage("Add Appointment Note").setPositiveButton("Add") { _, _ ->
                try {
                    val data = Intent().apply {
                        putExtra("uid", requireArguments().getString("patientUid"))
                        putExtra("doctorName",requireArguments().getString("nameFull"))
                        putExtra("doctorEmail",requireArguments().getString("email"))
                        putExtra("doctorPhone",requireArguments().getString("phone"))
                        putExtra("doctorTitle",requireArguments().getString("title"))
                        putExtra("doctorDob",requireArguments().getString("dob"))
                        putExtra("clinicName", clinicEditText.text.toString())
                        putExtra("diagnosis", diagnosisEditText.text.toString())
                        putExtra("date", noteDateTextView.text.toString())
                        putExtra("prescription",prescriptionEditText.text.toString())
                    }
                    listener.onDialogNotePositiveClick(this, data)
                } catch (e: Exception) {
                    Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }
                .setNegativeButton("cancel") { _, _ ->
                    listener.onDialogNoteNegativeClick(this)
                }
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
    private fun getViews(view: View) {

        noteDateTextView = view.findViewById(R.id.TV_noteDate)
        clinicEditText = view.findViewById(R.id.ET_clinicName)
        diagnosisEditText = view.findViewById(R.id.ET_noteDescription)
        prescriptionEditText = view.findViewById(R.id.ET_medication)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = context as DoctorNoteDialogListener
        } catch (e: ClassCastException) {
            // The activity doesn't implement the interface, throw exception
            throw ClassCastException(
                (context.toString() +
                        " must implement NoticeDialogListener")
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode ==  Activity.RESULT_OK)
        {
            if(requestCode == AppointmentDialog.RQC_DATE)
            {
                if (data != null) {
                    noteDateTextView.text = data.getStringExtra("date")
                }
            }
        }
    }

    private fun showDatePickerDialog() {
        this.parentFragmentManager.let {
            myDatePickerDialog.setTargetFragment(this, AppointmentDialog.RQC_DATE)
            myDatePickerDialog.show(it, "timePicker")
        }
    }

}
