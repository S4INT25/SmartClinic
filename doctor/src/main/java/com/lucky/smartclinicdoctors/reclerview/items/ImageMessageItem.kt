package com.lucky.smartclinicdoctors.reclerview.items

import android.content.Context
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.application.GlideApp
import com.lucky.smartclinicdoctors.model.ImageMessage
import com.lucky.smartclinicdoctors.utils.StorageUtil
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.item_image_message.*

class ImageMessageItem(val context: Context, private val imageMessage: ImageMessage): MessageItem(imageMessage){

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