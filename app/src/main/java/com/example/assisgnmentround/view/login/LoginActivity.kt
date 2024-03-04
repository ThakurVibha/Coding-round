package com.example.assisgnmentround.view.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.assisgnmentround.databinding.ActivityLoginBinding
import com.example.assisgnmentround.view.home.HomeActivity
import com.example.assisgnmentround.viewmodel.EmployeeViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var employeeViewModel: EmployeeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialiseViewModel()
        initializeClickListeners()
        observeLoginResponse()
    }

    private fun initialiseViewModel() {
        employeeViewModel = ViewModelProvider(this).get(EmployeeViewModel::class.java)
    }

    private fun validation(): Boolean {

        if (binding.etEmail.text.isNullOrBlank()) {
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.etPassword.text.isNullOrBlank()) {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show()
            return false

        }
        return true
    }

    private fun initializeClickListeners() {

        binding.tvLogin.setOnClickListener {
            if (validation()) {
                Toast.makeText(this, "Please Wait", Toast.LENGTH_SHORT).show()
                employeeViewModel.login(
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString()
                )
            }
        }

    }

    private fun observeLoginResponse() {
        employeeViewModel.loginResult.observe(this, Observer { response ->
            if (response != null) {
                if (response.token.isNotEmpty()) {
                    Toast.makeText(this, "Success token: ${response.token}", Toast.LENGTH_SHORT)
                        .show()
                    startActivity(Intent(this@LoginActivity, HomeActivity::class.java))

                } else {
                    Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
            }
        })
        employeeViewModel.errorResponse.observe(this, Observer { getError ->
            if (getError != null) {
                Log.d("getAPIResponse", getError.toString())
            }
        })

    }
}