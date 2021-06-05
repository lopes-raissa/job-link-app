package com.example.joblink.api.Calls

import com.example.joblink.model.RegisterClientModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ClientRegisterCall {

    @POST("clients")
    fun postRegisterClient(requestBody: Body): Call<RegisterClientModel>
}