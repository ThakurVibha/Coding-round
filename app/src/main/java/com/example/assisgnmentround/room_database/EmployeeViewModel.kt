package com.example.assisgnmentround.room_database

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EmployeeViewModel(private val localRepository: LocalRepository):ViewModel() {

     fun insertData( first_name:String, last_name:String , age:String , address:String, city:String) {
        viewModelScope.launch {
            Log.d("first_name",first_name)
            Log.d("last_name",last_name)
            localRepository.insertData( first_name, last_name, age, address, city)
        }
    }

    fun getAllData(): LiveData<List<EmployeeEntity>> {
        return localRepository.getAllData()
    }
}