package com.example.myapplication

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.updateLayoutParams
import kotlinx.android.synthetic.main.activity_main.fragments_container
import kotlinx.android.synthetic.main.activity_main.root_view

class MainActivity : AppCompatActivity() {

    private var topMargin: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {

            fragments_container.systemUiVisibility = SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        if (savedInstanceState == null)
            ViewCompat.setOnApplyWindowInsetsListener(root_view) { view, insets ->
                topMargin = insets.systemWindowInsetTop
                supportFragmentManager.beginTransaction()
                    .apply {
                        add(
                            R.id.fragments_container,
                            FragmentMoviesList.newInstance()
                        )
                        addToBackStack(null)
                        commit()
                    }
                insets
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