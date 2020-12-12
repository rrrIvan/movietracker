package com.example.myapplication.activites

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.R
import com.example.myapplication.data.Movie
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.fragments.FragmentMoviesDetails
import com.example.myapplication.fragments.FragmentMoviesList
import com.example.myapplication.utils.updateMarginTop

class MainActivity : AppCompatActivity() {
    // private var topMargin: Int = 0
    private lateinit var binding: ActivityMainBinding
    private lateinit var view: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        view = binding.root
        setContentView(view)
        // setFullScreen()

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
}
