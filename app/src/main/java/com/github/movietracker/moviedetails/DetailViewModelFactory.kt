package com.github.movietracker.moviedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.movietracker.data.Movie

class DetailViewModelFactory(private val movie: Movie) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        DetailViewModel::class.java -> DetailViewModel(movie) as T
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    }
}
