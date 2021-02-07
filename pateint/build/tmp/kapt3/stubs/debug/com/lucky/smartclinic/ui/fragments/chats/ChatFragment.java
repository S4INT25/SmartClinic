package com.lucky.smartclinic.ui.fragments.chats;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 <2\u00020\u0001:\u0002<=B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\"\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\'H\u0016J\u0012\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0018\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u001dH\u0016J\u001a\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u0002032\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\"\u00104\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u00105\u001a\u00020\u001dH\u0002J\b\u00106\u001a\u00020\u001dH\u0002J\b\u00107\u001a\u00020\u001dH\u0002J\u0016\u00108\u001a\u00020\u001d2\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/lucky/smartclinic/ui/fragments/chats/ChatFragment;", "Landroidx/fragment/app/Fragment;", "()V", "args", "Lcom/lucky/smartclinic/ui/fragments/chats/ChatFragmentArgs;", "getArgs", "()Lcom/lucky/smartclinic/ui/fragments/chats/ChatFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "chatViewModel", "Lcom/lucky/smartclinic/ui/fragments/chats/ChatViewModel;", "getChatViewModel", "()Lcom/lucky/smartclinic/ui/fragments/chats/ChatViewModel;", "chatViewModel$delegate", "Lkotlin/Lazy;", "currentUser", "Lcom/lucky/smartclinic/model/Patient;", "isRecyclerInitialized", "", "listener", "Lcom/lucky/smartclinic/ui/fragments/chats/ChatFragment$SinchCallListener;", "mChannelId", "", "messageSection", "Lcom/xwray/groupie/Section;", "otherUserId", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "getUsers", "", "makeCalls", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onResume", "onViewCreated", "view", "Landroid/view/View;", "saveAndLoadPicture", "selectProfileImage", "sendMessages", "setNameAndUpdateLastSeen", "updateRecyclerView", "message", "", "Lcom/xwray/groupie/kotlinandroidextensions/Item;", "Companion", "SinchCallListener", "pateint_debug"})
public final class ChatFragment extends androidx.fragment.app.Fragment {
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    private java.lang.String otherUserId;
    private java.lang.String mChannelId;
    private com.lucky.smartclinic.model.Patient currentUser;
    private com.xwray.groupie.Section messageSection;
    private boolean isRecyclerInitialized = true;
    private com.lucky.smartclinic.ui.fragments.chats.ChatFragment.SinchCallListener listener;
    private com.google.android.material.appbar.MaterialToolbar toolbar;
    private final kotlin.Lazy chatViewModel$delegate = null;
    public static final int VIDEO_CALL = 1;
    public static final int VOICE_CALL = 2;
    private static final java.lang.String TAG = "ChatFragment";
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinic.ui.fragments.chats.ChatFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.lucky.smartclinic.ui.fragments.chats.ChatFragmentArgs getArgs() {
        return null;
    }
    
    private final com.lucky.smartclinic.ui.fragments.chats.ChatViewModel getChatViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu, @org.jetbrains.annotations.NotNull()
    android.view.MenuInflater inflater) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void updateRecyclerView(java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item> message) {
    }
    
    private final void setNameAndUpdateLastSeen() {
    }
    
    private final void getUsers() {
    }
    
    private final void sendMessages() {
    }
    
    private final void makeCalls() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void saveAndLoadPicture(int requestCode, int resultCode, android.content.Intent data) {
    }
    
    private final void selectProfileImage() {
    }
    
    public ChatFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/lucky/smartclinic/ui/fragments/chats/ChatFragment$SinchCallListener;", "", "makeCall", "", "id", "", "name", "callType", "", "pateint_debug"})
    public static abstract interface SinchCallListener {
        
        public abstract void makeCall(@org.jetbrains.annotations.NotNull()
        java.lang.String id, @org.jetbrains.annotations.NotNull()
        java.lang.String name, int callType);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/lucky/smartclinic/ui/fragments/chats/ChatFragment$Companion;", "", "()V", "TAG", "", "VIDEO_CALL", "", "VOICE_CALL", "pateint_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}