package com.example.joblink.api

import android.content.Context
import retrofit2.Retrofit
import com.example.joblink.api.UrlApi.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitApi {

    private lateinit var apiService: UserSessionCall

    fun getApiService(context: Context): UserSessionCall {

        if (!::apiService.isInitialized) {
            var retrofitClient = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient(context))
                .build()

            apiService = retrofitClient.create(UserSessionCall::class.java)
        }

        return apiService
    }

    private fun client(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(AuthInterceptor(context))
            .build()
    }
}