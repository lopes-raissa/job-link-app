package com.example.joblink.api

import android.content.Context
import retrofit2.Retrofit
import com.example.joblink.api.UrlApi.Companion.BASE_URl
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitApi {

    companion object {
        fun getRetrofit() : Retrofit {

            var retrofit = Retrofit.Builder()
                .baseUrl(BASE_URl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient())
                .build()

            return retrofit
        }

        fun okhttpClient(context: Context?): OkHttpClient {

            var retrofitClient = OkHttpClient.Builder()
                .readTimeout(40, TimeUnit.SECONDS)
                .connectTimeout(40, TimeUnit.SECONDS)
                .addInterceptor(AuthInterceptor(context))
                .build()

            return retrofitClient
        }
    }
}