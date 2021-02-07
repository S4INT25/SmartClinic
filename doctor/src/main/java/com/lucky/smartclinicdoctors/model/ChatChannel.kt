package com.lucky.smartclinicdoctors.model

data class ChatChannel(val usersId: MutableList<String>)
{
    constructor():this(mutableListOf())
}