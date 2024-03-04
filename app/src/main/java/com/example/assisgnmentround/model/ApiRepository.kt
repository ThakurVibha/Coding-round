package com.example.assisgnmentround.model

import com.example.assisgnmentround.api.ApiClient
import com.example.assisgnmentround.data.LoginRequest
import com.example.assisgnmentround.data.LoginResponse
import retrofit2.Response

class ApiRepository {
    suspend fun login(requestBody: LoginRequest): Response<LoginResponse> {
        return ApiClient.apiService.loginUser(requestBody)
    }
}