package com.lucky.smartclinic.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0018\u00010\fR\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/lucky/smartclinic/ui/activities/VoiceCallScreenActivity;", "Lcom/lucky/smartclinic/ui/activities/BaseActivity;", "()V", "mAudioPlayer", "Lcom/lucky/smartclinic/utils/AudioPlayer;", "mCallDuration", "Landroid/widget/TextView;", "mCallId", "", "mCallState", "mCallerName", "mDurationTask", "Lcom/lucky/smartclinic/ui/activities/VoiceCallScreenActivity$UpdateCallDurationTask;", "mTimer", "Ljava/util/Timer;", "endCall", "", "formatTimeSpan", "totalSeconds", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onServiceConnected", "updateCallDuration", "Companion", "SinchCallListener", "UpdateCallDurationTask", "pateint_debug"})
public final class VoiceCallScreenActivity extends com.lucky.smartclinic.ui.activities.BaseActivity {
    private com.lucky.smartclinic.utils.AudioPlayer mAudioPlayer;
    private java.util.Timer mTimer;
    private com.lucky.smartclinic.ui.activities.VoiceCallScreenActivity.UpdateCallDurationTask mDurationTask;
    private java.lang.String mCallId;
    private android.widget.TextView mCallDuration;
    private android.widget.TextView mCallState;
    private android.widget.TextView mCallerName;
    private static final java.lang.String TAG = "VoiceCallScreenActivity";
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinic.ui.activities.VoiceCallScreenActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onServiceConnected() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void endCall() {
    }
    
    private final java.lang.String formatTimeSpan(int totalSeconds) {
        return null;
    }
    
    private final void updateCallDuration() {
    }
    
    public VoiceCallScreenActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/lucky/smartclinic/ui/activities/VoiceCallScreenActivity$UpdateCallDurationTask;", "Ljava/util/TimerTask;", "(Lcom/lucky/smartclinic/ui/activities/VoiceCallScreenActivity;)V", "run", "", "pateint_debug"})
    final class UpdateCallDurationTask extends java.util.TimerTask {
        
        @java.lang.Override()
        public void run() {
        }
        
        public UpdateCallDurationTask() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/lucky/smartclinic/ui/activities/VoiceCallScreenActivity$SinchCallListener;", "Lcom/sinch/android/rtc/calling/CallListener;", "(Lcom/lucky/smartclinic/ui/activities/VoiceCallScreenActivity;)V", "onCallEnded", "", "call", "Lcom/sinch/android/rtc/calling/Call;", "onCallEstablished", "onCallProgressing", "onShouldSendPushNotification", "pushPairs", "", "Lcom/sinch/android/rtc/PushPair;", "pateint_debug"})
    public final class SinchCallListener implements com.sinch.android.rtc.calling.CallListener {
        
        @java.lang.Override()
        public void onCallEnded(@org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.calling.Call call) {
        }
        
        @java.lang.Override()
        public void onCallEstablished(@org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.calling.Call call) {
        }
        
        @java.lang.Override()
        public void onCallProgressing(@org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.calling.Call call) {
        }
        
        @java.lang.Override()
        public void onShouldSendPushNotification(@org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.calling.Call call, @org.jetbrains.annotations.NotNull()
        java.util.List<? extends com.sinch.android.rtc.PushPair> pushPairs) {
        }
        
        public SinchCallListener() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/lucky/smartclinic/ui/activities/VoiceCallScreenActivity$Companion;", "", "()V", "TAG", "", "pateint_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}