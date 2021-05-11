package com.example.joblink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.joblink.http.HttpHelper
import com.example.joblink.model.JobLink
import com.google.gson.Gson
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

        val buttonSalvar = findViewById<Button>(R.id.button_criar_conta)
        val editTextNome = findViewById<EditText>(R.id.edit_text_name)
        val editTextSexo = findViewById<EditText>(R.id.edit_text_sexo)
        val editTextNascimento = findViewById<EditText>(R.id.edit_text_nascimento)
        val editTextEmail = findViewById<EditText>(R.id.edit_text_email_register)
        val editTextCpf = findViewById<EditText>(R.id.edit_text_cpf)
        val editTextSenha = findViewById<EditText>(R.id.edit_text_senha_register)

        buttonSalvar.setOnClickListener {
            // criando um objeto Joblink
            val cliente = JobLink()
            cliente.name = editTextNome.text.toString()
            cliente.sexo = editTextSexo.text.toString()
            cliente.birthDate = editTextNascimento.text.toString()
            cliente.email = editTextEmail.text.toString()
            cliente.cpf = editTextCpf.text.toString()
            cliente.password = editTextSenha.text.toString()

            //converte em json
            val gson = Gson()
            val clienteJson = gson.toJson(cliente)

            doAsync {
                val http = HttpHelper()
                http.post(clienteJson)
            }

        }
    }
}
