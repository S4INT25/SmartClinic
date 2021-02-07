package com.lucky.smartclinicdoctors.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0004J(\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0018\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0&\u0012\u0004\u0012\u00020\u001c0%J0\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0018\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0&\u0012\u0004\u0012\u00020\u001c0%J(\u0010*\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0018\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0&\u0012\u0004\u0012\u00020\u001c0%J\u001e\u0010+\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020\u0004J\u0016\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#J\u001a\u00100\u001a\u00020\u001c2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001c0%J/\u00103\u001a\u00020\u001c2\'\u00101\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000404\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001c0%J\u0010\u00108\u001a\u0004\u0018\u00010\u00042\u0006\u00109\u001a\u00020:J1\u0010;\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00042!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u001c0%J(\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020\u00042\u0018\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0&\u0012\u0004\u0012\u00020\u001c0%J\u001c\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u0002022\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001c0@J\u000e\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020!J\u0016\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020E2\u0006\u0010)\u001a\u00020\u0004J\u0014\u0010F\u001a\u00020\u001c2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000404J\u000e\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020:J\u0012\u0010J\u001a\u00020\u001c2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0004J\u000e\u0010L\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020NJ<\u0010O\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u00042\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010Q2\u0018\u00101\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0R\u0012\u0004\u0012\u00020\u001c0%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006T"}, d2 = {"Lcom/lucky/smartclinicdoctors/utils/FireStoreUtils;", "", "()V", "COLLECTION_USERS_DOCTORS_REF", "", "COLLECTION_USERS_PATIENTS_REF", "DAY_MILLIS", "", "HOUR_MILLIS", "MINUTE_MILLIS", "SECOND_MILLIS", "TAG", "chatChannelsCollectionRef", "Lcom/google/firebase/firestore/CollectionReference;", "currentDoctorDocumentRef", "Lcom/google/firebase/firestore/DocumentReference;", "getCurrentDoctorDocumentRef", "()Lcom/google/firebase/firestore/DocumentReference;", "fireStoreInstance", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getFireStoreInstance", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "fireStoreInstance$delegate", "Lkotlin/Lazy;", "patientsCollectionRef", "getPatientsCollectionRef", "()Lcom/google/firebase/firestore/CollectionReference;", "addAppointment", "", "appointment", "Lcom/lucky/smartclinicdoctors/model/Appointment;", "otherUserId", "addAppointmentsListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "context", "Landroid/content/Context;", "onListen", "Lkotlin/Function1;", "", "Lcom/xwray/groupie/kotlinandroidextensions/Item;", "addChatMessagesListener", "channelId", "addPatientsEngagedWithChatListener", "addReportNote", "doctorsNote", "Lcom/lucky/smartclinicdoctors/model/DoctorsNote;", "deletedAppointment", "id", "getCurrentUser", "onComplete", "Lcom/lucky/smartclinicdoctors/model/Doctor;", "getFCMRegistrationTokens", "", "Lkotlin/ParameterName;", "name", "tokens", "getLastSeen", "lastSeenTime", "", "getOrCreateChatChannel", "getReportNotes", "patientsUserId", "initCurrentUserIfFirstTime", "doctor", "Lkotlin/Function0;", "removeListener", "registration", "sendMessage", "message", "Lcom/lucky/smartclinicdoctors/model/Message;", "setFCMRegistrationTokens", "registrationTokens", "setLastSeen", "lastSeen", "updateCurrentUser", "profilePicturePath", "updateOnlineStatus", "isOnline", "", "updateUser", "data", "", "Lcom/google/android/gms/tasks/Task;", "Ljava/lang/Void;", "doctor_debug"})
public final class FireStoreUtils {
    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60000;
    private static final int HOUR_MILLIS = 3600000;
    private static final int DAY_MILLIS = 86400000;
    private static final java.lang.String TAG = "FireStoreUtils";
    private static final java.lang.String COLLECTION_USERS_PATIENTS_REF = "users/user_patient/patients";
    private static final java.lang.String COLLECTION_USERS_DOCTORS_REF = "users/user_doctors/doctors";
    private static final kotlin.Lazy fireStoreInstance$delegate = null;
    private static final com.google.firebase.firestore.CollectionReference chatChannelsCollectionRef = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinicdoctors.utils.FireStoreUtils INSTANCE = null;
    
    private final com.google.firebase.firestore.FirebaseFirestore getFireStoreInstance() {
        return null;
    }
    
    private final com.google.firebase.firestore.DocumentReference getCurrentDoctorDocumentRef() {
        return null;
    }
    
    private final com.google.firebase.firestore.CollectionReference getPatientsCollectionRef() {
        return null;
    }
    
    public final void initCurrentUserIfFirstTime(@org.jetbrains.annotations.NotNull()
    com.lucky.smartclinicdoctors.model.Doctor doctor, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onComplete) {
    }
    
    public final void getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.lucky.smartclinicdoctors.model.Doctor, kotlin.Unit> onComplete) {
    }
    
    public final void updateCurrentUser(@org.jetbrains.annotations.Nullable()
    java.lang.String profilePicturePath) {
    }
    
    public final void updateOnlineStatus(boolean isOnline) {
    }
    
    public final void setLastSeen(long lastSeen) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.ListenerRegistration addPatientsEngagedWithChatListener(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item>, kotlin.Unit> onListen) {
        return null;
    }
    
    public final void removeListener(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.ListenerRegistration registration) {
    }
    
    public final void getOrCreateChatChannel(@org.jetbrains.annotations.NotNull()
    java.lang.String otherUserId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onComplete) {
    }
    
    public final void updateUser(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Object> data, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.google.android.gms.tasks.Task<java.lang.Void>, kotlin.Unit> onComplete) {
    }
    
    public final void addAppointment(@org.jetbrains.annotations.NotNull()
    com.lucky.smartclinicdoctors.model.Appointment appointment, @org.jetbrains.annotations.NotNull()
    java.lang.String otherUserId) {
    }
    
    public final void addReportNote(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.lucky.smartclinicdoctors.model.DoctorsNote doctorsNote, @org.jetbrains.annotations.NotNull()
    java.lang.String otherUserId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.ListenerRegistration getReportNotes(@org.jetbrains.annotations.NotNull()
    java.lang.String patientsUserId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item>, kotlin.Unit> onListen) {
        return null;
    }
    
    public final void deletedAppointment(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.ListenerRegistration addAppointmentsListener(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item>, kotlin.Unit> onListen) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.ListenerRegistration addChatMessagesListener(@org.jetbrains.annotations.NotNull()
    java.lang.String channelId, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item>, kotlin.Unit> onListen) {
        return null;
    }
    
    public final void sendMessage(@org.jetbrains.annotations.NotNull()
    com.lucky.smartclinicdoctors.model.Message message, @org.jetbrains.annotations.NotNull()
    java.lang.String channelId) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLastSeen(long lastSeenTime) {
        return null;
    }
    
    public final void getFCMRegistrationTokens(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<java.lang.String>, kotlin.Unit> onComplete) {
    }
    
    public final void setFCMRegistrationTokens(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> registrationTokens) {
    }
    
    private FireStoreUtils() {
        super();
    }
}