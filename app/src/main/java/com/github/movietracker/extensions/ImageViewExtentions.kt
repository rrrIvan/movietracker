package com.github.movietracker.extensions

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.movietracker.R

fun ImageView.loadImage(
    context: Context,
    url: String,
    imageOption: RequestOptions = RequestOptions()
        .placeholder(R.drawable.ic_baseline_local_movies_24)
        .fallback(R.drawable.ic_baseline_local_movies_24)
) {

    Glide.with(context)
        .load(url)
        .apply(imageOption)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}
