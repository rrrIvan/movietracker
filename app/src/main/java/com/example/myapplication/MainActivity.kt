package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val toolbar = findViewById(R.id.my_toolbar_1) as? Toolbar
////        toolbar?.background?.alpha=0
//        setSupportActionBar(toolbar)
//////
//        supportActionBar?.apply {
//            setDisplayShowHomeEnabled(true)
//        }
    }
}