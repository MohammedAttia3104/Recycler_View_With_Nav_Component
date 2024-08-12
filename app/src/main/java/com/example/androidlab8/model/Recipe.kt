package com.example.androidlab8.model

import com.google.gson.annotations.SerializedName


data class Recipe(
    @SerializedName("calories")
    var calories: String? = null,
    @SerializedName("carbos")
    var carbos: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("difficulty") var difficulty: Int? = null,
    @SerializedName("fats") var fats: String? = null,
    @SerializedName("headline") var headline: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("proteins") var proteins: String? = null,
    @SerializedName("thumb") var thumb: String? = null,
    @SerializedName("time") var time: String? = null
)