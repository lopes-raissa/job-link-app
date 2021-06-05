package com.example.joblink.api.Calls

import com.example.joblink.model.UserLoginModel
import com.example.joblink.model.LoginResponseModel
import com.example.joblink.model.PublicationModel
import retrofit2.Call
import retrofit2.http.*

interface UserSessionCall {

    @POST("sessions")
    fun login(@Body user: UserLoginModel): Call<LoginResponseModel>
}