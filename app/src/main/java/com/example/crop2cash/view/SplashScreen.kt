package com.example.crop2cash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.crop2cash.MainActivity
import com.example.crop2cash.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
                val mainActivityIntent = Intent(this@SplashScreen, MainActivity::class.java)
                startActivity(mainActivityIntent)
                finish()
        }, 3000)
    }
}