package com.example.assisgnmentround.room_database

import androidx.core.text.util.LocalePreferences.FirstDayOfWeek.Days
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EmployeeDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(data: EmployeeEntity)

    @Query("SELECT * FROM employee_data")
    fun getAllData(): LiveData<List<EmployeeEntity>>
}