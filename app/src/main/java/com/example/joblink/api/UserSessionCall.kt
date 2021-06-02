package com.example.joblink.api

import com.example.joblink.model.UserLoginModel
import com.example.joblink.model.LoginResponseModel
import com.example.joblink.model.PublicationModel
import retrofit2.Call
import retrofit2.http.*

interface UserSessionCall {

    @POST("sessions")
    fun login(@Body User: UserLoginModel): Call<LoginResponseModel>
}