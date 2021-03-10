// package com.github.movietracker.movielist
//
// import android.content.Context
// import androidx.lifecycle.ViewModel
// import androidx.lifecycle.ViewModelProvider
//
// class ListViewModelFactory(private val applicationContext: Context) : ViewModelProvider.Factory {
//
//     override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
//         MovieViewModel::class.java -> MovieViewModel(applicationContext) as T
//         else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
//     }
// }
