package com.example.myapplication

import android.content.Intent
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.animeapi.response.Data
import com.example.myapplication.databinding.ItemAnimeTopBinding
import com.squareup.picasso.Picasso
import java.io.Serializable


class AnimeTopViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemAnimeTopBinding.bind(view)
    private val card: CardView = binding.animeCardTop


    fun bind(anime: Data) {
        itemAction(anime)

        Picasso.get()
            .load(anime.images?.jpg?.imageUrl)
            .resize(450, 600)
            .into(binding.animeTopIV)
    }

    private fun itemAction(anime: Data) {
        card.setOnClickListener{
            val intent = Intent(this.itemView.context, MainActivity2::class.java)
            intent.putExtra("anime", anime as Serializable)
            this.itemView.context.startActivity(intent)
        }
    }
}