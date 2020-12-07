package com.example.myapplication.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.activites.MainActivity
import com.example.myapplication.adapters.GridDividerItemDecoration
import com.example.myapplication.adapters.MovieAdapter
import com.example.myapplication.local.MockRepository
import timber.log.Timber


class FragmentMoviesList : Fragment() {
    private var recycler: RecyclerView? = null
    private var orientation: Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        orientation = resources.configuration.orientation
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.let {
            it.setSupportActionBar(view.findViewById(R.id.toolbar_trans2))
        }
            val lManager = GridLayoutManager(context, (orientation?:1)*2)
        recycler = view.findViewById<RecyclerView>(R.id.rv_films)

        //ContextCompat.getDrawable(context, R.drawable.star_icon)


        recycler?.apply {
            layoutManager = lManager
            adapter = MovieAdapter()

        }

        recycler?.addItemDecoration(GridDividerItemDecoration((orientation?:1)*2,30,true))
//        view.findViewById<MaterialCardView>(R.id.material_card).setOnClickListener {
//            activity?.apply {
//                supportFragmentManager.beginTransaction()
//                    .apply {
//                        add(R.id.fragments_container, FragmentMoviesDetails.newInstance(param1 ?: 0))
//                        addToBackStack(null)
//                        commit()
//                    }
//            }
//        }
    }
    override fun onStart() {
        super.onStart()

        updateData()
    }

    private fun updateData() {
        (recycler?.adapter as? MovieAdapter)?.apply {
            bindMovies(MockRepository().getMovies())
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = FragmentMoviesList()
    }
}