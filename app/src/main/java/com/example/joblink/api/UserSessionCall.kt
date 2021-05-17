package com.example.joblink.api

import com.example.joblink.model.LoginRequestModel
import com.example.joblink.model.LoginResponseModel
import com.example.joblink.model.PublicationModel
import com.example.joblink.model.PublicationResponseModel
import retrofit2.Call
import retrofit2.http.*

interface UserSessionCall {

    @POST("sessions")
    fun login(@Body requestModel: LoginRequestModel): Call<LoginResponseModel>

    @GET("feed")
    fun getPublication(): Call<PublicationResponseModel>
}