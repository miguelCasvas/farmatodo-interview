package com.example.myapplication.animeapi.response

import com.google.gson.annotations.SerializedName


data class AnimeResponse (

  @SerializedName("pagination" ) var pagination : Pagination?     = Pagination(),
  @SerializedName("data"       ) var data       : List<Data> = arrayListOf()

)