package com.lucky.smartclinic.ui.fragments.chats

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.lucky.smartclinic.utils.FireStoreUtils
import com.xwray.groupie.kotlinandroidextensions.Item

class ChatViewModel(private val context: Application) : AndroidViewModel(context)
{

    private val _chats = MutableLiveData<List<Item>>()

    fun chats(channelID:String):MutableLiveData<List<Item>>
    {
      FireStoreUtils.addChatMessagesListener(channelID,context){
            _chats.value =  it
        }
        return _chats
    }

}