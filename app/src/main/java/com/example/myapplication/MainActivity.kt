package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.animeapi.APIService
import com.example.myapplication.animeapi.AnimeAdapter
import com.example.myapplication.animeapi.response.Data
import com.example.myapplication.animeapi.response.AnimeTopAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var binding: ActivityMainBinding

    /*
     * Carusel animes top
     */

    private val animeTopList = mutableListOf<Data>()
    private lateinit var animeTopAdapter: AnimeTopAdapter


    /*
     * carusel animes discover
     */

    private val animeList = mutableListOf<Data>()
    private lateinit var animeAdapter: AnimeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svAnime.setOnQueryTextListener(this)

        initAnimeTopRV()
        //initDiscoverRv()
    }

    private fun initDiscoverRv() {
        animeAdapter = AnimeAdapter(animeList)
        binding.rvAnime.layoutManager = LinearLayoutManager(this)
        binding.rvAnime.adapter = animeAdapter
    }

    private fun initAnimeTopRV() {
        searchAnime("score", "desc")

        animeTopAdapter = AnimeTopAdapter(animeList)
        val linearLayoutM = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.animeTopRV.layoutManager = linearLayoutM
        binding.animeTopRV.adapter = animeTopAdapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchAnime(
        score: String? = null,
        desc: String? = null,
        name: String? = null,
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getAnimes(score, desc, name)
            val animes = call.body()

            // Ejecución sobre hilo principal
            runOnUiThread {
                if (call.isSuccessful) {
                    val responseAnimes = animes?.data ?: emptyList()
                    animeList.clear()
                    animeList.addAll(responseAnimes)
                    animeTopAdapter.notifyDataSetChanged()
                } else {
                    showError()
                }

                hideKeyboard();
            }
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) {
            searchAnime(query)
        }

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}