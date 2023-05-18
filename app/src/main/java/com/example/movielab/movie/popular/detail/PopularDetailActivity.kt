package com.example.movielab.movie.popular.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.movielab.R
import com.example.movielab.network.POSTER_BASE_URL
import com.example.movielab.movie.popular.model.Popular

class PopularDetailActivity: AppCompatActivity() {
    var popular: Popular? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_detail)
        popular = intent.getParcelableExtra<Popular>("ARG_DETAIL") as Popular
        setupView()
    }
    private fun setupView() {
        val titleView = findViewById<TextView>(R.id.title)
        val posterView = findViewById<AppCompatImageView>(R.id.poster)
        val voteAverageView = findViewById<TextView>(R.id.rating)
        val overview = findViewById<TextView>(R.id.description)

        titleView.text = "${popular?.title}"
        voteAverageView.text = "${popular?.rating}"
        overview.text = "${popular?.overview}"

        Glide
            .with(posterView)
            .load(POSTER_BASE_URL + popular?.posterURL)
            .centerCrop()
            .placeholder(R.drawable.poster_placeholder)
            .into(posterView)
    }
}