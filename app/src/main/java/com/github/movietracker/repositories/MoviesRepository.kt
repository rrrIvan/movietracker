package com.github.movietracker.repositories

import com.example.movietracker.local.loadMovies
import com.github.movietracker.AppMovie
import com.github.movietracker.data.Movie

object MoviesRepository {
    suspend fun getMovies(): List<Movie> {
        return loadMovies(AppMovie.instance)
    }
}
