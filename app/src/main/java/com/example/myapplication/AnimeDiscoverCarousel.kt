package com.example.myapplication

import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.animeapi.APIService
import com.example.myapplication.animeapi.AnimeAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AnimeDiscoverCarousel (mainActivity: MainActivity) : AnimeCarousel(mainActivity) {

    private lateinit var animeAdapter: AnimeAdapter

    override fun initAnimeRecycleView() {
        searchAnime()
        animeAdapter = AnimeAdapter(animeList)
        mainActivity.getBinding().rvAnime.layoutManager = LinearLayoutManager(mainActivity)
        mainActivity.getBinding().rvAnime.adapter = animeAdapter
    }

    override fun searchAnime(query: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getAnimes(null, null, query)
            val animes = call.body()

            runBlocking(Dispatchers.Main) {
                if (call.isSuccessful) {
                    val responseAnimes = animes?.data ?: emptyList()
                    animeList.clear()
                    animeList.addAll(responseAnimes)
                    animeAdapter.notifyDataSetChanged()

                    if (animeList.isEmpty()) {
                        showToast("Ay! ese anime no está disponible")
                    }
                } else {
                    showError()
                }

                hideKeyboard();
            }
        }
    }

    private fun hideKeyboard() {
        val imm = mainActivity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(mainActivity.getBinding().viewRoot.windowToken, 0)
    }
}