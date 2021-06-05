package com.example.joblink.model

import com.google.gson.annotations.SerializedName

data class ProfissionModel(
    @SerializedName("id")
    var id: Long,
    @SerializedName("name")
    var nameProfession: String
)