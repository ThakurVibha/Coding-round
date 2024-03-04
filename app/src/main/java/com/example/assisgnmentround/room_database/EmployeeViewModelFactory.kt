package com.example.assisgnmentround.room_database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class EmployeeViewModelFactory(private val repository: LocalRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EmployeeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return EmployeeViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }

}