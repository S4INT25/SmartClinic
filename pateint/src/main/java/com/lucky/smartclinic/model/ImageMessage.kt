package com.lucky.smartclinic.model

import java.util.*

data class ImageMessage(
        val imagePath: String = "",
        override val date: Date = Date(0),
        override val senderId: String = "",
        override val recipientId: String = "",
        override val senderName: String = "",
        override val type: String =  MessageType.IMAGE
):Message{
}