package com.example.joblink.model

import com.google.gson.annotations.SerializedName

data class FreelancerModel(
    @SerializedName("id")
    var id: Long,
    @SerializedName("name")
    var name: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("birth_date")
    var birthDate: String,
    @SerializedName("phone_number")
    var PhoneNumber: String,
    var image: String ? = "",
    var gender: String,
    var address: String,
    @SerializedName("cpf")
    var cpf: String,
    @SerializedName("is_freelancer")
    var isFreelancer: Long
)

