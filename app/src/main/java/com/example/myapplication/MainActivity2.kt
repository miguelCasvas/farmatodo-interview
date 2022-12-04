package com.example.myapplication

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.animeapi.response.Data
import com.example.myapplication.databinding.ActivityMain2Binding
import com.squareup.picasso.Picasso

class MainActivity2 : AppCompatActivity() {

    private lateinit var anime: Data
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // calling the action bar
        var actionBar = getSupportActionBar()
        if (actionBar != null) {

            // Customize the back button
            actionBar.setHomeAsUpIndicator(R.drawable.back_arrow_5821)
            actionBar.setHomeButtonEnabled(true)

            // showing the back button in action bar
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        anime = intent.getSerializableExtra("anime") as Data
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}