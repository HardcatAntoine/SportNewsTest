package com.example.sportnewstest.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.sportnewstest.R
import com.example.sportnewstest.data.News

class NewsHolder(itemView: View) : ViewHolder(itemView) {
    private val news = itemView.findViewById<TextView>(R.id.tvNews)
    private val date = itemView.findViewById<TextView>(R.id.tvDate)
    private val image = itemView.findViewById<ImageView>(R.id.image_news)

    fun bind(item: News) {
        Glide
            .with(itemView)
            .load(item.image)
            .placeholder(R.drawable.ic_launcher_background)
            .error(com.google.android.material.R.drawable.mtrl_ic_error)
            .centerCrop()
            .into(image)

        news.text = item.news
        date.text = item.date

    }
}