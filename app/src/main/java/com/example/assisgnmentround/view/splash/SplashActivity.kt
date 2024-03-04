package com.example.assisgnmentround.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.assisgnmentround.databinding.ActivitySplashBinding
import com.example.assisgnmentround.view.home.HomeActivity
import com.example.assisgnmentround.view.login.LoginActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        runBlocking {
            launch {
                delay(5000)
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            }
        }
    }
}