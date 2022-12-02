package com.example.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.animeapi.response.Data
import com.example.myapplication.databinding.ItemAnimeBinding
import com.squareup.picasso.Picasso

class AnimeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemAnimeBinding.bind(view)

    fun bind(anime: Data) {
        Picasso.get().load(anime.images?.jpg?.imageUrl).into(binding.ivAnime)
    }
}