package com.lucky.smartclinic.model

import java.util.*

data class TextMessage(val text:String,
                       override val date: Date,
                       override val senderId:String,
                       override val recipientId: String,
                       override val senderName: String,
                       override val type:String = MessageType.TEXT
):Message{
    constructor():this("",Date(0),"","","","")
}
