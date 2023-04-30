package com.example.movielab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        bottomNav()
    }

    private fun setupView() {
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        viewPager.adapter = PagerAdapter(lifecycle, supportFragmentManager)

        TabLayoutMediator(
            tabLayout,
            viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when(position) {
                    0 -> tab.text = "Coming Soon"
                    1 -> tab.text = "Popular Movies"
                }
            }
        ).attach()
    }

    fun bottomNav(){
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_bar)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.moviesFragment -> {
                    // Handle home menu item click
                    true
                }
                R.id.genresFragment -> {
                    // Handle search menu item click
                    true
                }
                R.id.savesFragment -> {
                    // Handle notifications menu item click
                    true
                }
                else -> false
            }
        }
    }
}