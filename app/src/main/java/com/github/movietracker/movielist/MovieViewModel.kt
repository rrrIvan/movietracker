package com.github.movietracker.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.movietracker.convertor.GenreConverter
import com.github.movietracker.convertor.MovieConverter
import com.github.movietracker.model.Genre
import com.github.movietracker.model.Movie
import com.github.movietracker.network.ApiService
import kotlinx.coroutines.launch

class MovieViewModel() : ViewModel() {
    private val service = ApiService()
    private val _movieList: MutableLiveData<List<Movie?>> by lazy { MutableLiveData<List<Movie?>>() }
    val movieList: LiveData<List<Movie?>>
        get() = _movieList

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val configuration = service.getConfiguration()
            val response = service.getMoviesPopular()
            val posterSize = configuration.images?.posterSizes?.get(2)
            val moviePosterUrl = "${configuration.images?.secureBaseUrl}/$posterSize"
            val genres = getGenres()
            val movies = MovieConverter.moviesPopularResponseToMovieList(response)
            if (movies.isNotEmpty()) {
                for (movie in movies) {
                    movie.posterPath = "$moviePosterUrl/${movie.posterPath}"
                    for (genreId in movie.genreIds) {
                        val genre = genres[genreId]
                        genre?.let {
                            movie.genres?.add(genre)
                        }
                    }
                }
            }
            _movieList.value = movies
        }
    }

    private suspend fun getGenres(): HashMap<Int, Genre> {
        val response = service.getGenres()
        return GenreConverter.genresResponseToGenreList(response)
    }
}
