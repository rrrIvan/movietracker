package com.example.myapplication.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.activites.MainActivity
import com.example.myapplication.adapters.CastAdapter
import com.example.myapplication.custom_raiting_bar.RatingBarSvg
import com.example.myapplication.data.Movie
import com.example.myapplication.utils.loadImage

class FragmentMoviesDetails : Fragment() {

    private var recycler: RecyclerView? = null
    private var param1: Movie? = null
    private lateinit var poster: ImageView
    private lateinit var rating: RatingBarSvg
    private lateinit var isLike: ImageView
    private lateinit var title: TextView
    private lateinit var ageLimit: TextView
    private lateinit var tags: TextView
    private lateinit var reviews: TextView

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
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)
        poster = view.findViewById(R.id.DetailPoster)
        rating = view.findViewById(R.id.DetailStars)
        isLike = view.findViewById(R.id.DetailLike)
        title = view.findViewById(R.id.DetailTitle)
        ageLimit = view.findViewById(R.id.DetailAge)
        tags = view.findViewById(R.id.DetailTags)
        reviews = view.findViewById(R.id.DetailReview)
        return view
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

        param1?.apply {
            loadImage(view.context, poster, this@FragmentMoviesDetails.poster)
            val like = if (param1?.is_like == true) R.drawable.like else R.drawable.no_like
            val drawable: Drawable? = ContextCompat.getDrawable(view.context, like)
            tags.text = param1?.genres?.joinToString(separator = ", ")
            isLike.setImageDrawable(drawable)
            reviews.text = param1?.votes.toString().plus(" REVIEWS")
            param1?.ratings?.let { rating.rating = it / 2 }
            this@FragmentMoviesDetails.title.text = param1?.title
            ageLimit.text = param1?.age.toString().plus("+")
        }

    }

    override fun onStart() {
        super.onStart()

        updateData()
    }

    private fun updateData() {
        (recycler?.adapter as? CastAdapter)?.apply {
            param1?.actors?.let { bindCast(it) }
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