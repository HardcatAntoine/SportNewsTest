package com.example.sportnewstest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportnewstest.data.News
import com.example.sportnewstest.data.dataNews
import com.example.sportnewstest.data.favoriteNews
import com.example.sportnewstest.databinding.FragmentNewsBinding
import com.example.sportnewstest.viewModel.NewsViewModel

class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    lateinit var viewModel: NewsViewModel
    private val itemClickListener = object : ItemClickListener {
        override fun onItemClick(position: Int, item: News) {
            val action: NavDirections =
                NewsFragmentDirections.actionNewsFragmentToDetailFragment(item)
            findNavController().navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val favoriteAdapter = NewsAdapter(favoriteNews)
        val adapter = NewsAdapter(dataNews)
        binding.rvFavoriteNews.adapter =favoriteAdapter
        binding.rvFavoriteNews.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        favoriteAdapter.setOnItemClickListener(itemClickListener)
        binding.rvNewsList.adapter = adapter
        binding.rvNewsList.layoutManager = LinearLayoutManager(requireContext())
        adapter.setOnItemClickListener(itemClickListener)
    }
}