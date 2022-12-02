package com.example.myapplication.animeapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.AnimeViewHolder
import com.example.myapplication.R
import com.example.myapplication.animeapi.response.Data

class AnimeAdapter(private val animes: List<Data>): RecyclerView.Adapter<AnimeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AnimeViewHolder(layoutInflater.inflate(R.layout.item_anime,parent, false))
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val item = animes[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = animes.size
}