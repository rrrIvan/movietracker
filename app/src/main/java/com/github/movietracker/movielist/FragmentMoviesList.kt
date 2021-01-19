package com.github.movietracker.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movietracker.R
import com.github.movietracker.activites.ActivityMain
import com.github.movietracker.data.Movie
import com.github.movietracker.repositories.MoviesRepository
import com.github.movietracker.moviedetails.FragmentMoviesDetails

class FragmentMoviesList : Fragment() {
    private var recycler: RecyclerView? = null
    private var orientation: Int? = null
    private lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        orientation = resources.configuration.orientation
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireContext().setTheme(R.style.AppTheme)
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
        return view
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
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    private fun updateData() {
        movieAdapter.apply {
            bindMovies(MoviesRepository.getMovies())
            val diffCallback = MovieAdapter.MovieDiffUtil(MoviesRepository.getMovies(), MoviesRepository.getMovies())
            val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(diffCallback)
            diffResult.dispatchUpdatesTo(this)
        }
    }

    private fun doOnClick(movie: Movie) {
        (activity as? ActivityMain)?.apply {
            supportFragmentManager.beginTransaction()
                .apply {
                    replace(R.id.fragments_container, FragmentMoviesDetails.newInstance(movie))
                    addToBackStack(null)
                    commit()
                }
        }
    }

    private val listener: (Movie) -> Unit = { doOnClick(it) }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMoviesList()
    }
}
