package com.example.joblink.api

import com.example.joblink.model.UserSession
import retrofit2.Call
import retrofit2.http.GET

interface UserSessionCall {

    @GET("posts")
    fun getUserSession() : Call<List<UserSession>>
}