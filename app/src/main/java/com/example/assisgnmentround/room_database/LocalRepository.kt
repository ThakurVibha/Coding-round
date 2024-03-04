package com.example.assisgnmentround.room_database

import androidx.lifecycle.LiveData

class LocalRepository(private val employeeDAO: EmployeeDAO) {
    suspend fun insertData(

        first_name: String,
        last_name: String,
        age: String,
        address: String,
        city: String

    ) {
        val data = EmployeeEntity(
            first_name = first_name,
            last_name = last_name,
            age = age,
            address = address,
            city = city
        )
        employeeDAO.insertData(data)
    }

    fun getAllData(): LiveData<List<EmployeeEntity>> {
        return employeeDAO.getAllData()
    }
}