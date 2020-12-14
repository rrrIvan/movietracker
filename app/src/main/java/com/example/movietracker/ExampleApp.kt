package com.example.movietracker

import android.app.Application
import com.example.movietracker.data.Movie
import com.example.movietracker.local.getRepository
import timber.log.Timber

class ExampleApp : Application() {
    companion object {
        lateinit var instanceOfMovies: List<Movie>
            private set
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        instanceOfMovies = getRepository(this)
    }
}
