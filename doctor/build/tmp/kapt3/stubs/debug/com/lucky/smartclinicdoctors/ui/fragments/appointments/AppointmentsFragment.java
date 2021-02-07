package com.lucky.smartclinicdoctors.ui.fragments.appointments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/lucky/smartclinicdoctors/ui/fragments/appointments/AppointmentsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "appointmentViewModel", "Lcom/lucky/smartclinicdoctors/ui/fragments/appointments/AppointmentViewModel;", "getAppointmentViewModel", "()Lcom/lucky/smartclinicdoctors/ui/fragments/appointments/AppointmentViewModel;", "appointmentViewModel$delegate", "Lkotlin/Lazy;", "appointmentsSection", "Lcom/xwray/groupie/Section;", "onItemLongClickListener", "Lcom/xwray/groupie/OnItemLongClickListener;", "shouldInitRecyclerView", "", "onResume", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "updateRecyclerView", "items", "", "Lcom/xwray/groupie/kotlinandroidextensions/Item;", "Companion", "DeleteDialog", "doctor_debug"})
public final class AppointmentsFragment extends androidx.fragment.app.Fragment {
    private boolean shouldInitRecyclerView = true;
    private com.xwray.groupie.Section appointmentsSection;
    private final kotlin.Lazy appointmentViewModel$delegate = null;
    private final com.xwray.groupie.OnItemLongClickListener onItemLongClickListener = null;
    private static final java.lang.String TAG = "AppointmentsFragment";
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinicdoctors.ui.fragments.appointments.AppointmentsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.lucky.smartclinicdoctors.ui.fragments.appointments.AppointmentViewModel getAppointmentViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateRecyclerView(java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item> items) {
    }
    
    public AppointmentsFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/lucky/smartclinicdoctors/ui/fragments/appointments/AppointmentsFragment$DeleteDialog;", "Landroidx/fragment/app/DialogFragment;", "id", "", "(Ljava/lang/String;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "doctor_debug"})
    public static final class DeleteDialog extends androidx.fragment.app.DialogFragment {
        private final java.lang.String id = null;
        private java.util.HashMap _$_findViewCache;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable()
        android.os.Bundle savedInstanceState) {
            return null;
        }
        
        public DeleteDialog(@org.jetbrains.annotations.NotNull()
        java.lang.String id) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/lucky/smartclinicdoctors/ui/fragments/appointments/AppointmentsFragment$Companion;", "", "()V", "TAG", "", "doctor_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}