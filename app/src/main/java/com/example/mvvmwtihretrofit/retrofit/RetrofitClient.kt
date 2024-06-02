package com.example.mvvmwtihretrofit.retrofit


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private const val BASE_URL = "https://fakestoreapi.com/"
    private val retrofitClient: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }
    val api: ApiIterface by lazy {
        retrofitClient.build().create(ApiIterface::class.java)
    }
}