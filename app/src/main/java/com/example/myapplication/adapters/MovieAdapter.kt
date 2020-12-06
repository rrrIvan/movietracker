package com.example.myapplication.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.local.model.Actor
import com.example.myapplication.local.model.Movie
import com.google.android.material.imageview.ShapeableImageView

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {
    private val imageOption = RequestOptions()
        .placeholder(R.drawable.ic_movie_placeholder)
        .fallback(R.drawable.ic_movie_placeholder)

    private var movies = listOf<Movie>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return DataViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        (holder as DataViewHolder).onBind(imageOption, movies[position])
    }

    override fun getItemCount(): Int = movies.size

    fun bindMovies(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    abstract class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    private class DataViewHolder(itemView: View) : MoviesViewHolder(itemView) {

        private val poster: ImageView = itemView.findViewById(R.id.ListsPoster)
        private val rating: ImageView = itemView.findViewById(R.id.ListsStars)
        private val isLike: ImageView = itemView.findViewById(R.id.imageViewLike)
        private val title: TextView = itemView.findViewById(R.id.ListsTitle)
        private val ageLimit: TextView = itemView.findViewById(R.id.ListsAgeLimit)
        private val duration: TextView = itemView.findViewById(R.id.ListsDuration)
        private val tags: TextView = itemView.findViewById(R.id.ListsTags)


        fun onBind(options: RequestOptions, movie: Movie) {
            var j:Int = 0
//            for (i in 1..100000000) {
//                j ++
//
//            }
            Glide.with(context)
                .load(movie.poster)
                .apply(options)
                .into(poster)
            val drawable: Drawable? = if (movie.isLiked) {
                ContextCompat.getDrawable(context, R.drawable.like)
            } else {
                ContextCompat.getDrawable(context, R.drawable.no_like)
            }
            tags.text = movie.tags.joinToString(separator = ", ")
            isLike.setImageDrawable(drawable)

            rating.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.star_icon))
            title.text = movie.title
            ageLimit.text = movie.ageLimit.toString()
            duration.text = movie.duration.toString().plus(" min")
        }
    }
}



private val RecyclerView.ViewHolder.context
    get() = this.itemView.context