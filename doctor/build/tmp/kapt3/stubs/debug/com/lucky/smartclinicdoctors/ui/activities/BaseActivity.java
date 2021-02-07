package com.lucky.smartclinicdoctors.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J+\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016\u00a2\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0012H\u0014J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0012H\u0002J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010%\u001a\u00020\u0012H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0018\u00010\u000bR\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006&"}, d2 = {"Lcom/lucky/smartclinicdoctors/ui/activities/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/content/ServiceConnection;", "()V", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "messenger", "Landroid/os/Messenger;", "sinchServiceInterface", "Lcom/lucky/smartclinicdoctors/service/SinchService$SinchServiceInterface;", "Lcom/lucky/smartclinicdoctors/service/SinchService;", "getSinchServiceInterface", "()Lcom/lucky/smartclinicdoctors/service/SinchService$SinchServiceInterface;", "setSinchServiceInterface", "(Lcom/lucky/smartclinicdoctors/service/SinchService$SinchServiceInterface;)V", "bindService", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onServiceConnected", "componentName", "Landroid/content/ComponentName;", "iBinder", "Landroid/os/IBinder;", "onServiceDisconnected", "onStart", "doctor_debug"})
public abstract class BaseActivity extends androidx.appcompat.app.AppCompatActivity implements android.content.ServiceConnection {
    @org.jetbrains.annotations.Nullable()
    private com.lucky.smartclinicdoctors.service.SinchService.SinchServiceInterface sinchServiceInterface;
    private final android.os.HandlerThread handlerThread = null;
    private final android.os.Handler handler = null;
    private final android.os.Messenger messenger = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final com.lucky.smartclinicdoctors.service.SinchService.SinchServiceInterface getSinchServiceInterface() {
        return null;
    }
    
    public final void setSinchServiceInterface(@org.jetbrains.annotations.Nullable()
    com.lucky.smartclinicdoctors.service.SinchService.SinchServiceInterface p0) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onServiceConnected(@org.jetbrains.annotations.NotNull()
    android.content.ComponentName componentName, @org.jetbrains.annotations.NotNull()
    android.os.IBinder iBinder) {
    }
    
    @java.lang.Override()
    public void onServiceDisconnected(@org.jetbrains.annotations.NotNull()
    android.content.ComponentName componentName) {
    }
    
    protected void onServiceConnected() {
    }
    
    private final void onServiceDisconnected() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void bindService() {
    }
    
    public BaseActivity() {
        super();
    }
}