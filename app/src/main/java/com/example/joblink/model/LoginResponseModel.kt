package com.example.joblink.model

import com.google.gson.annotations.SerializedName


data class LoginResponseModel(
    @SerializedName("client")
    var client: User,
    var freelancer: User,
    @SerializedName("token")
    var token: String
)

data class User(
    @SerializedName("id")
    var id: Long,
    @SerializedName("name")
    var name: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("birth_date")
    var birthDate: String,
    @SerializedName("cpf")
    var cpf: String,
    @SerializedName("is_freelancer")
    var isFreelancer: Long
)

