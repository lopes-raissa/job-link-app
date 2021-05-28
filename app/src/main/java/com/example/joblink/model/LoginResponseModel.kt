package com.example.joblink.model

import com.google.gson.annotations.SerializedName


data class LoginResponseModel(
    @SerializedName("client")
    var client: User,
    @SerializedName("token")
    var token: String
)

data class User(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("birth_date")
    var birth_date: String,
    @SerializedName("cpf")
    var cpf: String
)
