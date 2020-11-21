package com.example.myapplication

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.marginTop
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        }
        else {

            viewroot.systemUiVisibility = SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        }
        ViewCompat.setOnApplyWindowInsetsListener(toolbar_trans) { view, insets ->
            view.updateMarginTop(insets.systemWindowInsetTop) //marginTop(top = insets.systemWindowInsetTop)
            insets
        }
    }

    private fun View.updateMarginTop(value: Int){
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = value
        }
    }

}