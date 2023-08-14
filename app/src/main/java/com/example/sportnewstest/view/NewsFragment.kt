package com.example.sportnewstest.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportnewstest.R
import com.example.sportnewstest.data.News
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
        val adapter = NewsAdapter(
            listOf(
                News(
                    "Medvedev beats Rublev in all-Russian final",
                    "Russian tennis star Daniil Medvedev continued his resurgent form with victory in the final of the ATP tour event in Dubai, where he defeated compatriot Andrey Rublev in straight sets on Saturday.\n" +
                            "\n" +
                            "Medvedev triumphed 6-2 6-2 over world number six Rublev, who was defending champion at the tournament.\n" +
                            "\n" +
                            "Medvedev, 27, had overcome world number one Novak Djokovic at the semifinal stage in Dubai, ending the Serb’s 20-match winning streak.\n" +
                            "\n" +
                            "The title in Dubai was an 18th at ATP tour level for Medvedev, who extended his unbeaten run to 14 matches. The Moscow-born star has won the last three tournaments he has entered as he aims to climb back up the ATP rankings, having enjoyed 16 weeks as world number one in 2022.",
                    "Mar 4, 2023",
                    R.drawable.news1
                ),
                News(
                    "Russian star dethrones UFC pound-for-pound king",
                    "Russian champion Islam Makhachev defended his UFC lightweight title early on Sunday in an intense, five-round battle against hometown favorite Alex Volkanovski in Perth, Australia in the UFC 284 headliner.\n" +
                            "\n" +
                            "Makhachev, the fearsome Dagestani grappler, entered the cage as the reigning 155lb champion, but faced a stern challenge from the Australian, who was moving up from the featherweight (145lb) division he has dominated in a bid to become the UFC’s latest two-division titleholder.\n" +
                            "\n" +
                            "But after a back-and-forth contest which saw both men tested on their feet and on the ground, it was Makhachev’s persistent aggression and suffocating grappling which proved enough to earn a unanimous decision victory on the judges’ scorecards.",
                    "Feb 12, 2023",
                    R.drawable.news_2
                ),
                News(
                    "Rybakina takes aim at WTA over Canadian Open scheduling",
                    "Aug 14 (Reuters) - Elena Rybakina said she felt \"destroyed\" by the Canadian Open schedule and took aim at the WTA's \"weak\" leadership after the world number four's quarter-final ended at 3 a.m. on Saturday and her semi-final was postponed to Sunday because of rain.\n" +
                            "\n" +
                            "Rybakina beat Daria Kasatkina in a marathon last-eight clash lasting three hours and 27 minutes before rain forced the Kazakh to wait until the final day of the tournament to meet Liudmila Samsonova in the next round.",
                    "August 14, 2023",
                    R.drawable.news_3
                )

            )
        )
        binding.rvFavoriteNews.adapter = adapter
        binding.rvFavoriteNews.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvNewsList.adapter = adapter
        binding.rvNewsList.layoutManager = LinearLayoutManager(requireContext())
        adapter.setOnItemClickListener(itemClickListener)
    }
}