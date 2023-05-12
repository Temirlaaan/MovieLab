package com.example.movielab.popular

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielab.R
import com.example.movielab.network.POSTER_BASE_URL
import com.example.movielab.popular.detail.PopularDetailActivity
import com.example.movielab.popular.model.Popular

class PopularRecyclerAdapter(
    private val item: List<Popular>,
    private val onItemClickListener: (Popular) -> Unit
) : RecyclerView.Adapter<PopularRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_popular, parent, false)
        context = parent.context
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var titleTextView: TextView
        lateinit var releaseDateView: TextView
        lateinit var rating: TextView
        lateinit var posterView: AppCompatImageView
        lateinit var itemViewGroup: RelativeLayout

        fun bind(item: Popular) {
            titleTextView = itemView.findViewById(R.id.movie_title)
            releaseDateView = itemView.findViewById(R.id.movie_date)
            rating = itemView.findViewById(R.id.movie_rating)
            itemViewGroup = itemView.findViewById(R.id.itemViewGroup)
            posterView = itemView.findViewById(R.id.movie_poster)

            titleTextView.text = item.title
            releaseDateView.text = item.releaseDate
            rating.text = item.rating.toString()

            Glide
                .with(itemView)
                .load(POSTER_BASE_URL + item.posterURL)
                .centerCrop()
                .placeholder(R.drawable.poster_placeholder)
                .into(posterView)

            itemViewGroup.setOnClickListener {
                onItemClickListener(item)
            }
        }
    }
}
