package com.example.assisgnmentround.room_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee_data")
data class EmployeeEntity(
    @PrimaryKey
    val first_name: String,
    val last_name: String,
    val age: String,
    val address: String,
    val city: String
)
