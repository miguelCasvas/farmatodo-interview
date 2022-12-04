package com.example.myapplication.animeapi.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Images (
  @SerializedName("jpg") var jpg: Jpg?,
  @SerializedName("webp") var webp: Webp?
): Serializable