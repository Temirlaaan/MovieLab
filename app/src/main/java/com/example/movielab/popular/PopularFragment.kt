package com.example.movielab.popular

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movielab.R
import com.example.movielab.popular.detail.PopularDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularFragment: Fragment(R.layout.fragment_popular) {

    private val viewModel by viewModel<PopularViewModel>()

    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        observeViewModel()
        viewModel.loadMovieList()
    }

    private fun setupView(view: View){
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun observeViewModel() = with(viewModel){

        basketDetailData.observe(viewLifecycleOwner){ popularMovieList ->
            recyclerView.adapter = PopularRecyclerAdapter(
                item = popularMovieList,
                onItemClickListener = { popular ->
                    val intent = Intent(activity, PopularDetailActivity::class.java)
                    intent.putExtra("ARG_DETAIL", popular)
                    startActivity(intent)
                }
            )
        }
    }
}


