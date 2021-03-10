package com.github.movietracker.network

import com.github.movietracker.model.ConfigurationResponse
import com.github.movietracker.model.GenreResponse
import com.github.movietracker.model.PopularMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getMoviePopular(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): PopularMovieResponse

    @GET("configuration")
    suspend fun getConfiguration(@Query("api_key") apiKey: String): ConfigurationResponse

    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): GenreResponse
}
