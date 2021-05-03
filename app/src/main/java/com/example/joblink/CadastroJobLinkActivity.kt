package com.example.joblink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.joblink.model.JobLink
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_cadastro_job_link.view.*
import kotlinx.android.synthetic.main.activity_main.view.*

class CadastroJobLinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_job_link)

        val buttonSalvar = findViewById<Button>(R.id.button_criar_conta)
        val editTextNome = findViewById<EditText>(R.id.edit_text_name)
        val editTextSexo = findViewById<EditText>(R.id.edit_text_sexo)
        val editTextNascimento = findViewById<EditText>(R.id.edit_text_nascimento)
        val editTextEmail = findViewById<EditText>(R.id.edit_text_email_register)
        val editTextCpf = findViewById<EditText>(R.id.edit_text_cpf)
        val editTextSenha = findViewById<EditText>(R.id.edit_text_senha_register)

        buttonSalvar.setOnClickListener {
            // criando um onjeto Joblink
            val cliente = JobLink()
            cliente.name = editTextNome.toString()
            cliente.sexo = editTextSexo.toString()
            cliente.dataNasc = editTextNascimento.toString()
            cliente.email = editTextEmail.toString()
            cliente.cpf = editTextCpf.toString()
            cliente.senha = editTextSenha.toString()

            // convertendo em json
            val gson = Gson()
            val clienteJson = gson.toJson(cliente)

            println("################################" + clienteJson)

        }
    }
}