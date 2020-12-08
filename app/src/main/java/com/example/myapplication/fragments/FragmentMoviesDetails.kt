package com.example.myapplication.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.activites.MainActivity
import com.example.myapplication.adapters.CastAdapter
import com.example.myapplication.local.model.Movie

class FragmentMoviesDetails : Fragment() {

    private var recycler: RecyclerView? = null
    private var param1: Movie? = null
    private val imageOption = RequestOptions()
        .placeholder(R.drawable.ic_movie_placeholder)
        .fallback(R.drawable.ic_movie_placeholder)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelable(Movie::class.java.name)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.let {
            it.setSupportActionBar(view.findViewById(R.id.toolbar_trans1))
        }
        val lManager = LinearLayoutManager(context)
        lManager.orientation = RecyclerView.HORIZONTAL
        recycler = view.findViewById<RecyclerView>(R.id.rv_actors)
        recycler?.apply {
            layoutManager = lManager
            adapter = CastAdapter()

        }

        val poster: ImageView = view.findViewById(R.id.DetailPoster)
        val rating: ImageView = view.findViewById(R.id.DetailStars)
        val isLike: ImageView = view.findViewById(R.id.DetailLike)
        val title: TextView = view.findViewById(R.id.DetailTitle)
        val ageLimit: TextView = view.findViewById(R.id.DetailAge)
        val tags: TextView = view.findViewById(R.id.DetailTags)
        val reviews: TextView = view.findViewById(R.id.DetailReview)
        Glide.with(view.context)
            .load(param1?.poster)
            .apply(imageOption)
            .into(poster)
        val drawable: Drawable? = if (param1?.isLiked == true) {
            ContextCompat.getDrawable(view.context, R.drawable.like)
        } else {
            ContextCompat.getDrawable(view.context, R.drawable.no_like)
        }
        tags.text = param1?.tags?.joinToString(separator = ", ")
        isLike.setImageDrawable(drawable)
        reviews.text = param1?.reviews.toString().plus(" REVIEWS")
        rating.setImageDrawable(ContextCompat.getDrawable(view.context, R.drawable.star_icon))
        title.text = param1?.title
        ageLimit.text = param1?.ageLimit.toString()

    }

    override fun onStart() {
        super.onStart()

        updateData()
    }

    private fun updateData() {
        (recycler?.adapter as? CastAdapter)?.apply {
            param1?.cast?.let { bindCast(it) }
        }
    }

    companion object {
         @JvmStatic
        fun newInstance(param: Movie) =
            FragmentMoviesDetails().apply {
                arguments = Bundle().apply {
                    putParcelable(Movie::class.java.name, param)
                }
            }
    }
}