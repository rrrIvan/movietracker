package com.github.movietracker.movielist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movietracker.R
import com.github.movietracker.AppMovie
import com.github.movietracker.activites.ActivityMain
import com.github.movietracker.model.Movie
// import com.github.movietracker.moviedetails.FragmentMoviesDetails

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {
    private var recycler: RecyclerView? = null
    private var orientation: Int? = null
    private lateinit var movieAdapter: MovieAdapter
    private val viewModel: MovieViewModel  = MovieViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        orientation = resources.configuration.orientation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? ActivityMain)?.apply {
            updateStatusBarColor(R.color.color_primary)
            setSupportActionBar(view.findViewById(R.id.movielist_toolbar)).apply {
            }
        }
        recycler = view.findViewById<RecyclerView>(R.id.movielist_movies)
        recycler?.apply {
            layoutManager = GridLayoutManager(context, (orientation ?: 1) * 2)
            movieAdapter = MovieAdapter(listener)
            adapter = movieAdapter
            addItemDecoration(ItemDecorationGrid((orientation ?: 1) * 2, 30, true))
        }
        viewModel.movieList.observe(this.viewLifecycleOwner, ::updateData)
    }

    private fun updateData(list: List<Movie?>) {
        movieAdapter.apply {
            bindMovies(list)
            val diffCallback = MovieAdapter.MovieDiffUtil(list, list)
            val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(diffCallback)
            diffResult.dispatchUpdatesTo(this)
        }
    }

    private fun doOnClick(movie: Movie) {
        // (activity as? ActivityMain)?.apply {
        //     supportFragmentManager.beginTransaction()
        //         .apply {
        //             replace(R.id.fragments_container, FragmentMoviesDetails.newInstance(movie))
        //             addToBackStack(null)
        //             commit()
        //         }
        // }
    }

    private val listener: (Movie) -> Unit = { doOnClick(it) }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMoviesList()
    }
}
