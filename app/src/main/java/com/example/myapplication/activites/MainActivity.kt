package com.example.myapplication.activites

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.myapplication.ExampleApp
import com.example.myapplication.ExampleApp.Companion.instanceOfMovies
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

import com.example.myapplication.fragments.FragmentMoviesList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var view: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        view = binding.root
        setContentView(view)

        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .apply {
                    add(
                        R.id.fragments_container,
                        FragmentMoviesList.newInstance(),
                        "start_fragment"
                    )
                    commit()
                }
    }

    override fun setSupportActionBar(toolbar: Toolbar?) {
        super.setSupportActionBar(toolbar)
        // toolbar?.updateMarginTop(topMargin)
    }

    fun updateStatusBarColor(color: Int) {
        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, color)
    }
}
