package com.example.joblink.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class PublicationModel(
    @SerializedName("id")
    var id: Long,
    @SerializedName("title")
    var title: String = "",
    @SerializedName("profission")
    var profission: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("datePublication")
    var datePublication: String = "",
    @SerializedName("urlImage")
    var urlImage: String = "",
    @SerializedName("urgency")
    var urgency: Int = 0,
    @SerializedName("attendance")
    var attendance: Int = 0,
    @SerializedName("is_announcement")
    var is_announcement: Int = 1,
    @SerializedName("freelancerNote")
    var freelancerNote: Float = 1.0f,
    @SerializedName("User")
    var user : User,
    @SerializedName("Categories")
    var categories: List<CategoryModel>

)
//
//"name": "Matheus Henrique S. S",
//"email": "matheus@henrique.com.br",
//"gender": "Masculino",
//"password": "$2a$10$uXAzOb8LKcfXMZSQpD2r0e/IIclU.cO81DmPDcl0luALGNlz.5zuG",
//"birth_date": "04/04/1974",
//"cpf": "47230647814",
//"banned": false,
//"suspended": false,
//"is_freelancer": false,
//"agreed_policy": true,
//"address"