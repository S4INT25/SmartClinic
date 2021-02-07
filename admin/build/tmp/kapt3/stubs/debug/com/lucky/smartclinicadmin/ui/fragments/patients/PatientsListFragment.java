package com.lucky.smartclinicadmin.ui.fragments.patients;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/lucky/smartclinicadmin/ui/fragments/patients/PatientsListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "patientsSection", "Lcom/xwray/groupie/Section;", "shouldInitRecyclerView", "", "viewModel", "Lcom/lucky/smartclinicadmin/ui/fragments/patients/PatientViewModel;", "getViewModel", "()Lcom/lucky/smartclinicadmin/ui/fragments/patients/PatientViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onResume", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "updateRecyclerView", "items", "", "Lcom/xwray/groupie/kotlinandroidextensions/Item;", "Companion", "admin_debug"})
public final class PatientsListFragment extends androidx.fragment.app.Fragment {
    private boolean shouldInitRecyclerView = true;
    private com.xwray.groupie.Section patientsSection;
    private final kotlin.Lazy viewModel$delegate = null;
    private static final java.lang.String TAG = "PatientsListFragment";
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinicadmin.ui.fragments.patients.PatientsListFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.lucky.smartclinicadmin.ui.fragments.patients.PatientViewModel getViewModel() {
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
    
    public PatientsListFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/lucky/smartclinicadmin/ui/fragments/patients/PatientsListFragment$Companion;", "", "()V", "TAG", "", "admin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}