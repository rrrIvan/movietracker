package com.example.myapplication

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.updateLayoutParams
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.fragment_movie_list2.*


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movie_list2)

//
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        }
            else {

            viewroot1.systemUiVisibility = SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        ViewCompat.setOnApplyWindowInsetsListener(toolbar_trans) { view, insets ->
            view.updateMarginTop(insets.systemWindowInsetTop) //marginTop(top = insets.systemWindowInsetTop)
            insets
        }


    }

    }

    private fun View.updateMarginTop(value: Int){
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = value
        }

}