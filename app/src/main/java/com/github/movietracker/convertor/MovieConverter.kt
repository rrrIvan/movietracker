package com.github.movietracker.convertor

import com.github.movietracker.model.Movie
import com.github.movietracker.model.PopularMovieResponse

object MovieConverter {

    fun moviesPopularResponseToMovieList(moviesPopularResponse: PopularMovieResponse): List<Movie> {
        val movies = mutableListOf<Movie>()
        moviesPopularResponse.movies?.let { moviesResponse ->
            for (movieResponse in moviesResponse) {
                movieResponse.let {
                    val movie = Movie(
                        popularity = movieResponse.popularity,
                        voteCount = movieResponse.voteCount,
                        video = movieResponse.video,
                        posterPath = movieResponse.posterPath,
                        id = movieResponse.id,
                        adult = movieResponse.adult,
                        backdropPath = movieResponse.backdropPath,
                        originalLanguage = movieResponse.originalLanguage,
                        originalTitle = movieResponse.originalTitle,
                        genreIds = movieResponse.genreIds,
                        title = movieResponse.title,
                        // actorIds = movieResponse.actorIds,
                        runtime = "128",
                        voteAverage = movieResponse.voteAverage,
                        overview = movieResponse.overview,
                        releaseDate = movieResponse.releaseDate
                    )
                    movies.add(movie)
                }
            }
        }

        return movies
    }
}