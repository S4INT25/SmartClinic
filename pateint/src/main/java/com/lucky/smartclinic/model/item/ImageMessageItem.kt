package com.lucky.smartclinic.model.item

import android.content.Context
import com.lucky.smartclinic.R
import com.lucky.smartclinic.application.GlideApp
import com.lucky.smartclinic.model.ImageMessage
import com.lucky.smartclinic.utils.StorageUtil
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.item_image_message.*

class ImageMessageItem(val context: Context, private val imageMessage:ImageMessage): MessageItem(imageMessage){

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        super.bind(viewHolder, position)
        GlideApp.with(context)
                .load(StorageUtil.pathToReference(imageMessage.imagePath))
                .placeholder(R.drawable.ic_baseline_person_pin_24)
                .into(viewHolder.imageView_message_image)

    }
    override fun getLayout(): Int = R.layout.item_image_message


    override fun isSameAs(other: com.xwray.groupie.Item<*>): Boolean {
        if (other !is ImageMessageItem)
            return false
        if (this.message != other.message)
            return false
        return true
    }
    override fun equals(other: Any?): Boolean {
        return isSameAs(other as ImageMessageItem)
    }
    override fun hashCode(): Int {
        var result = message.hashCode()
        result = 31 * result + context.hashCode()
        return result
    }
}