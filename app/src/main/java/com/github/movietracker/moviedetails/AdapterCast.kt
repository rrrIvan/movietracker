package com.github.movietracker.moviedetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.example.movietracker.R
import com.example.movietracker.databinding.ItemActorBinding
import com.github.movietracker.data.Actor
import com.github.movietracker.extensions.loadImage

class CastAdapter : RecyclerView.Adapter<CastAdapter.DataViewHolder>() {
    private var cast = listOf<Actor>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataViewHolder {
        return DataViewHolder(
            ItemActorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
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

    class DataViewHolder(private val binding: ItemActorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(actor: Actor) {
            binding.itemactorPhoto.loadImage(
                context,
                actor.picture,
                RequestOptions()
                    .placeholder(R.drawable.ic_baseline_person_outline_24)
                    .fallback(R.drawable.ic_baseline_person_outline_24)
            )
            binding.itemactorName.text = actor.name
        }
    }
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context
