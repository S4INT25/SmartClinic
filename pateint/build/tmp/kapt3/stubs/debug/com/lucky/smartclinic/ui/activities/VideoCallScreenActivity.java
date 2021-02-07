package com.lucky.smartclinic.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 -2\u00020\u0001:\u0003-./B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\u0012\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0014J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0014J\b\u0010$\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020\u0015H\u0016J\b\u0010\'\u001a\u00020\u0015H\u0002J\u0018\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0002J\b\u0010+\u001a\u00020\u0015H\u0002J\b\u0010,\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/lucky/smartclinic/ui/activities/VideoCallScreenActivity;", "Lcom/lucky/smartclinic/ui/activities/BaseActivity;", "()V", "mAddedListener", "", "mAudioPlayer", "Lcom/lucky/smartclinic/utils/AudioPlayer;", "mCallDuration", "Landroid/widget/TextView;", "mCallId", "", "mCallState", "mCallerName", "mDurationTask", "Lcom/lucky/smartclinic/ui/activities/VideoCallScreenActivity$UpdateCallDurationTask;", "mLocalVideoViewAdded", "mRemoteVideoViewAdded", "mTimer", "Ljava/util/Timer;", "mToggleVideoViewPositions", "addLocalView", "", "addRemoteView", "endCall", "formatTimeSpan", "totalSeconds", "", "getVideoView", "Landroid/view/ViewGroup;", "localView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRestoreInstanceState", "onSaveInstanceState", "onServiceConnected", "onStart", "onStop", "removeVideoViews", "setVideoViewsVisibility", "localVideoVisibile", "remoteVideoVisible", "updateCallDuration", "updateUI", "Companion", "SinchCallListener", "UpdateCallDurationTask", "pateint_debug"})
public final class VideoCallScreenActivity extends com.lucky.smartclinic.ui.activities.BaseActivity {
    private com.lucky.smartclinic.utils.AudioPlayer mAudioPlayer;
    private java.util.Timer mTimer;
    private com.lucky.smartclinic.ui.activities.VideoCallScreenActivity.UpdateCallDurationTask mDurationTask;
    private java.lang.String mCallId;
    private boolean mAddedListener = false;
    private boolean mLocalVideoViewAdded = false;
    private boolean mRemoteVideoViewAdded = false;
    private android.widget.TextView mCallDuration;
    private android.widget.TextView mCallState;
    private android.widget.TextView mCallerName;
    private boolean mToggleVideoViewPositions = false;
    private static final java.lang.String TAG = "VideoCallScreenActivity";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ADDED_LISTENER = "addedListener";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VIEWS_TOGGLED = "viewsToggled";
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinic.ui.activities.VideoCallScreenActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onRestoreInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onServiceConnected() {
    }
    
    private final void updateUI() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onStart() {
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
    
    private final android.view.ViewGroup getVideoView(boolean localView) {
        return null;
    }
    
    private final void addLocalView() {
    }
    
    private final void addRemoteView() {
    }
    
    private final void removeVideoViews() {
    }
    
    private final void setVideoViewsVisibility(boolean localVideoVisibile, boolean remoteVideoVisible) {
    }
    
    public VideoCallScreenActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/lucky/smartclinic/ui/activities/VideoCallScreenActivity$UpdateCallDurationTask;", "Ljava/util/TimerTask;", "(Lcom/lucky/smartclinic/ui/activities/VideoCallScreenActivity;)V", "run", "", "pateint_debug"})
    final class UpdateCallDurationTask extends java.util.TimerTask {
        
        @java.lang.Override()
        public void run() {
        }
        
        public UpdateCallDurationTask() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/lucky/smartclinic/ui/activities/VideoCallScreenActivity$SinchCallListener;", "Lcom/sinch/android/rtc/video/VideoCallListener;", "(Lcom/lucky/smartclinic/ui/activities/VideoCallScreenActivity;)V", "onCallEnded", "", "call", "Lcom/sinch/android/rtc/calling/Call;", "onCallEstablished", "onCallProgressing", "onShouldSendPushNotification", "pushPairs", "", "Lcom/sinch/android/rtc/PushPair;", "onVideoTrackAdded", "onVideoTrackPaused", "onVideoTrackResumed", "pateint_debug"})
    final class SinchCallListener implements com.sinch.android.rtc.video.VideoCallListener {
        
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
        
        @java.lang.Override()
        public void onVideoTrackAdded(@org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.calling.Call call) {
        }
        
        @java.lang.Override()
        public void onVideoTrackPaused(@org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.calling.Call call) {
        }
        
        @java.lang.Override()
        public void onVideoTrackResumed(@org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.calling.Call call) {
        }
        
        public SinchCallListener() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/lucky/smartclinic/ui/activities/VideoCallScreenActivity$Companion;", "", "()V", "ADDED_LISTENER", "", "TAG", "VIEWS_TOGGLED", "pateint_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}