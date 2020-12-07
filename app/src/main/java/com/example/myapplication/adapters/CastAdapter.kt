package com.example.myapplication.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.local.model.Actor
import com.example.myapplication.local.model.Movie

class CastAdapter : RecyclerView.Adapter<CastAdapter.CastViewHolder>() {
    private val imageOption = RequestOptions()
        .placeholder(R.drawable.ic_avatar_placeholder)
        .fallback(R.drawable.ic_avatar_placeholder)

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
        (holder as DataViewHolder).onBind(imageOption, cast[position])
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


        fun onBind(options: RequestOptions, actor: Actor) {
            Glide.with(context)
                .load(actor.avatar)
                .apply(options)
                .into(photo)
            name.text = actor.name
        }
    }


}


private val RecyclerView.ViewHolder.context
    get() = this.itemView.context