package com.example.myapplication.animeapi.response

import com.google.gson.annotations.SerializedName


data class Prop (

  @SerializedName("from" ) var from : From? = From(),
  @SerializedName("to"   ) var to   : To?   = To()

)