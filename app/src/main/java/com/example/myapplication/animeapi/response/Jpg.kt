package com.example.myapplication.animeapi.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Jpg (

  @SerializedName("image_url"       ) var imageUrl      : String? = null,
  @SerializedName("small_image_url" ) var smallImageUrl : String? = null,
  @SerializedName("large_image_url" ) var largeImageUrl : String? = null

): Serializable