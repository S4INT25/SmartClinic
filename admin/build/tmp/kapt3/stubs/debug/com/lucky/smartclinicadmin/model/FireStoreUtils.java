package com.lucky.smartclinicadmin.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00150\u0012J(\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00150\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/lucky/smartclinicadmin/model/FireStoreUtils;", "", "()V", "COLLECTION_USERS_DOCTORS_REF", "", "COLLECTION_USERS_PATIENTS_REF", "TAG", "fireStoreInstance", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getFireStoreInstance", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "fireStoreInstance$delegate", "Lkotlin/Lazy;", "getDoctorsListenerRegistration", "Lcom/google/firebase/firestore/ListenerRegistration;", "context", "Landroid/content/Context;", "onComplete", "Lkotlin/Function1;", "", "Lcom/xwray/groupie/kotlinandroidextensions/Item;", "", "getPatientsCollection", "admin_debug"})
public final class FireStoreUtils {
    private static final java.lang.String COLLECTION_USERS_PATIENTS_REF = "users/user_patient/patients";
    private static final java.lang.String COLLECTION_USERS_DOCTORS_REF = "users/user_doctors/doctors";
    private static final java.lang.String TAG = "FireStoreUtils";
    private static final kotlin.Lazy fireStoreInstance$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinicadmin.model.FireStoreUtils INSTANCE = null;
    
    private final com.google.firebase.firestore.FirebaseFirestore getFireStoreInstance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.ListenerRegistration getDoctorsListenerRegistration(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item>, kotlin.Unit> onComplete) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.ListenerRegistration getPatientsCollection(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item>, kotlin.Unit> onComplete) {
        return null;
    }
    
    private FireStoreUtils() {
        super();
    }
}