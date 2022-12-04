package com.example.myapplication.animeapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.AnimeTopViewHolder
import com.example.myapplication.R
import com.example.myapplication.animeapi.response.Data


class AnimeTopAdapter(private val animeList: List<Data>): RecyclerView.Adapter<AnimeTopViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeTopViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AnimeTopViewHolder(layoutInflater.inflate(R.layout.item_anime_top,parent, false))
    }

    override fun onBindViewHolder(holder: AnimeTopViewHolder, position: Int) {
        val item = animeList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = animeList.size
}
