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
import com.example.movietracker.databinding.FragmentMoviesDetailsBinding
import com.example.movietracker.databinding.FragmentMoviesListBinding
import com.example.movietracker.databinding.ItemMovieBinding
import com.github.movietracker.data.Movie
import com.github.movietracker.extensions.loadImage

class MovieAdapter(
    private val listener: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.DataViewHolder>() {
    private lateinit var _binding: ItemMovieBinding
    private var movies = listOf<Movie>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        _binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return DataViewHolder(_binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(movies[position])
        holder.itemView.setOnClickListener {
            listener(movies[position])
        }
    }

    override fun getItemCount(): Int = movies.size

    fun bindMovies(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    public class DataViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.apply {
                loadImage(context, movie.poster, ItemMoviePoster)
                ItemMovieTags.text = movie.genres.joinToString(separator = ", ") { it.name }
                val like = if (movie.like) R.drawable.like_16dp else R.drawable.no_like_16dp
                val drawable: Drawable? = ContextCompat.getDrawable(context, like)
                ItemMovieLike.setImageDrawable(drawable)
                ItemMovieReviews.text = movie.votes.toString().plus(" REVIEWS")
                ItemMovieStars.rating = movie.rating / 2
                ItemMovieTitle.text = movie.title
                ItemMovieAgeLimit.text = movie.age.toString().plus("+")
                ItemMovieDuration.text = movie.runtime.toString().plus(" min")

            }
        }
    }
}

// interface OnRecyclerItemClicked {
//     fun onClick(movie: Movie)
// }

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context
