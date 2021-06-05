package com.example.joblink.api.Calls

import com.example.joblink.model.PublicationModel
import com.example.joblink.model.UserLoginModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface FeedCall {

    @GET("feed")
    fun getPublication(): Call<List<PublicationModel>>
}