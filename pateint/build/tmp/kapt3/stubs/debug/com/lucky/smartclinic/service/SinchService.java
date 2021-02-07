package com.lucky.smartclinic.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0006*+,-./B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0012\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001fH\u0016J\b\u0010\'\u001a\u00020\u001fH\u0016J\u0010\u0010(\u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0017J\u0006\u0010)\u001a\u00020\u001fR\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/lucky/smartclinic/service/SinchService;", "Landroid/app/Service;", "()V", "isStarted", "", "()Z", "mListener", "Lcom/lucky/smartclinic/service/SinchService$StartFailedListener;", "getMListener", "()Lcom/lucky/smartclinic/service/SinchService$StartFailedListener;", "setMListener", "(Lcom/lucky/smartclinic/service/SinchService$StartFailedListener;)V", "mSettings", "Lcom/lucky/smartclinic/service/SinchService$PersistedSettings;", "mSinchClient", "Lcom/sinch/android/rtc/SinchClient;", "getMSinchClient", "()Lcom/sinch/android/rtc/SinchClient;", "setMSinchClient", "(Lcom/sinch/android/rtc/SinchClient;)V", "mSinchServiceInterface", "Lcom/lucky/smartclinic/service/SinchService$SinchServiceInterface;", "mUserId", "", "getMUserId", "()Ljava/lang/String;", "setMUserId", "(Ljava/lang/String;)V", "messenger", "Landroid/os/Messenger;", "attemptAutoStart", "", "createClient", "userName", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "start", "stop", "Companion", "MySinchClientListener", "PersistedSettings", "SinchCallClientListener", "SinchServiceInterface", "StartFailedListener", "pateint_debug"})
public final class SinchService extends android.app.Service {
    private android.os.Messenger messenger;
    private final com.lucky.smartclinic.service.SinchService.SinchServiceInterface mSinchServiceInterface = null;
    @org.jetbrains.annotations.Nullable()
    private com.sinch.android.rtc.SinchClient mSinchClient;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String mUserId;
    @org.jetbrains.annotations.Nullable()
    private com.lucky.smartclinic.service.SinchService.StartFailedListener mListener;
    private com.lucky.smartclinic.service.SinchService.PersistedSettings mSettings;
    private static final java.lang.String APP_KEY = "c504dbe0-5af3-441e-8db4-db8fc5438027";
    private static final java.lang.String APP_SECRET = "NZEuukKn0EOUfnSs/UuG0g==";
    private static final java.lang.String ENVIRONMENT = "clientapi.sinch.com";
    public static final int MESSAGE_PERMISSIONS_NEEDED = 1;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String REQUIRED_PERMISSION = "REQUIRED_PESMISSION";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MESSENGER = "MESSENGER";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CALL_ID = "CALL_ID";
    private static final java.lang.String TAG = "SinchService";
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinic.service.SinchService.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final com.sinch.android.rtc.SinchClient getMSinchClient() {
        return null;
    }
    
    public final void setMSinchClient(@org.jetbrains.annotations.Nullable()
    com.sinch.android.rtc.SinchClient p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMUserId() {
        return null;
    }
    
    public final void setMUserId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.lucky.smartclinic.service.SinchService.StartFailedListener getMListener() {
        return null;
    }
    
    public final void setMListener(@org.jetbrains.annotations.Nullable()
    com.lucky.smartclinic.service.SinchService.StartFailedListener p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public final void attemptAutoStart() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    public final void start(@org.jetbrains.annotations.Nullable()
    java.lang.String userName) {
    }
    
    private final void createClient(java.lang.String userName) {
    }
    
    public final void stop() {
    }
    
    public final boolean isStarted() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
        return null;
    }
    
    public SinchService() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bJ&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010 \u001a\u00020\u001bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006!"}, d2 = {"Lcom/lucky/smartclinic/service/SinchService$SinchServiceInterface;", "Landroid/os/Binder;", "(Lcom/lucky/smartclinic/service/SinchService;)V", "audioController", "Lcom/sinch/android/rtc/AudioController;", "getAudioController", "()Lcom/sinch/android/rtc/AudioController;", "isStarted", "", "()Z", "userName", "", "getUserName", "()Ljava/lang/String;", "videoController", "Lcom/sinch/android/rtc/video/VideoController;", "getVideoController", "()Lcom/sinch/android/rtc/video/VideoController;", "callUser", "Lcom/sinch/android/rtc/calling/Call;", "userId", "headers", "", "callUserVideo", "getCall", "callId", "retryStartAfterPermissionGranted", "", "setStartListener", "listener", "Lcom/lucky/smartclinic/service/SinchService$StartFailedListener;", "startClient", "stopClient", "pateint_debug"})
    public final class SinchServiceInterface extends android.os.Binder {
        
        @org.jetbrains.annotations.NotNull()
        public final com.sinch.android.rtc.calling.Call callUser(@org.jetbrains.annotations.NotNull()
        java.lang.String userId) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.sinch.android.rtc.calling.Call callUser(@org.jetbrains.annotations.Nullable()
        java.lang.String userId, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.lang.String, java.lang.String> headers) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.sinch.android.rtc.calling.Call callUserVideo(@org.jetbrains.annotations.Nullable()
        java.lang.String userId, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.lang.String, java.lang.String> headers) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUserName() {
            return null;
        }
        
        public final void retryStartAfterPermissionGranted() {
        }
        
        private final boolean isStarted() {
            return false;
        }
        
        public final void startClient(@org.jetbrains.annotations.NotNull()
        java.lang.String userName) {
        }
        
        public final void stopClient() {
        }
        
        public final void setStartListener(@org.jetbrains.annotations.NotNull()
        com.lucky.smartclinic.service.SinchService.StartFailedListener listener) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.sinch.android.rtc.calling.Call getCall(@org.jetbrains.annotations.Nullable()
        java.lang.String callId) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.sinch.android.rtc.video.VideoController getVideoController() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.sinch.android.rtc.AudioController getAudioController() {
            return null;
        }
        
        public SinchServiceInterface() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/lucky/smartclinic/service/SinchService$StartFailedListener;", "", "onStartFailed", "", "error", "Lcom/sinch/android/rtc/SinchError;", "onStarted", "pateint_debug"})
    public static abstract interface StartFailedListener {
        
        public abstract void onStartFailed(@org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.SinchError error);
        
        public abstract void onStarted();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/lucky/smartclinic/service/SinchService$MySinchClientListener;", "Lcom/sinch/android/rtc/SinchClientListener;", "(Lcom/lucky/smartclinic/service/SinchService;)V", "onClientFailed", "", "client", "Lcom/sinch/android/rtc/SinchClient;", "error", "Lcom/sinch/android/rtc/SinchError;", "onClientStarted", "onClientStopped", "onLogMessage", "level", "", "area", "", "message", "onRegistrationCredentialsRequired", "clientRegistration", "Lcom/sinch/android/rtc/ClientRegistration;", "pateint_debug"})
    public final class MySinchClientListener implements com.sinch.android.rtc.SinchClientListener {
        
        @java.lang.Override()
        public void onClientFailed(@org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.SinchClient client, @org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.SinchError error) {
        }
        
        @java.lang.Override()
        public void onClientStarted(@org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.SinchClient client) {
        }
        
        @java.lang.Override()
        public void onClientStopped(@org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.SinchClient client) {
        }
        
        @java.lang.Override()
        public void onLogMessage(int level, @org.jetbrains.annotations.NotNull()
        java.lang.String area, @org.jetbrains.annotations.NotNull()
        java.lang.String message) {
        }
        
        @java.lang.Override()
        public void onRegistrationCredentialsRequired(@org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.SinchClient client, @org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.ClientRegistration clientRegistration) {
        }
        
        public MySinchClientListener() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/lucky/smartclinic/service/SinchService$SinchCallClientListener;", "Lcom/sinch/android/rtc/calling/CallClientListener;", "(Lcom/lucky/smartclinic/service/SinchService;)V", "onIncomingCall", "", "callClient", "Lcom/sinch/android/rtc/calling/CallClient;", "call", "Lcom/sinch/android/rtc/calling/Call;", "pateint_debug"})
    public final class SinchCallClientListener implements com.sinch.android.rtc.calling.CallClientListener {
        
        @java.lang.Override()
        public void onIncomingCall(@org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.calling.CallClient callClient, @org.jetbrains.annotations.NotNull()
        com.sinch.android.rtc.calling.Call call) {
        }
        
        public SinchCallClientListener() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/lucky/smartclinic/service/SinchService$PersistedSettings;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mStore", "Landroid/content/SharedPreferences;", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "Companion", "pateint_debug"})
    static final class PersistedSettings {
        private final android.content.SharedPreferences mStore = null;
        private static final java.lang.String PREF_KEY = "Sinch";
        @org.jetbrains.annotations.NotNull()
        public static final com.lucky.smartclinic.service.SinchService.PersistedSettings.Companion Companion = null;
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getUsername() {
            return null;
        }
        
        public final void setUsername(@org.jetbrains.annotations.Nullable()
        java.lang.String username) {
        }
        
        public PersistedSettings(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/lucky/smartclinic/service/SinchService$PersistedSettings$Companion;", "", "()V", "PREF_KEY", "", "pateint_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/lucky/smartclinic/service/SinchService$Companion;", "", "()V", "APP_KEY", "", "APP_SECRET", "CALL_ID", "ENVIRONMENT", "MESSAGE_PERMISSIONS_NEEDED", "", "MESSENGER", "REQUIRED_PERMISSION", "TAG", "pateint_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}