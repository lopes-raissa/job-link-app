package com.example.joblink.model

import com.google.gson.annotations.SerializedName

data class UserSession(
    @SerializedName("email")
    var email: String = "",
    @SerializedName("password")
    var password: String = ""
)