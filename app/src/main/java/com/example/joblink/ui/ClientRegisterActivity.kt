package com.example.joblink.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.joblink.R
import com.example.joblink.api.Calls.ClientRegisterCall
import com.example.joblink.api.RetrofitApi
import com.example.joblink.api.SessionManager
import com.example.joblink.model.RegisterClientModel
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


lateinit var btnPhotoFreelancer: Button
lateinit var imagePhoto: ImageView
lateinit var emailRegister: EditText
lateinit var passwordRegister: EditText
lateinit var nameRegister: EditText
lateinit var addressRegister: EditText
lateinit var birthDateRegister: EditText
lateinit var cpfRegister: EditText
lateinit var btnRegisterClient: Button
lateinit var sessionManager: SessionManager

private var uriImage: Uri? = null

class ClientRegisterActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_client)

        btnPhotoFreelancer = findViewById(R.id.btn_photo_register)
        imagePhoto = findViewById(R.id.iv_photo_register)

        btnPhotoFreelancer.setOnClickListener(this)
        loadData()
    }

    private fun loadData() {

        btnPhotoFreelancer = findViewById(R.id.btn_photo_register)
        imagePhoto = findViewById(R.id.iv_photo_register)
        emailRegister = findViewById(R.id.et_email_address)
        passwordRegister = findViewById(R.id.et_password)
        nameRegister = findViewById(R.id.et_name)
        addressRegister = findViewById(R.id.et_postal_address)
        birthDateRegister = findViewById(R.id.et_birth_date)
        cpfRegister = findViewById(R.id.et_cpf)
        btnRegisterClient = findViewById(R.id.btn_register_client)

        sessionManager = SessionManager(this)
        btnPhotoFreelancer.setOnClickListener(this)
        btnRegisterClient.setOnClickListener(this)

        val maskDate: SimpleMaskFormatter = SimpleMaskFormatter("NN/NN/NNNN")
        val mtwDate: MaskTextWatcher = MaskTextWatcher(birthDateRegister, maskDate)
        birthDateRegister.addTextChangedListener(mtwDate)

        val maskCpf: SimpleMaskFormatter = SimpleMaskFormatter("NNNNNNNNNNN")
        val mtwCpf: MaskTextWatcher = MaskTextWatcher(cpfRegister, maskCpf)
        cpfRegister.addTextChangedListener(mtwCpf)
    }

    override fun onClick(view: View) {

        when (view.id) {
            R.id.btn_photo_register -> {
                selectPhotoGalery()
            }
            R.id.btn_register_client -> {
                validarCampos()
                registered()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {

            if (requestCode == 1 && data != null) {

                uriImage = data.data
                imagePhoto.setImageURI(uriImage)
            }
        }
    }

    private fun selectPhotoGalery() {
        var intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        intent.setType("image/*")

        startActivityForResult(Intent.createChooser(intent, "Escolha uma imagem"), 1)
    }

    private fun notifyUser(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun validarCampos() {

    }

    private fun goToHome() {
        val homeActivity = Intent(this, HomeActivity::class.java)
        startActivity(homeActivity)
        finish()
    }

    fun registered() {
        val userRegister = RegisterClientModel(
            name = nameRegister.text.toString(),
            email = emailRegister.text.toString(),
            cpf = cpfRegister.text.toString(),
            password = passwordRegister.text.toString(),
            address = addressRegister.text.toString(),
            birthDate = birthDateRegister.text.toString(),
            gender = "M",
            image = imagePhoto.toString()
        )

        val retrofit = RetrofitApi.getRetrofit(ClientRegisterCall::class.java, this)
        val call = retrofit.addClient(userRegister)

        call.enqueue(object : Callback<RegisterClientModel> {

            override fun onResponse(
                call: Call<RegisterClientModel>,
                response: Response<RegisterClientModel>
            ) {

                //val resposeBody = response.body()

                if (response.isSuccessful()) {

                    notifyUser("Conta Criada com sucesso!")
                } else {
                    //Capturar o Erro e mostra para o usuario futuro
                    notifyUser("Erro ao cadastrar")
                }


                //goToHome()
            }

            override fun onFailure(call: Call<RegisterClientModel>, t: Throwable) {

                notifyUser("Ops! Não foi possivel fazer a conexão.")
                Log.e("ERRO_CONEXAO", t.message.toString())
            }
        })
    }
}