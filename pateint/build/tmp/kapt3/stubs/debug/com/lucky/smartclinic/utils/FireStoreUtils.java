package com.lucky.smartclinic.utils;

import java.lang.System;

/**
 * Firebase utils object for getting and storing data
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0004\u0012\u00020%0\"J0\u0010&\u001a\u00020\u001e2\u0006\u0010\'\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0004\u0012\u00020%0\"J(\u0010(\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0004\u0012\u00020%0\"JA\u0010)\u001a\u00020%2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020%0\"2%\u0010,\u001a!\u0012\u0017\u0012\u00150-j\u0002`.\u00a2\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020%0\"J(\u00102\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0004\u0012\u00020%0\"J/\u00103\u001a\u00020%2\'\u0010*\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000404\u00a2\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020%0\"J\u0010\u00106\u001a\u0004\u0018\u00010\u00042\u0006\u00107\u001a\u000208J1\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020\u00042!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\'\u0012\u0004\u0012\u00020%0\"J\u001c\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020+2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020%0=J6\u0010>\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00040#2\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0004\u0012\u00020%0\"J\u000e\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020\u001eJ\u0016\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020D2\u0006\u0010\'\u001a\u00020\u0004J\u0014\u0010E\u001a\u00020%2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000404J\u000e\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u000208J~\u0010I\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u0002082\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010\u00042\f\u0010*\u001a\b\u0012\u0004\u0012\u00020%0=J\u000e\u0010W\u001a\u00020%2\u0006\u0010X\u001a\u00020YR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006Z"}, d2 = {"Lcom/lucky/smartclinic/utils/FireStoreUtils;", "", "()V", "COLLECTION_USERS_DOCTORS_REF", "", "COLLECTION_USERS_PATIENTS_REF", "DAY_MILLIS", "", "HOUR_MILLIS", "MINUTE_MILLIS", "SECOND_MILLIS", "TAG", "chatChannelsCollectionRef", "Lcom/google/firebase/firestore/CollectionReference;", "currentUserDocRefs", "Lcom/google/firebase/firestore/DocumentReference;", "getCurrentUserDocRefs", "()Lcom/google/firebase/firestore/DocumentReference;", "fireStoreInstance", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getFireStoreInstance", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "fireStoreInstance$delegate", "Lkotlin/Lazy;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getFirebaseAuth$pateint_debug", "()Lcom/google/firebase/auth/FirebaseAuth;", "firebaseAuth$delegate", "addAppointmentsListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "context", "Landroid/content/Context;", "onListen", "Lkotlin/Function1;", "", "Lcom/xwray/groupie/kotlinandroidextensions/Item;", "", "addChatMessagesListener", "channelId", "addDoctorsEngagedWithChatListener", "getCurrentUser", "onComplete", "Lcom/lucky/smartclinic/model/Patient;", "onFailure", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "error", "getDoctors", "getFCMRegistrationTokens", "", "tokens", "getLastSeen", "lastSeenTime", "", "getOrCreateChatChannel", "otherUserId", "initCurrentUserIfFirstTime", "patient", "Lkotlin/Function0;", "queryDoctor", "query", "removeListener", "registration", "sendMessage", "message", "Lcom/lucky/smartclinic/model/Message;", "setFCMRegistrationTokens", "registrationTokens", "setLastSeen", "lastSeen", "updateCurrentUser", "firstName", "lastName", "phoneNumber", "nrcNumber", "dob", "sex", "address", "bio", "occupation", "weight", "", "height", "profilePicturePath", "updateOnlineStatus", "isOnline", "", "pateint_debug"})
public final class FireStoreUtils {
    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60000;
    private static final int HOUR_MILLIS = 3600000;
    private static final int DAY_MILLIS = 86400000;
    private static final java.lang.String COLLECTION_USERS_PATIENTS_REF = "users/user_patient/patients";
    private static final java.lang.String COLLECTION_USERS_DOCTORS_REF = "users/user_doctors/doctors";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "FireStoreUtils";
    private static final kotlin.Lazy fireStoreInstance$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy firebaseAuth$delegate = null;
    private static final com.google.firebase.firestore.CollectionReference chatChannelsCollectionRef = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinic.utils.FireStoreUtils INSTANCE = null;
    
    private final com.google.firebase.firestore.FirebaseFirestore getFireStoreInstance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getFirebaseAuth$pateint_debug() {
        return null;
    }
    
    private final com.google.firebase.firestore.DocumentReference getCurrentUserDocRefs() {
        return null;
    }
    
    /**
     * add user for the first time
     */
    public final void initCurrentUserIfFirstTime(@org.jetbrains.annotations.NotNull()
    com.lucky.smartclinic.model.Patient patient, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onComplete) {
    }
    
    /**
     * get current user document
     */
    public final void getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.lucky.smartclinic.model.Patient, kotlin.Unit> onComplete, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Exception, kotlin.Unit> onFailure) {
    }
    
    /**
     * update current user(patient) information
     */
    public final void updateCurrentUser(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String firstName, @org.jetbrains.annotations.NotNull()
    java.lang.String lastName, long phoneNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String nrcNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String dob, @org.jetbrains.annotations.NotNull()
    java.lang.String sex, @org.jetbrains.annotations.NotNull()
    java.lang.String address, @org.jetbrains.annotations.NotNull()
    java.lang.String bio, @org.jetbrains.annotations.NotNull()
    java.lang.String occupation, double weight, double height, @org.jetbrains.annotations.Nullable()
    java.lang.String profilePicturePath, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onComplete) {
    }
    
    /**
     * listen  to changes on doctors collection
     */
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.ListenerRegistration getDoctors(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item>, kotlin.Unit> onListen) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.ListenerRegistration addDoctorsEngagedWithChatListener(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item>, kotlin.Unit> onListen) {
        return null;
    }
    
    public final void queryDoctor(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> query, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item>, kotlin.Unit> onListen) {
    }
    
    /**
     * remove listener for changes on doctors collection
     */
    public final void removeListener(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.ListenerRegistration registration) {
    }
    
    /**
     * create chat channel for the first time
     * get chat channel if already created
     */
    public final void getOrCreateChatChannel(@org.jetbrains.annotations.NotNull()
    java.lang.String otherUserId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onComplete) {
    }
    
    /**
     * Add Chat message listener on messages collection
     */
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.ListenerRegistration addChatMessagesListener(@org.jetbrains.annotations.NotNull()
    java.lang.String channelId, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item>, kotlin.Unit> onListen) {
        return null;
    }
    
    /**
     * save message to message document
     */
    public final void sendMessage(@org.jetbrains.annotations.NotNull()
    com.lucky.smartclinic.model.Message message, @org.jetbrains.annotations.NotNull()
    java.lang.String channelId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.ListenerRegistration addAppointmentsListener(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item>, kotlin.Unit> onListen) {
        return null;
    }
    
    public final void updateOnlineStatus(boolean isOnline) {
    }
    
    public final void setLastSeen(long lastSeen) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLastSeen(long lastSeenTime) {
        return null;
    }
    
    /**
     * region FCM
     */
    public final void getFCMRegistrationTokens(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<java.lang.String>, kotlin.Unit> onComplete) {
    }
    
    /**
     * set FCM registration Token on users document snapshot
     */
    public final void setFCMRegistrationTokens(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> registrationTokens) {
    }
    
    private FireStoreUtils() {
        super();
    }
}