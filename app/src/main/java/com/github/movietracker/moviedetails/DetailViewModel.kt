package com.github.movietracker.moviedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.movietracker.model.Movie

class DetailViewModel(movie: Movie) : ViewModel() {
    private val _movie = movie

    private val _movie1: MutableLiveData<Movie> = MutableLiveData<Movie>()
    val movie: LiveData<Movie>
        get() = _movie1

    init {
        _movie1.value = _movie
    }
}
