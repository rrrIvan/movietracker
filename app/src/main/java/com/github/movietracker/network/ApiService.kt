package com.github.movietracker.network

import com.github.movietracker.model.ConfigurationResponse
import com.github.movietracker.model.GenreResponse
import com.github.movietracker.model.PopularMovieResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

class ApiService {

    companion object {
        private const val API_KEY = "66a85d0e7e93211ed8fa2a139b1b776f"
        private const val LANGUAGE = "en-US"
    }

    private var service: MovieApi
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }
    init {
        @Suppress("EXPERIMENTAL_API_USAGE")
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
        service = retrofit.create()
    }

    suspend fun getMoviesPopular(): PopularMovieResponse {
        return service.getMoviePopular(apiKey = API_KEY, language = LANGUAGE, page = 1)
    }

    suspend fun getConfiguration(): ConfigurationResponse {
        return service.getConfiguration(apiKey = API_KEY)
    }

    suspend fun getGenres(): GenreResponse {
        return service.getGenres(apiKey = API_KEY, language = LANGUAGE)
    }
}