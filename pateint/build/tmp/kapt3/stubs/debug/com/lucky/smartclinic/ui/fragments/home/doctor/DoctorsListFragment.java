package com.lucky.smartclinic.ui.fragments.home.doctor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\u0012\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\u0011H\u0002J\u0016\u0010\"\u001a\u00020\u00112\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/lucky/smartclinic/ui/fragments/home/doctor/DoctorsListFragment;", "Landroidx/fragment/app/Fragment;", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "()V", "doctorViewModel", "Lcom/lucky/smartclinic/ui/fragments/home/doctor/DoctorViewModel;", "getDoctorViewModel", "()Lcom/lucky/smartclinic/ui/fragments/home/doctor/DoctorViewModel;", "doctorViewModel$delegate", "Lkotlin/Lazy;", "doctorsSection", "Lcom/xwray/groupie/Section;", "onItemClick", "Lcom/xwray/groupie/OnItemClickListener;", "shouldInitRecyclerView", "", "getDoctors", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onQueryTextChange", "p0", "", "onQueryTextSubmit", "onResume", "onStart", "setUpSearch", "updateRecyclerView", "items", "", "Lcom/xwray/groupie/kotlinandroidextensions/Item;", "Companion", "pateint_debug"})
public final class DoctorsListFragment extends androidx.fragment.app.Fragment implements androidx.appcompat.widget.SearchView.OnQueryTextListener {
    private boolean shouldInitRecyclerView = true;
    private com.xwray.groupie.Section doctorsSection;
    private final kotlin.Lazy doctorViewModel$delegate = null;
    private final com.xwray.groupie.OnItemClickListener onItemClick = null;
    private static final java.lang.String TAG = "DoctorsListFragment";
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinic.ui.fragments.home.doctor.DoctorsListFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.lucky.smartclinic.ui.fragments.home.doctor.DoctorViewModel getDoctorViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setUpSearch() {
    }
    
    private final void getDoctors() {
    }
    
    private final void updateRecyclerView(java.util.List<? extends com.xwray.groupie.kotlinandroidextensions.Item> items) {
    }
    
    @java.lang.Override()
    public boolean onQueryTextSubmit(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onQueryTextChange(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
        return false;
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    public DoctorsListFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/lucky/smartclinic/ui/fragments/home/doctor/DoctorsListFragment$Companion;", "", "()V", "TAG", "", "pateint_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}