package com.github.movietracker.movielist

import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movietracker.R
import com.example.movietracker.databinding.ItemMovieBinding
import com.github.movietracker.model.Movie
import com.github.movietracker.extensions.loadImage

class MovieAdapter(
    private val listener: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.DataViewHolder>() {
    private var movies = listOf<Movie?>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        movies[position]?.let { holder.bind(it) }
        holder.itemView.setOnClickListener {
            movies[position]?.let { it1 -> listener(it1) }
        }
    }

    override fun getItemCount(): Int = movies.size

    fun bindMovies(newMovies: List<Movie?>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    class DataViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {

        fun bind(movie: Movie) {
            binding.apply {
                itemmoviePoster.loadImage(context, movie.posterPath)
                itemmovieTags.text = movie.getGenreNames()
                val like = if (movie.isFavorite) R.drawable.like_16dp else R.drawable.no_like_16dp
                val drawable: Drawable? = ContextCompat.getDrawable(context, like)
                itemmovieLike.setImageDrawable(drawable)
                itemmovieReviews.text = movie.voteCount.toString().plus(" REVIEWS")
                itemmovieStars.rating = movie.getRating().toFloat()
                itemmovieTitle.text = movie.title
                itemmovieAgelimit.text = movie.getAgeLimit(context)
                itemmovieDuration.text = movie.runtime.plus(" min")
            }
        }
    }

    class MovieDiffUtil(
        private val oldList: List<Movie?>,
        private val newList: List<Movie?>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem?.title == newItem?.title
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem == newItem
        }
    }
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context
