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


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null)
        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.fragments_container, FragmentMoviesList.newInstance())
                addToBackStack(null)
//                add(R.id.fragments_container,FragmentMoviesDetails.newInstance())
//                addToBackStack(null)
                commit()
            }
//
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        }
            else {

            fragments_container.systemUiVisibility = SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

//        ViewCompat.requestApplyInsets(view)
//            ViewCompat.setOnApplyWindowInsetsListener(toolbar_trans2) { view, insets ->
//                view.updateMarginTop(insets.systemWindowInsetTop) //marginTop(top = insets.systemWindowInsetTop)
//                insets
////            }
//
//        }

    }

    }

    public fun View.updateMarginTop(value: Int){
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = value
        }

}