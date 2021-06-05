package com.example.joblink.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.joblink.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


lateinit var btnPhoto: FloatingActionButton
lateinit var imagePhoto: ImageView
private var uriImage: Uri? = null

class ClientRegisterActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_client)

        btnPhoto = findViewById(R.id.btn_photo)
        imagePhoto = findViewById(R.id.iv_photo_register)

        btnPhoto.setOnClickListener(this)

    }


    override fun onClick(v: View?) {

        if (v!! == btnPhoto) {
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

}