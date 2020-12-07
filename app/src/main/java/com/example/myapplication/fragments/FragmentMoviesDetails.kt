package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.activites.MainActivity
import com.example.myapplication.adapters.CastAdapter
import com.example.myapplication.adapters.MovieAdapter
import com.example.myapplication.local.MockRepository

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMoviesDetails.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMoviesDetails : Fragment() {

    private var recycler: RecyclerView? = null
    private var param1: Int? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
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
    }

    override fun onStart() {
        super.onStart()

        updateData()
    }

    private fun updateData() {
        (recycler?.adapter as? CastAdapter)?.apply {
            bindCast(MockRepository().getMovies()[0].cast)
        }
    }

    companion object {
         @JvmStatic
        fun newInstance(param1: Int = 0, param2: String = "") =
            FragmentMoviesDetails().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}