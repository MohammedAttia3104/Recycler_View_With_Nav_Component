package com.example.androidlab8.data.source.remote

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {
    private const val BASE_URL = "https://hf-android-app.s3-eu-west-1.amazonaws.com/"
    const val RECIPES_ENDPOINT = "android-test/recipes.json"

    private val httpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor).build()


    private val gson = GsonBuilder().serializeNulls().create()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson)).client(okHttpClient)
        .build()

    val apiServices: ApiServices = retrofit.create(ApiServices::class.java)
}