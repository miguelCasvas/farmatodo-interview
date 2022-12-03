package com.example.myapplication

import android.widget.Toast
import com.example.myapplication.animeapi.response.Data
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class AnimeCarousel(var mainActivity: MainActivity) {

    protected val animeList = mutableListOf<Data>()

    protected fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    protected fun showError() {
        Toast.makeText(mainActivity, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    abstract fun initAnimeRecycleView();

    abstract fun searchAnime(query: String? = null);
}