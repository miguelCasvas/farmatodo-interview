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
        showToast("Ha ocurrido un error")
    }

    protected fun showToast(message: String) {
        Toast.makeText(mainActivity, message, Toast.LENGTH_SHORT).show()
    }

    abstract fun initAnimeRecycleView();

    abstract fun searchAnime(query: String? = null);
}