package com.lucky.smartclinicdoctors.ui.fragments.pateint;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\"\u0010%\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010&\u001a\u00020\u0017H\u0002J\b\u0010\'\u001a\u00020\u0017H\u0002J\u0016\u0010(\u001a\u00020\u00172\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/lucky/smartclinicdoctors/ui/fragments/pateint/ChatFragment;", "Landroidx/fragment/app/Fragment;", "()V", "args", "Lcom/lucky/smartclinicdoctors/ui/fragments/pateint/ChatFragmentArgs;", "getArgs", "()Lcom/lucky/smartclinicdoctors/ui/fragments/pateint/ChatFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "currentUser", "Lcom/lucky/smartclinicdoctors/model/Doctor;", "isRecyclerInitialized", "", "listener", "Lcom/lucky/smartclinicdoctors/ui/fragments/pateint/ChatFragment$SinchCallListener;", "mChannelId", "", "messageListenerRegistration", "Lcom/google/firebase/firestore/ListenerRegistration;", "messageSection", "Lcom/xwray/groupie/Section;", "otherUserId", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "saveAndLoadPicture", "selectProfileImage", "updateLastSeen", "updateRecyclerView", "message", "", "Lcom/xwray/groupie/kotlinandroidextensions/Item;", "Companion", "SinchCallListener", "doctor_debug"})
public final class ChatFragment extends androidx.fragment.app.Fragment {
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    private com.google.firebase.firestore.ListenerRegistration messageListenerRegistration;
    private java.lang.String otherUserId;
    private java.lang.String mChannelId;
    private com.lucky.smartclinicdoctors.model.Doctor currentUser;
    private com.xwray.groupie.Section messageSection;
    private boolean isRecyclerInitialized = true;
    private com.lucky.smartclinicdoctors.ui.fragments.pateint.ChatFragment.SinchCallListener listener;
    public static final int RC_SELECT_IMAGE = 22;
    private static final java.lang.String TAG = "ChatFragment";
    public static final int VIDEO_CALL = 1;
    public static final int VOICE_CALL = 2;
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinicdoctors.ui.fragments.pateint.ChatFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.lucky.smartclinicdoctors.ui.fragments.pateint.ChatFragmentArgs getArgs() {
        return null;
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateLastSeen() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void updateRecyclerView(java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item> message) {
    }
    
    private final void selectProfileImage() {
    }
    
    private final void saveAndLoadPicture(int requestCode, int resultCode, android.content.Intent data) {
    }
    
    public ChatFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/lucky/smartclinicdoctors/ui/fragments/pateint/ChatFragment$SinchCallListener;", "", "makeCall", "", "id", "", "name", "callType", "", "doctor_debug"})
    public static abstract interface SinchCallListener {
        
        public abstract void makeCall(@org.jetbrains.annotations.NotNull()
        java.lang.String id, @org.jetbrains.annotations.NotNull()
        java.lang.String name, int callType);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/lucky/smartclinicdoctors/ui/fragments/pateint/ChatFragment$Companion;", "", "()V", "RC_SELECT_IMAGE", "", "TAG", "", "VIDEO_CALL", "VOICE_CALL", "doctor_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}