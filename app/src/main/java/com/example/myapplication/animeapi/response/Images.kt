package com.example.myapplication.animeapi.response

import com.google.gson.annotations.SerializedName


data class Images (
  @SerializedName("jpg") var jpg: Jpg?,
  @SerializedName("webp") var webp: Webp?
)