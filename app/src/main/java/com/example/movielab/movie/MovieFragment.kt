package com.example.movielab.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.movielab.PagerAdapter
import com.example.movielab.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MovieFragment: Fragment(R.layout.fragment_movies) {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
    }
    private fun setupView(view: View) {

        viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabLayout)

        viewPager.adapter = PagerAdapter(lifecycle, childFragmentManager)

        TabLayoutMediator(
            tabLayout,
            viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when(position){
                    0 -> tab.text = "Coming Soon"
                    1 -> tab.text = "Popular"
                }
            }
        ).attach()
    }
}



