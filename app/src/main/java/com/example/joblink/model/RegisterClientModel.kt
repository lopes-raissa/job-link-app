package com.example.joblink.model

import com.google.gson.annotations.SerializedName

class RegisterClientModel(
    var name: String,
    var gender: String,
    @SerializedName("birth_date")
    var birthDate: String,
    var email: String,
    var cpf: String,
    var password: String,
    var address: String
)