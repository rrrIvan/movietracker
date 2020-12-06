package com.example.myapplication.activites

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.updateLayoutParams
import com.example.myapplication.R
import com.example.myapplication.fragments.FragmentMoviesList
import kotlinx.android.synthetic.main.activity_main.fragments_container
import timber.log.Timber
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var topMargin: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFullScreen()



        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .apply {
                    add(
                        R.id.fragments_container,
                        FragmentMoviesList.newInstance()
                    )
                    addToBackStack(null)
                    commit()
                }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.fragments.isEmpty()) exitProcess(0)
    }

    private fun setFullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {

            fragments_container.systemUiVisibility = SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        val idStatusBarHeight: Int = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (idStatusBarHeight > 0) {
            topMargin = resources.getDimensionPixelSize(idStatusBarHeight)
        }
    }

    override fun setSupportActionBar(toolbar: Toolbar?) {
        super.setSupportActionBar(toolbar)
        toolbar?.updateMarginTop(topMargin)
    }
}

public fun View.updateMarginTop(value: Int) {
    updateLayoutParams<ViewGroup.MarginLayoutParams> {
        topMargin = value
    }
}