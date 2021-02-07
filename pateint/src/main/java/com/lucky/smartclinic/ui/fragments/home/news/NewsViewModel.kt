package com.lucky.smartclinic.ui.fragments.home.news


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucky.smartclinic.model.News
import com.lucky.smartclinic.repository.SmartClinicRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import okhttp3.ResponseBody


class NewsViewModel(private val repository: SmartClinicRepository) : ViewModel() {

    private val _news = MutableStateFlow<NewFragmentState>(NewFragmentState.Empty)
    val news: StateFlow<NewFragmentState> = _news

    init {
        viewModelScope.launch {
               onRefreshed()
        }
    }

    fun  onRefreshed()
    {
        viewModelScope.launch {

            repository.getNews().buffer().catch { error ->
                when(error)
                {
                    is Exception ->   _news.value = NewFragmentState.LocalError(error)
                    else -> Unit
                }

            }.collect { response ->
                if (response.isSuccessful) {
                    _news.value = NewFragmentState.Success(response.body()!!)
                } else {
                    _news.value = NewFragmentState.Error(response.errorBody()!!)
                }
            }
        }
    }



    sealed class NewFragmentState {
        object Empty : NewFragmentState()
        class Error(val error: ResponseBody) : NewFragmentState()
        class LocalError(val error: Exception) : NewFragmentState()
        class Success(val news: News) : NewFragmentState()
    }
    companion object{
        private const val TAG = "NewsViewModel"
    }

}