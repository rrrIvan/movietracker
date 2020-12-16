package com.github.movietracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.example.movietracker.R
import com.github.movietracker.data.Actor
import com.github.movietracker.extensions.loadImage

class CastAdapter : RecyclerView.Adapter<CastAdapter.DataViewHolder>() {

    private var cast = listOf<Actor>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.item_actor, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(cast[position])
    }

    override fun getItemCount(): Int = cast.size

    fun bindCast(newCast: List<Actor>) {
        cast = newCast
        notifyDataSetChanged()
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val photo: ImageView = itemView.findViewById(R.id.ActorPhoto)
        private val name: TextView = itemView.findViewById(R.id.ActorName)

        fun bind(actor: Actor) {

            loadImage(
                context,
                actor.picture,
                photo,
                RequestOptions()
                    .placeholder(R.drawable.ic_baseline_person_outline_24)
                    .fallback(R.drawable.ic_baseline_person_outline_24)
            )
            name.text = actor.name
        }
    }
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context
