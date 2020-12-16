package com.github.movietracker.activites

import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.movietracker.R
import com.example.movietracker.databinding.ActivityMainBinding
import com.github.movietracker.fragments.FragmentMoviesList
import com.github.movietracker.extensions.Constants

class ActivityMain : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState ?: supportFragmentManager.beginTransaction()
            .apply {
                add(
                    R.id.fragments_container,
                    FragmentMoviesList.newInstance(),
                    Constants.TABLE_USER_ATTRIBUTE_EMPID
                )
                commit()
            }
    }

    fun updateStatusBarColor(@ColorRes color: Int) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, color)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
