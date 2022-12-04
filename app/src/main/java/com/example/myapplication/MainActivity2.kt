package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.example.myapplication.animeapi.response.Data
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity2 : AppCompatActivity() {

    private lateinit var anime: Data
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        anime =  intent.getSerializableExtra("anime") as Data
        binding.title.text = anime.title
        binding.label1.text = anime.status
        binding.label2.text = anime.duration
        binding.label3.text = anime.rating
        binding.label4.text = anime.source

        val score = anime.score?.toFloat() ?: 0.0f
        binding.score.rating = score
        binding.scoreText.text = score.toString()

        binding.synopsis.text = anime.synopsis
        binding.synopsis.movementMethod = ScrollingMovementMethod();

        Picasso.get()
            .load(anime.images?.jpg?.largeImageUrl)
            .resize(1000, 850)
            .into(binding.ivAnime)
    }
}