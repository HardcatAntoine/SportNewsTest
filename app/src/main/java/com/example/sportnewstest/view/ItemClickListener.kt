package com.example.sportnewstest.view

import com.example.sportnewstest.data.News

interface ItemClickListener {
    fun onItemClick(position: Int, item: News)
}