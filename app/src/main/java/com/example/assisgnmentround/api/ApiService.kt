package com.example.assisgnmentround.api

import com.example.assisgnmentround.data.LoginRequest
import com.example.assisgnmentround.data.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
   suspend fun loginUser(@Body requestBody: LoginRequest): Response<LoginResponse>

}