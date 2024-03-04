package com.example.assisgnmentround.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [EmployeeEntity::class], version = 1)
abstract class EmployeeDatabase : RoomDatabase() {
    abstract fun getEmployeeDao(): EmployeeDAO

    companion object {
        @Volatile
        private var INSTANCE: EmployeeDatabase? = null

        fun getDatabase(context: Context):  EmployeeDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EmployeeDatabase::class.java,
                    "task_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
