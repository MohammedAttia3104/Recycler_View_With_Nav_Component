package com.example.androidlab8.data.source.remote

import com.example.androidlab8.model.Recipe
import retrofit2.http.GET

interface ApiServices {

    @GET(RetrofitModule.RECIPES_ENDPOINT)
    suspend fun getRecipes(): ArrayList<Recipe>
}


