package com.example.myapplication.utils

import android.content.Context
import android.os.Build
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.data.Movie
import com.example.myapplication.local.getRepository
import kotlinx.android.synthetic.main.activity_main.*

fun loadImage(context: Context,url:String, image: ImageView,
                     imageOption: RequestOptions = RequestOptions()
                         .placeholder(R.drawable.ic_baseline_local_movies_24)
                         .fallback(R.drawable.ic_baseline_local_movies_24)
                     ){

    Glide.with(context)
        .load(url)
        .apply(imageOption)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(image)
}






