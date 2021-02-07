package com.lucky.smartclinicdoctors.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\bH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/lucky/smartclinicdoctors/ui/activities/IncomingCallScreenActivity;", "Lcom/lucky/smartclinicdoctors/ui/activities/BaseActivity;", "()V", "mAudioPlayer", "Lcom/lucky/smartclinicdoctors/utils/AudioPlayer;", "mCallId", "", "answerClicked", "", "declineClicked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onServiceConnected", "Companion", "doctor_debug"})
public final class IncomingCallScreenActivity extends com.lucky.smartclinicdoctors.ui.activities.BaseActivity {
    private java.lang.String mCallId;
    private com.lucky.smartclinicdoctors.utils.AudioPlayer mAudioPlayer;
    private static final java.lang.String TAG = "IncomingCallScreenActivity";
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinicdoctors.ui.activities.IncomingCallScreenActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onServiceConnected() {
    }
    
    private final void answerClicked() {
    }
    
    private final void declineClicked() {
    }
    
    public IncomingCallScreenActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/lucky/smartclinicdoctors/ui/activities/IncomingCallScreenActivity$Companion;", "", "()V", "TAG", "", "doctor_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}