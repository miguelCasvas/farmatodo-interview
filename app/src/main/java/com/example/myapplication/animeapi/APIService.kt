package com.example.myapplication.animeapi

import com.example.myapplication.animeapi.response.AnimeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getAnimes(@Url url:String): Response<AnimeResponse>
}