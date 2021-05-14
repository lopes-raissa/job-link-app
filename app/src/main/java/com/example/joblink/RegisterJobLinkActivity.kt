package com.example.joblink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.joblink.model.JobLink
import org.jetbrains.anko.doAsync

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
