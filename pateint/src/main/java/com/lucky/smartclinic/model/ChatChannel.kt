package com.lucky.smartclinic.model

data class ChatChannel(val usersId: MutableList<String>)
{
    constructor():this(mutableListOf())
}