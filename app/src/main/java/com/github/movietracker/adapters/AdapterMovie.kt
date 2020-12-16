package com.github.movietracker.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.movietracker.R
import com.github.movietracker.data.Movie
import com.github.movietracker.utils.loadImage

class MovieAdapter(
    private val clickListener: OnRecyclerItemClicked
) : RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {

    private var movies = listOf<Movie>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return DataViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        (holder as DataViewHolder).onBind(movies[position])
        holder.itemView.setOnClickListener {
            clickListener.onClick(movies[position])
        }
    }

    override fun getItemCount(): Int = movies.size

    fun bindMovies(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    abstract class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    private class DataViewHolder(itemView: View) : MoviesViewHolder(itemView) {

        private val poster: ImageView = itemView.findViewById(R.id.ItemMoviePoster)
        private val rating: RatingBar = itemView.findViewById(R.id.ItemMovieStars)
        private val isLike: ImageView = itemView.findViewById(R.id.ItemMovieLike)
        private val title: TextView = itemView.findViewById(R.id.ItemMovieTitle)
        private val ageLimit: TextView = itemView.findViewById(R.id.ItemMovieAgeLimit)
        private val duration: TextView = itemView.findViewById(R.id.ItemMovieDuration)
        private val tags: TextView = itemView.findViewById(R.id.ItemMovieTags)
        private val reviews: TextView = itemView.findViewById(R.id.ItemMovieReviews)

        fun onBind(movie: Movie) {
            loadImage(context, movie.poster, poster)
            tags.text = movie.genres.joinToString(separator = ", ")
            val like = if (movie.is_like) R.drawable.like_16dp else R.drawable.no_like_16dp
            val drawable: Drawable? = ContextCompat.getDrawable(context, like)
            isLike.setImageDrawable(drawable)
            reviews.text = movie.votes.toString().plus(" REVIEWS")
            rating.rating = movie.ratings / 2
            title.text = movie.title
            ageLimit.text = movie.age.toString().plus("+")
            duration.text = movie.runtime.toString().plus(" min")
        }
    }
}

interface OnRecyclerItemClicked {
    fun onClick(movie: Movie)
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context
