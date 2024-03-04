package com.example.assisgnmentround.view.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assisgnmentround.databinding.ActivityHomeBinding
import com.example.assisgnmentround.room_database.EmployeeDatabase
import com.example.assisgnmentround.room_database.EmployeeEntity
import com.example.assisgnmentround.room_database.EmployeeViewModel
import com.example.assisgnmentround.room_database.EmployeeViewModelFactory
import com.example.assisgnmentround.room_database.LocalRepository
import com.example.assisgnmentround.view.add_employee.AddEmployeeActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var employeeViewModel: EmployeeViewModel
    private lateinit var homeAdapter: HomeAdapter
    private var employeeListData = listOf<EmployeeEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initiaseClickListeners()
        initiaseViewModel()
        observerData()
    }


    private fun initiaseClickListeners() {
        binding.btnAddEmployee.setOnClickListener {
            startActivity(Intent(this, AddEmployeeActivity::class.java))
        }
    }

    private fun initiaseViewModel() {
        val dao = EmployeeDatabase.getDatabase(applicationContext).getEmployeeDao()
        val repository = LocalRepository(dao)
        employeeViewModel = ViewModelProvider(
            this,
            EmployeeViewModelFactory(repository)
        ).get(EmployeeViewModel::class.java)
    }

    private fun observerData() {
        employeeViewModel.getAllData().observe(this, Observer { data ->
            if (data.isNotEmpty()) {
                Log.d("GET DATA", data.toString())
                binding.ivEmpty.visibility = View.GONE
                binding.rvEmployeeList.visibility = View.VISIBLE
                Toast.makeText(this, "Fetched Data: $data", Toast.LENGTH_SHORT).show()
                homeAdapter = HomeAdapter(data) // Initialize adapter with empty list
                binding.rvEmployeeList.layoutManager = LinearLayoutManager(this)
                binding.rvEmployeeList.adapter = homeAdapter
            } else {
                binding.ivEmpty.visibility = View.VISIBLE
                binding.rvEmployeeList.visibility = View.GONE
            }
        })
    }


}