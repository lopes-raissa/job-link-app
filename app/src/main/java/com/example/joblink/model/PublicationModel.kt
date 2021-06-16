package com.example.joblink.model

import com.google.gson.annotations.SerializedName

data class PublicationModel(
    @SerializedName("id")
    var id: Long,
    @SerializedName("title")
    var title: String = "",
    @SerializedName("profission")
    var profission: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("createdAt")
    var datePublication: String = "",
    @SerializedName("image")
    var image: String = "",
    @SerializedName("urgency")
    var urgency: Int = 0,
    @SerializedName("attendance")
    var attendance: Boolean,
    @SerializedName("is_announcement")
    var is_announcement: Int = 1,
    @SerializedName("freelancerNote")
    var freelancerNote: Float = 1.0f,
    @SerializedName("User")
    var userModel : UserModel
    //@SerializedName("Categories")
    //var categories: ProfissionModel

)

