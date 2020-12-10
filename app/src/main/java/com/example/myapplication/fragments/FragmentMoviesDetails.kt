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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.activites.MainActivity
import com.example.myapplication.adapters.CastAdapter
import com.example.myapplication.adapters.LinearItemDecoration
import com.example.myapplication.custom_raiting_bar.RatingBarSvg
import com.example.myapplication.data.Movie
import com.example.myapplication.utils.loadImage
import com.example.myapplication.utils.toPx

class FragmentMoviesDetails : Fragment() {

    private lateinit var recycler: RecyclerView
    private lateinit var param1: Movie
    private lateinit var frPoster: ImageView
    private lateinit var frRating: RatingBarSvg
    private lateinit var frIsLike: ImageView
    private lateinit var frTtle: TextView
    private lateinit var frAgeLimit: TextView
    private lateinit var frTags: TextView
    private lateinit var frReviews: TextView
    private lateinit var frOverview: TextView
    private lateinit var back: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelable(Movie::class.java.name) ?: Movie()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)
        frPoster = view.findViewById(R.id.DetailPoster)
        frRating = view.findViewById(R.id.DetailStars)
        frIsLike = view.findViewById(R.id.DetailLike)
        frTtle = view.findViewById(R.id.DetailTitle)
        frAgeLimit = view.findViewById(R.id.DetailAge)
        frTags = view.findViewById(R.id.DetailTags)
        frReviews = view.findViewById(R.id.DetailReview)
        frOverview = view.findViewById(R.id.DetailOverview)
        back = view.findViewById(R.id.DetailBackButton)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.setSupportActionBar(view.findViewById(R.id.toolbar_trans1))
        val lManager = LinearLayoutManager(context)
        lManager.orientation = RecyclerView.HORIZONTAL
        recycler = view.findViewById<RecyclerView>(R.id.rv_actors)
        recycler.apply {
            layoutManager = lManager
            adapter = CastAdapter()
            addItemDecoration(LinearItemDecoration(2.toPx, 16.toPx))

        }

        param1.apply {
            loadImage(view.context, poster, frPoster)
            val like = if (is_like) R.drawable.like else R.drawable.no_like
            val drawable: Drawable? = ContextCompat.getDrawable(view.context, like)
            frTags.text = genres.joinToString(separator = ", ")
            frIsLike.setImageDrawable(drawable)
            frReviews.text = votes.toString().plus(" REVIEWS")
            frRating.rating = ratings / 2
            frTtle.text = title
            frAgeLimit.text = age.toString().plus("+")
            frOverview.text = overview
        }

        back.setOnClickListener {
            this.fragmentManager?.popBackStack()
        }

    }

    override fun onStart() {
        super.onStart()

        updateData()
    }

    private fun updateData() {
        (recycler?.adapter as? CastAdapter)?.apply {
            bindCast(param1.actors)
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