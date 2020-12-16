package com.github.movietracker.repositories

import com.example.movietracker.local.getRepository
import com.github.movietracker.AppMovie
import com.github.movietracker.data.Movie

object MoviesRepository{
    fun getMovies() : List<Movie> {
        return getRepository(AppMovie.instance)
    }
}