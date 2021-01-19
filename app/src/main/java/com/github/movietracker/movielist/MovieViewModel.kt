package com.github.movietracker.movielist

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietracker.local.loadMovies
import com.github.movietracker.AppMovie
import com.github.movietracker.data.Movie
import kotlinx.coroutines.launch

class MovieViewModel : AndroidViewModel(AppMovie.instance) {
    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _movieList.value = loadMovies(this@MovieViewModel.getApplication())
        }
    }

}