package com.example.sportnewstest.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportnewstest.api.ApiProvider
import com.example.sportnewstest.data.News
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val _news = MutableLiveData<List<News>>()
    val news: LiveData<List<News>>
        get() = _news
    fun getNewsList(){
        viewModelScope.launch {
            val newsResponse = ApiProvider.apiService.getNews()
            _news.value = newsResponse
        }
    }
}