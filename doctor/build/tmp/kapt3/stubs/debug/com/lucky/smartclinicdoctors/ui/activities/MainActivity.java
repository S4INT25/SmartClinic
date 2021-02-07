package com.lucky.smartclinicdoctors.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\nH\u0014J\u0012\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\nH\u0014J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/lucky/smartclinicdoctors/ui/activities/MainActivity;", "Lcom/lucky/smartclinicdoctors/ui/activities/BaseActivity;", "Lcom/lucky/smartclinicdoctors/service/SinchService$StartFailedListener;", "Lcom/lucky/smartclinicdoctors/ui/fragments/pateint/ChatFragment$SinchCallListener;", "Lcom/lucky/smartclinicdoctors/ui/fragments/appointments/AppointmentDialog$AppointmentDialogListener;", "Lcom/lucky/smartclinicdoctors/ui/fragments/appointments/DoctorsNoteDialog$DoctorNoteDialogListener;", "()V", "doctor", "Lcom/lucky/smartclinicdoctors/model/Doctor;", "makeCall", "", "id", "", "name", "callType", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDialogNegativeClick", "dialog", "Landroidx/fragment/app/DialogFragment;", "onDialogNoteNegativeClick", "onDialogNotePositiveClick", "data", "Landroid/content/Intent;", "onDialogPositiveClick", "onServiceConnected", "onStartFailed", "error", "Lcom/sinch/android/rtc/SinchError;", "onStarted", "onStop", "saveAppointmentNote", "saveAppointmentToFireStore", "doc", "Companion", "doctor_debug"})
public final class MainActivity extends com.lucky.smartclinicdoctors.ui.activities.BaseActivity implements com.lucky.smartclinicdoctors.service.SinchService.StartFailedListener, com.lucky.smartclinicdoctors.ui.fragments.pateint.ChatFragment.SinchCallListener, com.lucky.smartclinicdoctors.ui.fragments.appointments.AppointmentDialog.AppointmentDialogListener, com.lucky.smartclinicdoctors.ui.fragments.appointments.DoctorsNoteDialog.DoctorNoteDialogListener {
    private com.lucky.smartclinicdoctors.model.Doctor doctor;
    private static final java.lang.String TAG = "MainActivity";
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinicdoctors.ui.activities.MainActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onStarted() {
    }
    
    @java.lang.Override()
    public void onStartFailed(@org.jetbrains.annotations.Nullable()
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
    
    @java.lang.Override()
    public void onDialogPositiveClick(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.DialogFragment dialog, @org.jetbrains.annotations.NotNull()
    android.content.Intent data) {
    }
    
    private final void saveAppointmentToFireStore(android.content.Intent data, com.lucky.smartclinicdoctors.model.Doctor doc) {
    }
    
    @java.lang.Override()
    public void onDialogNegativeClick(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.DialogFragment dialog) {
    }
    
    @java.lang.Override()
    public void onDialogNotePositiveClick(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.DialogFragment dialog, @org.jetbrains.annotations.NotNull()
    android.content.Intent data) {
    }
    
    private final void saveAppointmentNote(android.content.Intent data) {
    }
    
    @java.lang.Override()
    public void onDialogNoteNegativeClick(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.DialogFragment dialog) {
    }
    
    public MainActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/lucky/smartclinicdoctors/ui/activities/MainActivity$Companion;", "", "()V", "TAG", "", "doctor_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}