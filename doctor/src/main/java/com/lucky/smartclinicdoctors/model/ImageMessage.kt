package com.lucky.smartclinicdoctors.model

import java.util.*

data class ImageMessage(
        val imagePath: String,
        override val date: Date,
        override val senderId: String,
        override val recipientId: String,
        override val senderName: String,
        override val type: String =  MessageType.IMAGE
): Message {
    constructor():this("",Date(0),"","","","")
}