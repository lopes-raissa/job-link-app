package com.example.joblink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        window_splash.setOnClickListener {

            val abrirActivityMain = Intent(this, MainActivity::class.java)
            startActivity(abrirActivityMain)

        }


//        Handler().postDelayed({
//            startActivity(Intent(this, SplashScreenActivity::class.java))
//            finish()
//
//        }, 3000)
    }
}