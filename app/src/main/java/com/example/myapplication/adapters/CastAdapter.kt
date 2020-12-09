package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.data.Actor
import com.example.myapplication.utils.loadImage

class CastAdapter : RecyclerView.Adapter<CastAdapter.CastViewHolder>() {

    private var cast = listOf<Actor>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CastViewHolder {
        return DataViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.item_actor, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        (holder as DataViewHolder).onBind(cast[position])
    }

    override fun getItemCount(): Int = cast.size

    fun bindCast(newCast: List<Actor>) {
        cast = newCast
        notifyDataSetChanged()
    }

    abstract class CastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    private class DataViewHolder(itemView: View) : CastAdapter.CastViewHolder(itemView) {

        private val photo: ImageView = itemView.findViewById(R.id.ActorPhoto)
        private val name: TextView = itemView.findViewById(R.id.ActorName)


        fun onBind(actor: Actor) {
            loadImage(context,actor.picture,photo,
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