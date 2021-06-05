package com.example.joblink.model

import com.google.gson.annotations.SerializedName

class RegisterClientModel(
    var id: Long,
    var name: String,
    var gender: String,
    @SerializedName("birth_date")
    var birthDate: String,
    var email: String,
    var cpf: Int,
    var password: String,
    var address: String
)
