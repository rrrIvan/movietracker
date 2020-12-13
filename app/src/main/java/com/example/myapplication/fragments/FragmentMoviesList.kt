package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ExampleApp
import com.example.myapplication.R
import com.example.myapplication.activites.MainActivity
import com.example.myapplication.adapters.GridDividerItemDecoration
import com.example.myapplication.adapters.MovieAdapter
import com.example.myapplication.adapters.OnRecyclerItemClicked
import com.example.myapplication.data.Movie

class FragmentMoviesList : Fragment() {
    private var recycler: RecyclerView? = null
    private var orientation: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        orientation = resources.configuration.orientation
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        context?.setTheme(R.style.AppTheme2)
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.apply {
            updateStatusBarColor(R.color.colorPrimary)
            setSupportActionBar(view.findViewById(R.id.ListToolbar)).apply {

            }
        }
        val lManager = GridLayoutManager(context, (orientation ?: 1) * 2)
        recycler = view.findViewById<RecyclerView>(R.id.rv_films)
        recycler?.apply {
            layoutManager = lManager
            adapter = MovieAdapter(clickListener)
        }
        recycler?.addItemDecoration(GridDividerItemDecoration((orientation ?: 1) * 2, 30, true))
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    private fun updateData() {
        (recycler?.adapter as? MovieAdapter)?.apply {
            bindMovies(ExampleApp.instanceOfMovies)
        }
    }

    private fun doOnClick(movie: Movie) {
        activity?.apply {
            supportFragmentManager.beginTransaction()
                .apply {
                    replace(R.id.fragments_container, FragmentMoviesDetails.newInstance(movie))
                    addToBackStack(null)
                    commit()
                }
        }
    }

    private val clickListener = object : OnRecyclerItemClicked {
        override fun onClick(movie: Movie) {
            doOnClick(movie)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMoviesList()
    }
}
