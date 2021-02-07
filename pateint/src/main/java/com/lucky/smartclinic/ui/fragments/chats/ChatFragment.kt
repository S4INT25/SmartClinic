package com.lucky.smartclinic.ui.fragments.chats

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.MaterialToolbar
import com.lucky.smartclinic.R
import com.lucky.smartclinic.model.ImageMessage
import com.lucky.smartclinic.model.Patient
import com.lucky.smartclinic.model.TextMessage
import com.lucky.smartclinic.ui.fragments.profile.ProfileFragment
import com.lucky.smartclinic.utils.FireStoreUtils
import com.lucky.smartclinic.utils.StorageUtil
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_chat.*
import java.io.ByteArrayOutputStream
import java.util.*


class ChatFragment : Fragment(R.layout.fragment_chat) {
    private val args by navArgs<ChatFragmentArgs>()
    private lateinit var otherUserId: String
    private lateinit var mChannelId: String
    private lateinit var currentUser: Patient
    private lateinit var messageSection: Section
    private var isRecyclerInitialized = true
    private lateinit var listener: SinchCallListener
    private lateinit var toolbar: MaterialToolbar
    private val chatViewModel by viewModels<ChatViewModel>()

    fun interface SinchCallListener {
        fun makeCall(id: String, name: String, callType: Int)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as SinchCallListener
        } catch (e: Exception) {
            Log.e(TAG, "onAttach: $context must implement callListener")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getUsers()
        FireStoreUtils.getOrCreateChatChannel(otherUserId) { channelId ->
            mChannelId = channelId
           chatViewModel.chats(channelId).observe(viewLifecycleOwner,this::updateRecyclerView)
        }
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.chat_activity_menu, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        sendMessages()
        makeCalls()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        setNameAndUpdateLastSeen()
        toolbar =  requireActivity().toolbar
    }
    private fun updateRecyclerView(message: List<Item>) {
        fun init() {
            recycler_view_messages.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = GroupAdapter<GroupieViewHolder>().apply {
                    messageSection = Section(message)
                    this.add(messageSection)
                }
            }
            isRecyclerInitialized = false
        }
        fun update() = messageSection.update(message)
        if (isRecyclerInitialized) init() else update()
        val count = recycler_view_messages.adapter?.itemCount
        if (count != null) {
            recycler_view_messages.scrollToPosition(count - 1)
        }
    }

    private fun setNameAndUpdateLastSeen() {
        toolbar = requireActivity().toolbar
        try {
            val fullName = "DR ${args.doctor.firstName}".toUpperCase(Locale.ROOT)
            toolbar.title = fullName
            val lastSeen = FireStoreUtils.getLastSeen(args.doctor.lastSeen)
            if (args.doctor.isOnline) {
                toolbar.subtitle = "online"
            }
            toolbar.subtitle = lastSeen
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            return
        }

    }

    private fun getUsers() {
        FireStoreUtils.getCurrentUser({ patient ->
            currentUser = patient
        }, {
            Log.d(TAG, "getUsers: ${it.printStackTrace()}")
        })
        otherUserId = args.doctor.uid
    }

    private fun sendMessages() {
        imageView_send.setOnClickListener {
            if (editText_message.text!!.isNotBlank()) {
                val messageToSend =
                    TextMessage(
                        editText_message.text.toString(),
                        Calendar.getInstance().time,
                        FireStoreUtils.firebaseAuth.currentUser!!.uid,
                        otherUserId,
                        currentUser.userName
                    )
                editText_message.text?.clear()
                FireStoreUtils.sendMessage(messageToSend, mChannelId)
            }

        }

        fab_send_image.setOnClickListener {
            selectProfileImage()
        }
    }

    private fun makeCalls() {
        toolbar = requireActivity().toolbar
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.videoCall -> {
                    listener.makeCall(otherUserId, args.doctor.firstName, VIDEO_CALL)
                    true
                }
                R.id.voiceCall -> {
                    listener.makeCall(otherUserId, args.doctor.firstName, VOICE_CALL)
                    true
                }
                else -> throw  IllegalArgumentException("invalid argument was passed ${it.itemId}")
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        saveAndLoadPicture(requestCode, resultCode, data)
    }
    private fun saveAndLoadPicture(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ProfileFragment.RC_SELECT_IMAGE && resultCode == Activity.RESULT_OK &&
            data != null && data.data != null
        ) {
            val selectedImagePath = data.data
            val selectedImageBmp = MediaStore.Images.Media
                .getBitmap(activity?.contentResolver, selectedImagePath)
            val outputStream = ByteArrayOutputStream()
            selectedImageBmp.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)

            val selectedImageBytes = outputStream.toByteArray()

            //save image to firebase and update user profile image url
            StorageUtil.uploadImageMessage(selectedImageBytes) {
                val messageToSend = ImageMessage(
                    it,
                    Calendar.getInstance().time,
                    FireStoreUtils.firebaseAuth.currentUser!!.uid,
                    otherUserId,
                    currentUser.userName
                )
                FireStoreUtils.sendMessage(messageToSend, mChannelId)
            }
        }
    }

    private fun selectProfileImage() {
        fab_send_image.setOnClickListener {
            val intent = Intent().apply {
                type = "image/*"
                action = Intent.ACTION_GET_CONTENT
                putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/jpeg", "image/png"))
            }
            startActivityForResult(
                Intent.createChooser(intent, "Select image"),
                ProfileFragment.RC_SELECT_IMAGE
            )
        }
    }
    companion object {
        const val VIDEO_CALL = 1
        const val VOICE_CALL = 2
        private const val TAG = "ChatFragment"
    }

}