package com.example.myapplication.utils

import android.content.Context
import android.content.res.Resources
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.updateLayoutParams
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R

fun loadImage(
    context: Context,
    url: String,
    image: ImageView,
    imageOption: RequestOptions = RequestOptions()
        .placeholder(R.drawable.ic_baseline_local_movies_24)
        .fallback(R.drawable.ic_baseline_local_movies_24)
) {

    Glide.with(context)
        .load(url)
        .apply(imageOption)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(image)
}

fun View.updateMarginTop(value: Int) {
    updateLayoutParams<ViewGroup.MarginLayoutParams> {
        topMargin = value
    }
}

val Int.toDp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.toPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()
