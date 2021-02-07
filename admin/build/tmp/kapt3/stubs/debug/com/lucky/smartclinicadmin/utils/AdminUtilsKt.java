package com.lucky.smartclinicadmin.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000`\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a9\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\'\u0010\u0011\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u0012H\u0000\u001a*\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0004\u0012\u00020\u000f0\u0012H\u0000\u001a*\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0004\u0012\u00020\u000f0\u0012H\u0000\u001a\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0001H\u0000\u001aM\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020%0$2\'\u0010\u0011\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u0012H\u0000\u001a,\u0010&\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u00012\u0012\u0010\'\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020%0$H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f\u00a8\u0006("}, d2 = {"COLLECTION_USERS_DOCTORS_REF", "", "COLLECTION_USERS_PATIENTS_REF", "fireStoreInstance", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getFireStoreInstance", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "fireStoreInstance$delegate", "Lkotlin/Lazy;", "storageInstance", "Lcom/google/firebase/storage/FirebaseStorage;", "getStorageInstance", "()Lcom/google/firebase/storage/FirebaseStorage;", "storageInstance$delegate", "deleteDoctor", "", "id", "onComplete", "Lkotlin/Function1;", "Lcom/google/android/gms/tasks/Task;", "Ljava/lang/Void;", "Lkotlin/ParameterName;", "name", "task", "getDoctorsListenerRegistration", "Lcom/google/firebase/firestore/ListenerRegistration;", "context", "Landroid/content/Context;", "", "Lcom/xwray/groupie/kotlinandroidextensions/Item;", "getPatientsCollection", "pathToReference", "Lcom/google/firebase/storage/StorageReference;", "path", "updateDoctor", "fields", "", "", "verifyDoctor", "data", "admin_debug"})
public final class AdminUtilsKt {
    private static final java.lang.String COLLECTION_USERS_PATIENTS_REF = "users/user_patient/patients";
    private static final java.lang.String COLLECTION_USERS_DOCTORS_REF = "users/user_doctors/doctors";
    private static final kotlin.Lazy fireStoreInstance$delegate = null;
    private static final kotlin.Lazy storageInstance$delegate = null;
    
    private static final com.google.firebase.firestore.FirebaseFirestore getFireStoreInstance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.google.firebase.firestore.ListenerRegistration getDoctorsListenerRegistration(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item>, kotlin.Unit> onComplete) {
        return null;
    }
    
    public static final void verifyDoctor(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Object> data) {
    }
    
    public static final void updateDoctor(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Object> fields, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.google.android.gms.tasks.Task<java.lang.Void>, kotlin.Unit> onComplete) {
    }
    
    public static final void deleteDoctor(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.google.android.gms.tasks.Task<java.lang.Void>, kotlin.Unit> onComplete) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.google.firebase.firestore.ListenerRegistration getPatientsCollection(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item>, kotlin.Unit> onComplete) {
        return null;
    }
    
    private static final com.google.firebase.storage.FirebaseStorage getStorageInstance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.google.firebase.storage.StorageReference pathToReference(@org.jetbrains.annotations.NotNull()
    java.lang.String path) {
        return null;
    }
}