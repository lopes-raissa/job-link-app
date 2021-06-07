package com.example.joblink.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.joblink.R
import com.example.joblink.api.Calls.ClientRegisterCall
import com.example.joblink.api.RetrofitApi
import com.example.joblink.api.SessionManager
import com.example.joblink.model.RegisterClientModel
import retrofit2.http.Body


lateinit var btnPhotoFreelancer: Button
lateinit var imagePhoto: ImageView
lateinit var emailRegister: EditText
lateinit var passwordRegister: EditText
lateinit var nameRegister: EditText
lateinit var addressRegister: EditText
lateinit var birthDateRegister: EditText
lateinit var cpfRegister: EditText
lateinit var sessionManager: SessionManager

private var uriImage: Uri? = null

class ClientRegisterActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_client)

        loadData()


    }

    private fun loadData() {
        btnPhotoFreelancer = findViewById(R.id.btn_photo)
        imagePhoto = findViewById(R.id.iv_photo_register)
        emailRegister = findViewById(R.id.et_email_address)
        passwordRegister = findViewById(R.id.et_password)
        nameRegister = findViewById(R.id.et_name)
        addressRegister = findViewById(R.id.et_postal_address)
        birthDateRegister = findViewById(R.id.et_birth_date)
        cpfRegister = findViewById(R.id.et_cpf)

        btnPhotoFreelancer.setOnClickListener(this)
        sessionManager = SessionManager(this)
    }


    override fun onClick(v: View?) {

        if (v!! == btnPhotoFreelancer) {
            selectPhotoGalery()
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

    fun registered() {
        val userRegister = RegisterClientModel(
            id = 1,
            name = nameRegister.text.toString(),
            email = emailRegister.text.toString(),
            cpf = cpfRegister.text.toString(),
            password = passwordRegister.text.toString(),
            address = addressRegister.text.toString(),
            birthDate = birthDateRegister.text.toString(),
            gender = "M"
        )

        val retrofit = RetrofitApi.getRetrofit(ClientRegisterCall::class.java, this)
        val call = retrofit.postRegisterClient()


    }

}