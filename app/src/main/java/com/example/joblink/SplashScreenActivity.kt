package com.example.joblink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        changeToLogin()
        }
    fun changeToLogin(){
        val intent = Intent(this, MainActivity::class.java)

        Handler().postDelayed({
            intent.change()
        }, 2000)
    }

    fun Intent.change(){
        startActivity(this)
        finish()
    }
}