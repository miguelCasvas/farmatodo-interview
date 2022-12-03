package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var animeDiscoverCarousel: AnimeDiscoverCarousel
    private lateinit var animeTopCarousel: AnimeTopCarousel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svAnime.setOnQueryTextListener(this)

        animeDiscoverCarousel = AnimeDiscoverCarousel(this)
        animeDiscoverCarousel.initAnimeRecycleView()

        animeTopCarousel = AnimeTopCarousel(this)
        animeTopCarousel.initAnimeRecycleView()
    }

    fun getBinding(): ActivityMainBinding {
        return binding
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) {
            animeDiscoverCarousel.searchAnime(query)
        }

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}