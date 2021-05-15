package com.example.joblink.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.joblink.R
import com.example.joblink.api.RetrofitApi
import com.example.joblink.api.UserSessionCall
import com.example.joblink.model.UserSession
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterJobLinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_job_link)

        //parte que abre o layout de criar conta
        val buttonVoltar = findViewById<TextView>(R.id.button_back_register)

        buttonVoltar.setOnClickListener {
            onBackPressed()
        }

    }
}
