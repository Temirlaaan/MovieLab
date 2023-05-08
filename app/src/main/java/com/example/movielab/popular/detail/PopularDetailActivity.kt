package com.example.movielab.popular.detail

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.example.movielab.R
import com.example.movielab.popular.model.Popular

class PopularDetailActivity: AppCompatActivity() {

    var popular: Popular? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_detail)

        popular = intent.getParcelableExtra<Popular>("ARG_CHAT") as Popular

    }

    private fun setupView() {

    }

    override fun onStop() {
        super.onStop()
    }

}