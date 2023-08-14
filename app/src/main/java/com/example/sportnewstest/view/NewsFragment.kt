package com.example.sportnewstest.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
                    R.drawable.news_1
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
                ),
                News(
                    "Neymar set for Saudi's Al Hilal after PSG agree deal",
                    "Aug 14 (Reuters) - Brazil forward Neymar is headed for Saudi Arabia after Pro League side Al Hilal agreed a two-year deal with Paris St Germain, Saudi state media reported on Monday.\n" +
                            "\n" +
                            "There was no immediate comment from the Ligue 1 champions, owned by Qatar Sports Investments, but French newspaper L'Equipe said the deal could net 31-year-old Neymar 160 million euros (\$175 million).\n" +
                            "\n" +
                            "The transfer fee was reported to be about 90 million euros plus add-ons and subject to completing a medical.",
                    "August 14, 2023",
                    R.drawable.news_4
                ),
                News(
                    "Real sign goalkeeper Arrizabalaga on loan from Chelsea",
                    "MADRID, Aug 14 (Reuters) - Real Madrid and Chelsea have reached an agreement for goalkeeper Kepa Arrizabalaga's season-long loan to the Spanish club, the clubs announced on Monday.\n" +
                            "\n" +
                            "The 28-year-old Arrizabalaga will arrive as a temporary replacement for Thibaut Courtois, who will be sidelined for several months after suffering a torn anterior cruciate ligament (ACL) in his left knee during a training session last Thursday.\n" +
                            "\n" +
                            "Arrizabalaga joined Chelsea from Athletic Bilbao in 2018 for a record 80 million euros fee for a goalkeeper but fell out of favour in the London club, who signed goalkeeper Robert Sanchez from Brighton & Hove Albion this summer.",
                    "August 14, 2023",
                    R.drawable.news_5
                ),
                News(
                    "Maguire must fight for place or leave Man Utd - Ten Hag",
                    "Aug 14 (Reuters) - Harry Maguire should leave Manchester United if he is not confident enough to fight for his place, manager Erik ten Hag said, amid reports that the defender is on the verge of completing a transfer to West Ham United.\n" +
                            "\n" +
                            "Ten Hag stripped Maguire of the captaincy last month after the 30-year-old made only eight Premier League starts last season, with Raphael Varane, Lisandro Martinez and Victor Lindelof preferred in central defence.",
                    "August 14, 2023",
                    R.drawable.news_6
                ),
                News(
                    "Celtics and Brown agree to richest deal in NBA history, reports",
                    "July 25 (Reuters) - Jaylen Brown has agreed to a five-year \$304 million supermax contract extension with the Boston Celtics that will make the forward the highest paid player in the NBA, according to multiple media reports on Tuesday.\n" +
                            "\n" +
                            "The third overall pick in the 2016 draft Brown averaged a career-high 26.6 points, 6.9 rebounds and 3.5 assists a game last season helping Boston reach the Eastern Conference finals.\n" +
                            "\n" +
                            "A twice NBA All-Star Brown will earn \$28.5 million next season before his extension begins in 2024 averaging \$60.8 million a year.",
                    "July 25, 2023",
                    R.drawable.news_7
                ),
                News(
                    "Paris to host Nets-Cavaliers game next year",
                    "July 19 (Reuters) - The Brooklyn Nets will face the Cleveland Cavaliers at Paris's Accor Arena on Jan. 11, 2024 for the third regular-season NBA game in the French capital, the NBA announced on Wednesday.\n" +
                            "\n" +
                            "The league and France have long been intertwined, with more players coming from the European country than anywhere else outside North America, including this year's number one overall draft pick Victor Wembanyama of the San Antonio Spurs.",
                    "July 20, 2023",
                    R.drawable.news_8
                ),
                News(
                    "LeBron James announces he will return for 21st season",
                    "July 13 - LeBron James acknowledged on Wednesday night that a few months ago he was questioning to himself his ability to keep performing \"without cheating the game\" and to still \"give everything to the game.\"\n" +
                            "\n" +
                            "While accepting an award at the ESPYs in Los Angeles, James announced his decision to play for a 21st season.\n" +
                            "\n" +
                            "\"The day I can't give everything on the floor is the day I'll be done. Lucky for you guys, that day is not today,\" James said on Wednesday.",
                    "July 13, 2023",
                    R.drawable.news_9
                ),
                News(
                    "Jerebko seeking answers after Swedish ban for joining CSKA Moscow",
                    "STOCKHOLM, July 3 (Reuters) - Swedish former NBA player Jonas Jerebko is still looking for answers about his future over a year after being suspended by his country's basketball association following his decision to join CSKA Moscow in the wake of Russia's invasion of Ukraine.\n" +
                            "\n" +
                            "Jerebko regrets his decision to join a club in Russia, which calls its actions in Ukraine a \"special military operation\", and said in hindsight it was a mistake but so far he has been met by silence from the Swedish Basketball Association (SBL).",
                    "July 3, 2023",
                    R.drawable.news_10
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