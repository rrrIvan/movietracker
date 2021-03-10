package com.github.movietracker.convertor

import com.github.movietracker.model.Genre
import com.github.movietracker.model.GenreResponse

object GenreConverter {

    fun genresResponseToGenreList(genreResponse: GenreResponse): HashMap<Int, Genre> {
        val genres = hashMapOf<Int, Genre>()
        genreResponse.genres?.let { genreItemsResponse ->
            for (item in genreItemsResponse) {
                item.let {
                    val id = item.id
                    val genre = Genre(
                        id = id,
                        name = item.name
                    )
                    genres[id] = genre
                }
            }
        }
        return genres
    }
}