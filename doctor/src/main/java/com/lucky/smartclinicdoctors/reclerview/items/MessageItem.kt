package com.lucky.smartclinicdoctors.reclerview.items

import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.model.Message
import com.lucky.smartclinicdoctors.utils.FireBaseAuthUtil
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_image_message.*
import java.text.SimpleDateFormat

abstract class MessageItem(val message: Message):Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        setTimeText(viewHolder)
        setMessageRootGravity(viewHolder)
    }
     private fun setTimeText(viewHolder: GroupieViewHolder) {
         val dateFormat = SimpleDateFormat
                 .getDateTimeInstance(SimpleDateFormat.SHORT, SimpleDateFormat.SHORT)
         viewHolder.textView_message_time.text = dateFormat.format(message.date)
     }
     private fun setMessageRootGravity(viewHolder: GroupieViewHolder) {
         if (message.senderId == FireBaseAuthUtil.currentUser!!.uid) {
             viewHolder.message_root.apply {
                 setBackgroundResource(R.drawable.rect_round_white)
                 val lParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.END)
                 this.layoutParams = lParams
             }
         } else {
             viewHolder.message_root.apply {
                 setBackgroundResource(R.drawable.rect_round_primary_color)
                 val lParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.START)
                 this.layoutParams = lParams
             }
         }
     }
 }