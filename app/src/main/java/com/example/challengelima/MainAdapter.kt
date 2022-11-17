package com.example.challengelima

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.challengelima.model.Movie

class MainAdapter(
    private val listMovie: List<Movie?>?,
    var context: Context?,
    private var onClick: ((Int)->Unit)? = null,
): RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val movieTitle = itemView.findViewById<TextView>(R.id.tvMoviewTitle)
        val movieDate = itemView.findViewById<TextView>(R.id.tvMovieDate)
        val moviePoster = itemView.findViewById<ImageView>(R.id.imgPoster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = listMovie?.get(position)
        holder.movieTitle.text = if (movie?.title != null) movie.title else movie?.name
        holder.movieDate.text = String.format("%.2f", movie?.vote_average)
        context?.let {
            Glide.with(it)
                .load("https://image.tmdb.org/t/p/w500${movie?.poster_path}")
                .into(holder.moviePoster)
        }
        holder.moviePoster.setOnClickListener() {
            if (movie != null) {
                onClick?.invoke(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (listMovie?.size != null) listMovie.size else 0
    }


}