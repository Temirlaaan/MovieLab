package com.example.movielab

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movielab.ComingSoon.ComingSoonFragment
import com.example.movielab.Popular.PopularFragment

class PagerAdapter(
    lifecycle: Lifecycle,
    fragmentManager: FragmentManager
): FragmentStateAdapter(fragmentManager, lifecycle) {

    companion object{
        const val PAGE_COUNT = 2
    }

    override fun getItemCount():Int{
        return PAGE_COUNT
    }

    override fun createFragment(position: Int): Fragment{
        return when(position){
            0->ComingSoonFragment()
            else -> PopularFragment()
        }
    }
}