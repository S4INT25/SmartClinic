package com.lucky.smartclinic.ui.fragments.home.news;

import java.lang.System;

/**
 * Show a list of latest news about health
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/lucky/smartclinic/ui/fragments/home/news/NewsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "newsSection", "Lcom/xwray/groupie/Section;", "newsViewModel", "Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel;", "getNewsViewModel", "()Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel;", "newsViewModel$delegate", "Lkotlin/Lazy;", "onItemClick", "Lcom/xwray/groupie/OnItemClickListener;", "shouldInitRecyclerView", "", "fetchNewsData", "", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "updateRecyclerView", "items", "", "Lcom/xwray/groupie/kotlinandroidextensions/Item;", "Companion", "pateint_debug"})
public final class NewsFragment extends androidx.fragment.app.Fragment {
    private boolean shouldInitRecyclerView = true;
    private com.xwray.groupie.Section newsSection;
    private final kotlin.Lazy newsViewModel$delegate = null;
    private final com.xwray.groupie.OnItemClickListener onItemClick = null;
    @org.jetbrains.annotations.Nullable()
    private static final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinic.ui.fragments.home.news.NewsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.lucky.smartclinic.ui.fragments.home.news.NewsViewModel getNewsViewModel() {
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
    
    private final void fetchNewsData() {
    }
    
    public NewsFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/lucky/smartclinic/ui/fragments/home/news/NewsFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "pateint_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getTAG() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}