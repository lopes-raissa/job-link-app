package com.example.joblink.api.Calls

import com.example.joblink.model.FreelancerModel
import com.example.joblink.model.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface FreelancersCall {

    @GET("/freelancers")
    fun getFreelancers() : Call<List<FreelancerModel>>
}