package com.example.joblink.model

import com.google.gson.annotations.SerializedName

data class CategoryModel(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var nameCategory: String
)