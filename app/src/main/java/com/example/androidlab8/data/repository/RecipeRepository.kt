package com.example.androidlab8.data.repository

import com.example.androidlab8.data.source.remote.RetrofitModule

class RecipeRepository {
    private val apiServices = RetrofitModule.apiServices

    suspend fun getRecipes() = apiServices.getRecipes()
}