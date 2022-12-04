package com.example.myapplication

import android.content.Intent
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.animeapi.response.Data
import com.example.myapplication.databinding.ItemAnimeBinding
import com.squareup.picasso.Picasso
import java.io.Serializable

class AnimeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemAnimeBinding.bind(view)
    private val item: LinearLayout = binding.animeRow

    fun bind(anime: Data) {
        itemAction(anime)

        Picasso.get().load(anime.images?.jpg?.imageUrl).into(binding.ivAnime)
        binding.animeDiscoverTV.setText(anime.title)
        binding.animeDiscoverLabelTV.setText(anime.season)
        binding.durationLabelTV.setText(anime.duration)
    }

    private fun itemAction(anime: Data) {
        item.setOnClickListener{
            val intent = Intent(this.itemView.context, MainActivity2::class.java)
            intent.putExtra("anime", anime as Serializable)
            this.itemView.context.startActivity(intent)
        }
    }
}