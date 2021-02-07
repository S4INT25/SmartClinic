package com.lucky.smartclinicdoctors.ui.fragments.pateint

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ListenerRegistration
import com.lucky.smartclinic.model.TextMessage
import com.lucky.smartclinicdoctors.R
import com.lucky.smartclinicdoctors.model.Doctor
import com.lucky.smartclinicdoctors.model.ImageMessage
import com.lucky.smartclinicdoctors.ui.fragments.appointments.AppointmentDialog
import com.lucky.smartclinicdoctors.ui.fragments.appointments.DoctorsNoteDialog
import com.lucky.smartclinicdoctors.utils.FireBaseAuthUtil
import com.lucky.smartclinicdoctors.utils.FireStoreUtils
import com.lucky.smartclinicdoctors.utils.StorageUtil
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.chat_app_bar.*
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.util.*


class ChatFragment : Fragment(R.layout.fragment_chat){
    private val args by navArgs<ChatFragmentArgs>()
    private lateinit var messageListenerRegistration: ListenerRegistration
    private lateinit var otherUserId: String
    private lateinit var mChannelId: String
    private lateinit var currentUser: Doctor
    private lateinit var messageSection: Section
    private var isRecyclerInitialized = true
   private lateinit var  listener: SinchCallListener

    fun interface SinchCallListener{
        fun makeCall(id:String, name:String,callType:Int)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as SinchCallListener
        }catch (e:Exception)
        {
            Log.e(TAG, "onAttach: $context must implement callListener", )
        }

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        otherUserId = args.patient.uid.toString()
        updateLastSeen()

        ChatTopAppBar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        ChatTopAppBar.setOnMenuItemClickListener{
            when(it.itemId)
            {
                R.id.videoCall -> {
                   listener.makeCall(otherUserId,args.patient.firstName, VIDEO_CALL)
                    true
                }
                R.id.voiceCall -> {
                    listener.makeCall(otherUserId,args.patient.firstName, VOICE_CALL)
                    Toast.makeText(requireContext(), "voice call", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.Appointment -> {
                    val bundle = Bundle()
                    bundle.putString("patientUid",otherUserId)
                    bundle.putString("patientName","${args.patient.firstName} ${args.patient.lastName}")
                    bundle.putString("patientPhotoUrl",args.patient.photoUrl)
                 val appointmentDialog = AppointmentDialog()
                    appointmentDialog.arguments = bundle
                    appointmentDialog.show(parentFragmentManager,"Set Appointment")
                    true
                }

                R.id.AppointmentReport -> {
                    val bundle = Bundle()
                    bundle.putString("patientUid",otherUserId)
                    val fullName =  "${currentUser.firstName} ${currentUser.lastName}"
                    bundle.putString("nameFull",fullName)
                    bundle.putString("email",currentUser.email)
                    bundle.putString("dob",currentUser.dob)
                    bundle.putString("phone",currentUser.phoneNumber)
                    bundle.putString("title",currentUser.profession)
                    val appointmentNoteDialog =  DoctorsNoteDialog()
                    appointmentNoteDialog.arguments = bundle
                    appointmentNoteDialog.show(parentFragmentManager,"note")
                    true
                }
                else -> {
                    Toast.makeText(requireContext(), "invalid id", Toast.LENGTH_SHORT).show()
                    false
                }
            }
        }

        FireStoreUtils.getCurrentUser {
            currentUser = it
        }

        FireStoreUtils.getOrCreateChatChannel(otherUserId) { channelId ->
            mChannelId = channelId
            messageListenerRegistration = FireStoreUtils.addChatMessagesListener(channelId, requireContext(), this::updateRecyclerView)
        }

        imageView_send.setOnClickListener {
            val messageToSend =
                TextMessage(editText_message.text.toString(), Timestamp.now().toDate(),
                    currentUser.uid, otherUserId, currentUser.firstName)
            editText_message.text?.clear()
            FireStoreUtils.sendMessage(messageToSend, mChannelId)
        }
        fab_send_image.setOnClickListener {
            selectProfileImage()
        }

    }

    private fun updateLastSeen() {

        try {
            ChatTopAppBar.title = args.patient.firstName
            val lastSeen = FireStoreUtils.getLastSeen(args.patient.lastSeen)
            if (args.patient.isOnline) { ChatTopAppBar.subtitle = "online" }
            ChatTopAppBar.subtitle = lastSeen
        }catch (e:java.lang.Exception)
        {
            e.printStackTrace()
            return
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        saveAndLoadPicture(requestCode, resultCode, data)
    }

    private fun updateRecyclerView(message: List<Item>) {

        fun init() {
            recycler_view_chats.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = GroupAdapter<GroupieViewHolder>().apply {
                    messageSection = Section(message)
                    this.add(messageSection)
                }
            }
            isRecyclerInitialized = false
        }

        fun update() = messageSection.update(message)

        if (isRecyclerInitialized) {
            init()

        } else {
            update()
        }
         recycler_view_chats.adapter?.let {
            recycler_view_chats.scrollToPosition(it.itemCount -1)
        }


    }

    private fun selectProfileImage() {
        fab_send_image.setOnClickListener {
            val intent = Intent().apply {
                type = "image/*"
                action = Intent.ACTION_GET_CONTENT
                putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/jpeg", "image/png"))
            }
            startActivityForResult(Intent.createChooser(intent, "Select image"), RC_SELECT_IMAGE)
        }
    }

    private fun saveAndLoadPicture(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_SELECT_IMAGE && resultCode == Activity.RESULT_OK &&
            data != null && data.data != null) {
            val selectedImagePath = data.data
            val selectedImageBmp = MediaStore.Images.Media
                .getBitmap(activity?.contentResolver, selectedImagePath)
            val outputStream = ByteArrayOutputStream()
            selectedImageBmp.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)

            val selectedImageBytes = outputStream.toByteArray()

            //save image to firebase and update user profile image url
            GlobalScope.launch {
                val imageUrl =  StorageUtil.uploadImageMessage(selectedImageBytes)
                val messageToSend = ImageMessage(imageUrl,
                    Calendar.getInstance().time,
                    FireBaseAuthUtil.currentUser!!.uid,
                    otherUserId,
                    currentUser.firstName)
                FireStoreUtils.sendMessage(messageToSend, mChannelId)
            }
        }
    }
    companion object{
        const val RC_SELECT_IMAGE = 22
        private const val TAG = "ChatFragment"
        const val VIDEO_CALL =  1
        const val VOICE_CALL = 2
    }


}