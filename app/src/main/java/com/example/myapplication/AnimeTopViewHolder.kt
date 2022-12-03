package com.example.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.animeapi.response.Data
import com.example.myapplication.databinding.ItemAnimeTopBinding
import com.squareup.picasso.Picasso

class AnimeTopViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemAnimeTopBinding.bind(view)

    fun bind(anime: Data) {
        Picasso.get()
            .load(anime.images?.jpg?.imageUrl)
            .resize(450, 600)
            .into(binding.animeTopIV)
    }
}