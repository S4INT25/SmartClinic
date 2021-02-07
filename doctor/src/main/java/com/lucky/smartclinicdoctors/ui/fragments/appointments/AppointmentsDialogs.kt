package com.lucky.smartclinicdoctors.ui.fragments.appointments
import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.lucky.smartclinicdoctors.R
import java.util.*

class AppointmentDialog : DialogFragment() {
    //     Use this instance of the interface to deliver action events
    private lateinit var listener: AppointmentDialogListener
    private  lateinit var patientEditText: EditText
    private  lateinit var noteEditText: EditText
    private lateinit var buttonDate: Button
    private lateinit var buttonTime:Button
    private lateinit var dateTextView: TextView
    private lateinit var timeTextView: TextView
    private lateinit var locationEditText: EditText
    private lateinit var clinicNameEditText: EditText
    private lateinit var myDatePickerDialog: MyDatePickerDialog
    private lateinit var myTimePickerDialog: MyTimePickerDialog
    private lateinit var spinner: Spinner

    /* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
    interface AppointmentDialogListener {
        fun onDialogPositiveClick(dialog: DialogFragment,data:Intent)
        fun onDialogNegativeClick(dialog: DialogFragment)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        myDatePickerDialog =  MyDatePickerDialog()
        myTimePickerDialog =  MyTimePickerDialog()
        return activity?.let { fragmentActivity ->
            // Get the layout inflater
            val view = requireActivity().layoutInflater.inflate(R.layout.add_appointment_dialog, null)
            getViews(view)
            ArrayAdapter.createFromResource(requireContext(),R.array.appointments_list,android.R.layout.simple_spinner_dropdown_item).also {
                spinner.adapter =  it
            }
            view.apply {
                buttonTime =  findViewById(R.id.buttonTime)
                buttonTime.setOnClickListener {
                    showTimePickerDialog()
                }
                buttonDate =  findViewById(R.id.buttonDate)
                buttonDate.setOnClickListener {
                    showDatePickerDialog()
                }
                // setting default values for dialog
                val c = Calendar.getInstance()
                val hour = c.get(Calendar.HOUR_OF_DAY)
                val minute = c.get(Calendar.MINUTE)
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)
                val timeString = "$hour:$minute"
                val dateString = "$day/$month/$year"
                patientEditText.setText(requireArguments().getString("patientName"))
                timeTextView.text = timeString
                dateTextView.text =  dateString
            }
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(fragmentActivity)
            builder.setView(view)
            builder.setMessage("Add Appointment").setPositiveButton("Add") { _, _ ->
                    try {
                        val data = Intent().apply {
                            putExtra("uid", requireArguments().getString("patientUid"))
                            putExtra("patient", patientEditText.text.toString())
                            putExtra("photoUrl", requireArguments().getString("patientPhotoUrl"))
                            putExtra("note", noteEditText.text.toString())
                            putExtra("date", dateTextView.text.toString())
                            putExtra("time", timeTextView.text.toString())
                            putExtra("location",locationEditText.text.toString())
                            putExtra("clinic",clinicNameEditText.text.toString())
                            putExtra("type", spinner.selectedItem.toString())
                        }
                        listener.onDialogPositiveClick(this, data)
                    } catch (e: Exception) {
                        Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
                        e.printStackTrace()
                    }
                }
                .setNegativeButton("cancel") { _, _ ->
                    listener.onDialogNegativeClick(this)
                }
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun getViews(view: View) {
        dateTextView = view.findViewById(R.id.textViewDate)
        timeTextView = view.findViewById(R.id.textViewTime)
        patientEditText = view.findViewById(R.id.editTextPatient)
        noteEditText = view.findViewById(R.id.editTextNote)
        locationEditText = view.findViewById(R.id.editTextLocation)
        clinicNameEditText = view.findViewById(R.id.editTextClinic)
        spinner = view.findViewById(R.id.SP_type)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = context as AppointmentDialogListener
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
            if(requestCode == RQC_DATE)
            {
                if (data != null) {
                    dateTextView.text = data.getStringExtra("date")
                }
            }else if(requestCode == RQC_TIME)
            {
                timeTextView.text =  data!!.getStringExtra("time")
            }
        }
    }

    private fun showTimePickerDialog() {
        this.parentFragmentManager.let {
            myTimePickerDialog.setTargetFragment(this, RQC_TIME)
            myTimePickerDialog.show(it,"Time Picker")
        }
    }

    private fun showDatePickerDialog() {
        this.parentFragmentManager.let {
            myDatePickerDialog.setTargetFragment(this, RQC_DATE)
            myDatePickerDialog.show(it, "timePicker")
        }
    }
    companion object{
        const val RQC_DATE = 150
        const val RQC_TIME = 200
        private const val TAG = "AppointmentsDialogs"
    }
}


class MyTimePickerDialog : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        return TimePickerDialog(
            requireActivity(),
            this,
            hour,
            minute,
            DateFormat.is24HourFormat(activity)
        )
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        // Do something with the time chosen by the user
          val time = "$hourOfDay:$minute"
         targetFragment!!.onActivityResult(AppointmentDialog.RQC_TIME,Activity.RESULT_OK,Intent().putExtra("time",time))
    }
}

class MyDatePickerDialog : DialogFragment(), DatePickerDialog.OnDateSetListener{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        // Create a new instance of DatePickerDialog and return it
        return DatePickerDialog(requireActivity(), this, year, month, day)
    }


    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        // Do something with the date chosen by the user
        val date =  "$day/$month/$year"
        targetFragment!!.onActivityResult(AppointmentDialog.RQC_DATE,Activity.RESULT_OK,Intent().putExtra("date",date))
    }




}


