package com.lucky.smartclinic.ui.fragments.home.news;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/lucky/smartclinic/repository/SmartClinicRepository;", "(Lcom/lucky/smartclinic/repository/SmartClinicRepository;)V", "_news", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$NewFragmentState;", "news", "Lkotlinx/coroutines/flow/StateFlow;", "getNews", "()Lkotlinx/coroutines/flow/StateFlow;", "onRefreshed", "", "Companion", "NewFragmentState", "pateint_debug"})
public final class NewsViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.flow.MutableStateFlow<com.lucky.smartclinic.ui.fragments.home.news.NewsViewModel.NewFragmentState> _news = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.lucky.smartclinic.ui.fragments.home.news.NewsViewModel.NewFragmentState> news = null;
    private final com.lucky.smartclinic.repository.SmartClinicRepository repository = null;
    private static final java.lang.String TAG = "NewsViewModel";
    @org.jetbrains.annotations.NotNull()
    public static final com.lucky.smartclinic.ui.fragments.home.news.NewsViewModel.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.lucky.smartclinic.ui.fragments.home.news.NewsViewModel.NewFragmentState> getNews() {
        return null;
    }
    
    public final void onRefreshed() {
    }
    
    public NewsViewModel(@org.jetbrains.annotations.NotNull()
    com.lucky.smartclinic.repository.SmartClinicRepository repository) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$NewFragmentState;", "", "()V", "Empty", "Error", "LocalError", "Success", "Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$NewFragmentState$Empty;", "Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$NewFragmentState$Error;", "Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$NewFragmentState$LocalError;", "Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$NewFragmentState$Success;", "pateint_debug"})
    public static abstract class NewFragmentState {
        
        private NewFragmentState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$NewFragmentState$Empty;", "Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$NewFragmentState;", "()V", "pateint_debug"})
        public static final class Empty extends com.lucky.smartclinic.ui.fragments.home.news.NewsViewModel.NewFragmentState {
            @org.jetbrains.annotations.NotNull()
            public static final com.lucky.smartclinic.ui.fragments.home.news.NewsViewModel.NewFragmentState.Empty INSTANCE = null;
            
            private Empty() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$NewFragmentState$Error;", "Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$NewFragmentState;", "error", "Lokhttp3/ResponseBody;", "(Lokhttp3/ResponseBody;)V", "getError", "()Lokhttp3/ResponseBody;", "pateint_debug"})
        public static final class Error extends com.lucky.smartclinic.ui.fragments.home.news.NewsViewModel.NewFragmentState {
            @org.jetbrains.annotations.NotNull()
            private final okhttp3.ResponseBody error = null;
            
            @org.jetbrains.annotations.NotNull()
            public final okhttp3.ResponseBody getError() {
                return null;
            }
            
            public Error(@org.jetbrains.annotations.NotNull()
            okhttp3.ResponseBody error) {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u00a2\u0006\u0002\u0010\u0005R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$NewFragmentState$LocalError;", "Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$NewFragmentState;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "getError", "()Ljava/lang/Exception;", "pateint_debug"})
        public static final class LocalError extends com.lucky.smartclinic.ui.fragments.home.news.NewsViewModel.NewFragmentState {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.Exception error = null;
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.Exception getError() {
                return null;
            }
            
            public LocalError(@org.jetbrains.annotations.NotNull()
            java.lang.Exception error) {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$NewFragmentState$Success;", "Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$NewFragmentState;", "news", "Lcom/lucky/smartclinic/model/News;", "(Lcom/lucky/smartclinic/model/News;)V", "getNews", "()Lcom/lucky/smartclinic/model/News;", "pateint_debug"})
        public static final class Success extends com.lucky.smartclinic.ui.fragments.home.news.NewsViewModel.NewFragmentState {
            @org.jetbrains.annotations.NotNull()
            private final com.lucky.smartclinic.model.News news = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.lucky.smartclinic.model.News getNews() {
                return null;
            }
            
            public Success(@org.jetbrains.annotations.NotNull()
            com.lucky.smartclinic.model.News news) {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/lucky/smartclinic/ui/fragments/home/news/NewsViewModel$Companion;", "", "()V", "TAG", "", "pateint_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}