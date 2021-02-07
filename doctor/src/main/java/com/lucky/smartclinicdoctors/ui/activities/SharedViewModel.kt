package com.lucky.smartclinicdoctors.ui.activities
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel(){

    private val selectedDate = MutableLiveData<String>()
    private val selectedTime =  MutableLiveData<String>()
    private val selectedNote = MutableLiveData<String>()

    fun setDate(date:String)
    {
        selectedDate.value =  date
    }

    fun setTime(time:String)
    {
        selectedTime.value =  time
    }

    fun setNote(note:String)
    {
        this.selectedNote.value =  note
    }

}