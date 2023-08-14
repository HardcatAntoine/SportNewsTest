package com.example.sportnewstest.api

import com.example.sportnewstest.data.News
import retrofit2.http.GET

interface ApiService {
    @GET("")
    suspend fun getNews(): List<News>
}