package com.example.myapplication.animeapi

import com.example.myapplication.animeapi.response.AnimeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("v4/anime")
    suspend fun getAnimes(
        @Query("order_by") orderBy: String?,
        @Query("sort") sort: String?,
        @Query("letter") letter: String?
    ): Response<AnimeResponse>
}