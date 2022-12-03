package com.example.myapplication

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.animeapi.APIService
import com.example.myapplication.animeapi.response.AnimeTopAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AnimeTopCarousel(mainActivity: MainActivity) : AnimeCarousel(mainActivity) {

    private lateinit var animeTopAdapter: AnimeTopAdapter

    override fun initAnimeRecycleView() {
        searchAnime()
        animeTopAdapter = AnimeTopAdapter(animeList)
        val linearLayoutM = LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false)

        mainActivity.getBinding().animeTopRV.layoutManager = linearLayoutM
        mainActivity.getBinding().animeTopRV.adapter = animeTopAdapter
    }

    override fun searchAnime(query: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getAnimes("score", "desc", null)
            val animes = call.body()

            runBlocking(Dispatchers.Main) {
                if (call.isSuccessful) {
                    val responseAnimes = animes?.data ?: emptyList()
                    animeList.clear()
                    animeList.addAll(responseAnimes)
                    animeTopAdapter.notifyDataSetChanged()
                } else {
                    showError()
                }
            }
        }
    }
}