package com.example.assisgnmentround.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assisgnmentround.data.LoginRequest
import com.example.assisgnmentround.data.LoginResponse
import com.example.assisgnmentround.model.ApiRepository
import kotlinx.coroutines.launch

class EmployeeViewModel : ViewModel() {
    private val apiRepository = ApiRepository()

    private val getLoginResponse = MutableLiveData<LoginResponse>()
    val loginResult: LiveData<LoginResponse> = getLoginResponse

    private val getErrorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String> = getErrorResponse

    fun login(email: String, password: String) {
        val requestBody = LoginRequest(email,password)
        viewModelScope.launch {
            val response = apiRepository.login(requestBody)
            Log.d("GET REQUEST", requestBody.toString())
            getLoginResponse.value = response.body()
            getErrorResponse.value=response.errorBody().toString()
        }
    }


}