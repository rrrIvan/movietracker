package com.example.myapplication.activites

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.fragments.FragmentMoviesList
import com.example.myapplication.utils.updateMarginTop

class MainActivity : AppCompatActivity() {
    private var topMargin: Int = 0
    private lateinit var binding: ActivityMainBinding
    private lateinit var view: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        view = binding.root
        setContentView(view)
        setFullScreen()

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

    private fun setFullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            view.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        val idStatusBarHeight: Int =
            resources.getIdentifier("status_bar_height", "dimen", "android")
        if (idStatusBarHeight > 0) {
            topMargin = resources.getDimensionPixelSize(idStatusBarHeight)
        }
    }

    override fun setSupportActionBar(toolbar: Toolbar?) {
        super.setSupportActionBar(toolbar)
        toolbar?.updateMarginTop(topMargin)
    }
}