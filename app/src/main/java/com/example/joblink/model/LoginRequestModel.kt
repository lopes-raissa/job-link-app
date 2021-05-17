package com.example.joblink.model

import com.google.gson.annotations.SerializedName

data class LoginRequestModel(
    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password: String
)