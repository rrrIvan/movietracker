package com.github.movietracker

import android.app.Application
import com.example.movietracker.BuildConfig
import timber.log.Timber

class AppMovie : Application() {

    companion object {
        lateinit var instance: AppMovie
            private set
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        instance = this
    }
}
