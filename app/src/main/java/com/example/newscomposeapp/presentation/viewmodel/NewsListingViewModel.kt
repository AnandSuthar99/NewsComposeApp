package com.example.newscomposeapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newscomposeapp.data.model.Article
import com.example.newscomposeapp.domain.usecase.FetchNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListingViewModel @Inject constructor(private val fetchNewsUseCase: FetchNewsUseCase) :
    ViewModel() {
    private val _newsListLiveData = MutableLiveData<List<Article>>()
    val newsListLiveData: LiveData<List<Article>> = _newsListLiveData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchNews() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = fetchNewsUseCase.execute()
                _newsListLiveData.value = result
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}
