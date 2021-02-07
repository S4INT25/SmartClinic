package com.lucky.smartclinic.model.item

import android.content.Context
import com.lucky.smartclinic.R
import com.lucky.smartclinic.model.TextMessage

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder

import kotlinx.android.synthetic.main.item_text_message.*

class TextMessageItem (val context: Context, val textMessage: TextMessage): MessageItem(textMessage)
{
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        super.bind(viewHolder, position)
        viewHolder.message_text.text = textMessage.text
    }
    override fun getLayout(): Int  =  R.layout.item_text_message

    override fun isSameAs(other: com.xwray.groupie.Item<*>): Boolean {
        if (other !is TextMessageItem)
            return false
        if (this.textMessage != other.textMessage)
            return false
        return true
    }
    override fun equals(other: Any?): Boolean {
        return isSameAs(other as TextMessageItem)
    }
    override fun hashCode(): Int {
        var result = textMessage.hashCode()
        result = 31 * result + context.hashCode()
        return result
    }

}