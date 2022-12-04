package com.example.myapplication.animeapi.response

import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("mal_id"          ) var malId          : Int?                 = null,
  @SerializedName("images"          ) var images         : Images?              = Images(Jpg(), Webp()),
  @SerializedName("title"           ) var title          : String?              = null,
  @SerializedName("title_synonyms"  ) var titleSynonyms  : ArrayList<String>    = arrayListOf(),
  @SerializedName("source"          ) var source         : String?              = null,
  @SerializedName("episodes"        ) var episodes       : Int?                 = null,
  @SerializedName("status"          ) var status         : String?              = null,
  @SerializedName("airing"          ) var airing         : Boolean?             = null,
  @SerializedName("aired"           ) var aired          : Aired?               = Aired(),
  @SerializedName("rating"          ) var rating         : String?              = null,
  @SerializedName("score"           ) var score          : Double?              = null,
  @SerializedName("scored_by"       ) var scoredBy       : Int?                 = null,
  @SerializedName("rank"            ) var rank           : Int?                 = null,
  @SerializedName("popularity"      ) var popularity     : Int?                 = null,
  @SerializedName("members"         ) var members        : Int?                 = null,
  @SerializedName("synopsis"        ) var synopsis       : String?              = null,
  @SerializedName("season"          ) var season         : String?              = null,
  @SerializedName("year"            ) var year           : Int?                 = null,
  @SerializedName("duration"        ) var duration       : String?              = null,
)