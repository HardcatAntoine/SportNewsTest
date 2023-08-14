package com.example.sportnewstest.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportnewstest.R
import com.example.sportnewstest.data.News

class NewsAdapter(private val list: List<News>) : RecyclerView.Adapter<NewsHolder>() {
    private var clickListener: ItemClickListener? = null
    fun setOnItemClickListener(clickListener: ItemClickListener) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val holder = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsHolder(holder)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            clickListener?.onItemClick(position, item)
        }
    }
}