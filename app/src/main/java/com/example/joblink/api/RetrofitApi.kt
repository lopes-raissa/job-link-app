package com.example.joblink.api

import android.content.Context
import retrofit2.Retrofit
import com.example.joblink.api.UrlApi.Companion.BASE_URL
import com.example.joblink.fragments.HomeFragment
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitApi {

    companion object {
        fun<T> getRetrofit(clazz: Class<T>, context: Context): T {

            var retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient(context))
                .build()

            return retrofit.create(clazz)
        }

        fun httpClient(context: Context?): OkHttpClient {
            return OkHttpClient.Builder()
                .readTimeout(40, TimeUnit.SECONDS)
                .connectTimeout(40, TimeUnit.SECONDS)
                .addInterceptor(AuthInterceptor(context))
                .build()
        }
    }


//    private lateinit var apiService: UserSessionCall
//
//    fun getApiService(context: Context): UserSessionCall {
//
//        if (!::apiService.isInitialized) {
//            var retrofitClient = Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client(context))
//                .build()
//
//            apiService = retrofitClient.create(UserSessionCall::class.java)
//        }

//        return apiService
//    }

//    private fun client(context: Context): OkHttpClient {
//        return OkHttpClient.Builder()
//            .connectTimeout(10, TimeUnit.SECONDS)
//            .readTimeout(10, TimeUnit.SECONDS)
//            .addInterceptor(AuthInterceptor(context))
//            .build()
//    }
}