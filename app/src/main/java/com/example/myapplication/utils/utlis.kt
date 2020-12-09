package com.example.myapplication.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R

fun loadImage(context: Context,url:String, image: ImageView,
                     imageOption: RequestOptions = RequestOptions()
                         .placeholder(R.drawable.ic_movie_placeholder)
                         .fallback(R.drawable.ic_movie_placeholder)
                     ){

    Glide.with(context)
        .load(url)
        .apply(imageOption)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(image)
}