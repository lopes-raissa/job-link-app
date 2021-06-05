package com.example.joblink.api.Calls

import com.example.joblink.model.ProfissionModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfessionCall {

    @GET("professions/{id}")
    fun getProfission(@Path("id") id: Long): Call<List<ProfissionModel>>
}