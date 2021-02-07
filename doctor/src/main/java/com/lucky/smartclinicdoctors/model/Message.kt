package com.lucky.smartclinicdoctors.model

import java.util.*

object MessageType{
    const val TEXT = "text"
    const val IMAGE = "image"
}

interface Message {
    val date:Date
    val senderId:String
    val recipientId: String
    val senderName: String
    val type:String
}