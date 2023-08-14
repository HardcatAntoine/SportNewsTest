package com.example.sportnewstest.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val news: String,
    val detail: String,
    val date: String,
    val image: Int
) : Parcelable