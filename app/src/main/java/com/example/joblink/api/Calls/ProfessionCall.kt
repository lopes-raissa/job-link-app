package com.example.joblink.api.Calls

import com.example.joblink.model.ProfissionModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfessionCall {

    @GET("professions")
    fun getProfession(): Call<List<ProfissionModel>>

    @GET("professions/{id}")
    fun getProfessionId(@Path("id") id: Long): Call<List<ProfissionModel>>
}