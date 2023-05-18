package com.example.movielab.movie.comingSoon

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movielab.R
import com.example.movielab.movie.comingSoon.detail.ComingSoonDetailActivity
import com.example.movielab.movie.popular.PopularRecyclerAdapter
import com.example.movielab.movie.popular.PopularViewModel
import com.example.movielab.movie.popular.detail.PopularDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComingSoonFragment: Fragment(R.layout.fragment_coming_soon) {

    private val viewModel by viewModel<ComingSoonViewModel>()

    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        observeViewModel()
        viewModel.loadSoonList()
    }

    private fun setupView(view: View){
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun observeViewModel() = with(viewModel){

        basketDetailData.observe(viewLifecycleOwner){ popularMovieList ->
            recyclerView.adapter = ComingSoonRecyclerAdapter(
                item = popularMovieList,
                onItemClickListener = { popular ->
                    val intent = Intent(activity, ComingSoonDetailActivity::class.java)
                    intent.putExtra("ARG_DETAIL_SOON", popular)
                    startActivity(intent)
                }
            )
        }
    }
}


