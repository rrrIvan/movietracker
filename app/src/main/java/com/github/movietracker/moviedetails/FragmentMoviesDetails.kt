package com.github.movietracker.ui

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movietracker.R
import com.example.movietracker.databinding.FragmentMoviesDetailsBinding
import com.github.movietracker.activites.ActivityMain
import com.github.movietracker.adapters.CastAdapter
import com.github.movietracker.adapters.ItemDecorationLinear
import com.github.movietracker.data.Movie
import com.github.movietracker.extensions.Constants
import com.github.movietracker.extensions.loadImage
import com.github.movietracker.extensions.toPx

class FragmentMoviesDetails : Fragment() {
    private var _binding: FragmentMoviesDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var movie: Movie
    private lateinit var castAdapter: CastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movie = it.getParcelable(Constants.MOVIE_KEY) ?: Movie()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as? ActivityMain)?.updateStatusBarColor(R.color.transparent)
        _binding = FragmentMoviesDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<Toolbar>(R.id.details_toolbar)
        (activity as? ActivityMain)?.apply {
            updateStatusBarColor(R.color.transparent)
            setSupportActionBar(toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
                setHomeButtonEnabled(true)
                elevation = 0.0f
            }
        }

        binding.detailActors.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = CastAdapter()
            addItemDecoration(ItemDecorationLinear(2.toPx, 16.toPx))
        }

        movie.apply {
            binding.apply {
                detailsPoster.loadImage(view.context, backdrop)
                val like = if (like) R.drawable.like_16dp else R.drawable.no_like_16dp
                val drawable: Drawable? = ContextCompat.getDrawable(view.context, like)
                detailTags.text = genres.joinToString(separator = ", ") { it.name }
                detailsLike.setImageDrawable(drawable)
                detailReview.text = votes.toString().plus(" REVIEWS")
                detailStars.rating = rating / 2
                detailsCollapsing.title = title
                detailsTextage.text = age.toString().plus("+")
                detailOverview.text = overview
                castAdapter = detailActors.adapter as CastAdapter
            }
        }
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun updateData() {
        castAdapter.apply {
            bindCast(movie.actors)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param: Movie) =
            FragmentMoviesDetails().apply {
                arguments = Bundle().apply {
                    putParcelable(Constants.MOVIE_KEY, param)
                }
            }
    }
}
