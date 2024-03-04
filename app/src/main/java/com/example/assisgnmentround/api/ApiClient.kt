package com.example.assisgnmentround.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val retrofit =
        Retrofit.Builder().
        baseUrl("https://reqres.in/api/").
        addConverterFactory(GsonConverterFactory.create()).build()

    val apiService= retrofit.create(ApiService::class.java)


}