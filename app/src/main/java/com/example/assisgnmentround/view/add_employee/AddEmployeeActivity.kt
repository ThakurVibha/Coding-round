package com.example.assisgnmentround.view.add_employee

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.assisgnmentround.databinding.ActivityAddEmployeeBinding
import com.example.assisgnmentround.room_database.EmployeeDatabase
import com.example.assisgnmentround.room_database.EmployeeViewModel
import com.example.assisgnmentround.room_database.EmployeeViewModelFactory
import com.example.assisgnmentround.room_database.LocalRepository
import com.example.assisgnmentround.view.home.HomeActivity

class AddEmployeeActivity : AppCompatActivity() {
    private lateinit var employeeViewModel: EmployeeViewModel

    lateinit var binding: ActivityAddEmployeeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEmployeeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialiseClickListneners()

        val dao = EmployeeDatabase.getDatabase(applicationContext).getEmployeeDao()
        val repository = LocalRepository(dao)
        employeeViewModel = ViewModelProvider(
            this,
            EmployeeViewModelFactory(repository)
        ).get(EmployeeViewModel::class.java)
//        observerData()
    }

    private fun validation(): Boolean {

        if (binding.etEmail.text.isNullOrBlank()) {
            Toast.makeText(this, "Please Enter First Name", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.etLastName.text.isNullOrBlank()) {
            Toast.makeText(this, "Please Enter Last Name", Toast.LENGTH_SHORT).show()
            return false

        }
        if (binding.etAge.text.isNullOrBlank()) {
            Toast.makeText(this, "Please Enter Age", Toast.LENGTH_SHORT).show()
            return false

        }
        if (binding.etAddress.text.isNullOrBlank()) {
            Toast.makeText(this, "Please Enter Address", Toast.LENGTH_SHORT).show()
            return false

        }
        if (binding.etCityName.text.isNullOrBlank()) {
            Toast.makeText(this, "Please Enter City", Toast.LENGTH_SHORT).show()
            return false

        }
        return true
    }

    private fun initialiseClickListneners() {
        binding.tvAddToDatabase.setOnClickListener {
            if (validation()) {
                employeeViewModel.insertData(
                    binding.etEmail.text.toString(),
                    binding.etLastName.text.toString(),
                    binding.etAge.text.toString(),
                    binding.etAddress.text.toString(),
                    binding.etCityName.text.toString()
                )
                startActivity(Intent(this@AddEmployeeActivity, HomeActivity::class.java))

            }
        }
    }
}

//    private fun observerData() {
//        employeeViewModel.getAllData().observe(this, Observer { data ->
//            if (data.isNotEmpty()) {
//                startActivity(Intent(this, HomeActivity::class.java))
//            }
//
//        })
//    }
