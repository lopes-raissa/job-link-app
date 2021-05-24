package com.example.joblink.model

import com.example.joblink.adapter.PublicationAdapter
import com.google.gson.annotations.SerializedName

class PublicationResponseModel {
    @SerializedName ("id")
    var id: Int = 1
    @SerializedName( "")
    lateinit var posts: List<PublicationAdapter>

}