package com.example.sportnewstest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.sportnewstest.R
import com.example.sportnewstest.databinding.FragmentDetailBinding
import com.example.sportnewstest.viewModel.DetailViewModel


class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    lateinit var viewModel: DetailViewModel
    private val args: DetailFragmentArgs by lazy {
        DetailFragmentArgs.fromBundle(requireArguments())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setText()
    }

    private fun setText() {
        val item = args.News
        binding.tvNews.text = item.news
        binding.tvDetail.text = item.detail
        Glide
            .with(requireContext())
            .load(item.image)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(com.google.android.material.R.drawable.mtrl_ic_error)
            .centerCrop()
            .into(binding.imageView)

    }
}