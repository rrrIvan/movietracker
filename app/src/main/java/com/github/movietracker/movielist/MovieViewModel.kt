package com.github.movietracker.movielist

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietracker.local.loadMovies
import com.github.movietracker.data.Movie
import kotlinx.coroutines.launch

class MovieViewModel(applicationContext: Context) : ViewModel() {
    private val _context = applicationContext

    private val _movieList: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _movieList.value = loadMovies(this@MovieViewModel._context)
        }
    }
}
