package com.example.joblink.model

import com.google.gson.annotations.SerializedName

data class ProfessionModel(
    @SerializedName("id")
    var id: Long,
    @SerializedName("name")
    var nameProfession: String
)