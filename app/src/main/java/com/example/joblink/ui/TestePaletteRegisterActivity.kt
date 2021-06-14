package com.example.joblink.ui

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.palette.graphics.Palette
import com.example.joblink.R
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton


lateinit var btnSelected: FloatingActionButton
lateinit var ivPhoto: ImageView
lateinit var toolbarFreelancer: Toolbar
lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
private var uriImage: Uri? = null

class FreelancerRegisterActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pallete_activity_freelancer_register)

//        btnPhotoFreelancer = findViewById(R.id.selected_photo)
        imagePhoto = findViewById(R.id.iv_photo)
        toolbarFreelancer = findViewById(R.id.toolbar)
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar)

        btnPhotoFreelancer.setOnClickListener(this)

        insertToolbar()
         loadPalette()
    }

    private fun loadPalette() {

        val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.add_photo)
        Palette.from(bitmap).generate { palette ->
            if (palette != null) {
                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(R.attr.colorPrimary))
            }
        }
    }

    override fun onClick(v: View?) {

        if (v!! == btnPhotoFreelancer) {
            selectPhotoGalery()
        }
    }

    private fun insertToolbar() {
        setSupportActionBar(toolbarFreelancer)
        supportActionBar!!.title = "Cadastro de Freelancer"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        onBackPressed()
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 0 && data != null) {
                uriImage = data.data
                // btnSelected.getBackground().setAlpha(0)
                // btnSelected.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0)
                imagePhoto.setImageURI(uriImage)
            }
        }
    }

     fun selectPhotoGalery() {
        var intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        intent.setType("image/*")

        startActivityForResult(Intent.createChooser(intent, "Escolha uma imagem"), 0)
    }
}