package com.mtsarkov.firstapp

import TopSpacingItemDecoration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    private val filmsDataBase = listOf(
        Film("Prey", R.drawable.prey, "The origin story of the Predator in the world of the Comanche Nation 300 years ago. Naru, a skilled warrior, fights to protect her tribe against one of the first highly-evolved Predators to land on Earth."),
        Film("Bullet Train", R.drawable.bullet_train, "Five assassins aboard a fast moving bullet train find out their missions have something in common."),
        Film("Thirteen Lives", R.drawable.thirteen_lives, "A rescue mission is assembled in Thailand where a group of young boys and their soccer coach are trapped in a system of underground caves that are flooding."),
        Film("Purple Hearts", R.drawable.purple_hearts, "In spite of their many differences, Cassie, a struggling singer-songwriter, and Luke, a troubled Marine, agree to marry solely for military benefits. But when tragedy strikes, the line between real and pretend begins to blur."),
        Film("Nope", R.drawable.nope, "The residents of a lonely gulch in inland California bear witness to an uncanny and chilling discovery."),
        Film("The Gray Man", R.drawable.the_gray_man, "When the CIA's most skilled operative-whose true identity is known to none-accidentally uncovers dark agency secrets, a psychopathic former colleague puts a bounty on his head, setting off a global manhunt by international assassins."),
        Film("Elvis", R.drawable.elvis, "The life of American music icon Elvis Presley, from his childhood to becoming a rock and movie star in the 1950s while maintaining a complex relationship with his manager, Colonel Tom Parker."),
        Film("Day Shift", R.drawable.day_shift, "A hard-working, blue-collar dad who just wants to provide a good life for his quick-witted 8-year-old daughter. His mundane San Fernando Valley pool cleaning job is a front for his real source of income: hunting and killing vampires."),
        Film("Uncharted", R.drawable.uncharted, "Street-smart Nathan Drake is recruited by seasoned treasure hunter Victor \"Sully\" Sullivan to recover a fortune amassed by Ferdinand Magellan, and lost 500 years ago by the House of Moncada."),
        Film("Lightyear", R.drawable.lightyear, "While spending years attempting to return home, marooned Space Ranger Buzz Lightyear encounters an army of ruthless robots commanded by Zurg who are attempting to steal his fuel source.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(home_fragment_root, requireActivity(), 1)

        initSearch()
        initRecycler()
        filmsAdapter.addItems(filmsDataBase)
    }

    private fun initRecycler() {
        main_recycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }

    }

    private fun initSearch() {
        search_view.setOnClickListener {
            search_view.isIconified = false
        }
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }

                val result = filmsDataBase.filter {
                    it.title.lowercase(Locale.getDefault()).contains(newText.lowercase(Locale.getDefault()))
                }

                filmsAdapter.addItems(result)
                return true
            }
        })
    }
}