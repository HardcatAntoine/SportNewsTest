package com.example.sportnewstest.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportnewstest.data.News
import com.example.sportnewstest.view.DetailFragmentArgs
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val _detail = MutableLiveData<News>()
    val detail: LiveData<News>
        get() = _detail

    fun getDetailNews(args: DetailFragmentArgs) {
        viewModelScope.launch {
            _detail.value = args.News

        }
    }
}