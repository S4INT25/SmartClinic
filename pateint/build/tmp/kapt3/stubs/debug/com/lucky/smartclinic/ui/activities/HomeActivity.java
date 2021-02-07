package com.lucky.smartclinic.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0004J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\rH\u0014J\b\u0010\u0016\u001a\u00020\rH\u0014J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/lucky/smartclinic/ui/activities/HomeActivity;", "Lcom/lucky/smartclinic/ui/activities/BaseActivity;", "Lcom/lucky/smartclinic/service/SinchService$StartFailedListener;", "Lcom/lucky/smartclinic/ui/fragments/chats/ChatFragment$SinchCallListener;", "()V", "appBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "headers", "", "", "patient", "Lcom/lucky/smartclinic/model/Patient;", "makeCall", "", "id", "name", "callType", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onServiceConnected", "onStartFailed", "error", "Lcom/sinch/android/rtc/SinchError;", "onStarted", "onStop", "onSupportNavigateUp", "", "setProfilePicInNavHeader", "updateStatusAndSetLastSeen", "Companion", "pateint_debug"})
public final class HomeActivity extends com.lucky.smartclinic.ui.activities.BaseActivity implements com.lucky.smartclinic.service.SinchService.StartFailedListener, com.lucky.smartclinic.ui.fragments.chats.ChatFragment.SinchCallListener {
    private androidx.navigation.ui.AppBarConfiguration appBarConfiguration;
    private java.util.Map<java.lang.String, java.lang.String> headers;
    private com.lucky.smartclinic.model.Patient patient;
    private static final java.lang.String TAG = "HomeActivity";
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinic.ui.activities.HomeActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setProfilePicInNavHeader() {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    @java.lang.Override()
    public void onStarted() {
    }
    
    @java.lang.Override()
    public void onStartFailed(@org.jetbrains.annotations.NotNull()
    com.sinch.android.rtc.SinchError error) {
    }
    
    @java.lang.Override()
    protected void onServiceConnected() {
    }
    
    @java.lang.Override()
    public void makeCall(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int callType) {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    private final void updateStatusAndSetLastSeen() {
    }
    
    public HomeActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/lucky/smartclinic/ui/activities/HomeActivity$Companion;", "", "()V", "TAG", "", "pateint_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}