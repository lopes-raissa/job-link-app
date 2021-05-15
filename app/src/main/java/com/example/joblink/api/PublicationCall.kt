package com.example.joblink.api

import com.example.joblink.model.PublicationModel
import retrofit2.Call
import retrofit2.http.GET




interface PublicationCall {

    @GET("feed")
    fun getPublication() : Call<List<PublicationModel>>
}