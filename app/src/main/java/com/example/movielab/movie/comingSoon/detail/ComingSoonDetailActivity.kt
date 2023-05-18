package com.example.movielab.movie.comingSoon.detail

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.movielab.R
import com.example.movielab.movie.comingSoon.model.ComingSoon
import com.example.movielab.network.POSTER_BASE_URL

class ComingSoonDetailActivity: AppCompatActivity() {
    var soon: ComingSoon? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comingsoon_detail)
        soon = intent.getParcelableExtra<ComingSoon>("ARG_DETAIL_SOON") as ComingSoon
        setupView()
    }
    private fun setupView() {
        val titleView = findViewById<TextView>(R.id.title)
        val posterView = findViewById<AppCompatImageView>(R.id.poster)
        val voteAverageView = findViewById<TextView>(R.id.rating)
        val overview = findViewById<TextView>(R.id.description)

        titleView.text = "${soon?.title}"
        voteAverageView.text = "${soon?.rating}"
        overview.text = "${soon?.overview}"

        Glide
            .with(posterView)
            .load(POSTER_BASE_URL + soon?.posterURL)
            .centerCrop()
            .placeholder(R.drawable.poster_placeholder)
            .into(posterView)
    }
}