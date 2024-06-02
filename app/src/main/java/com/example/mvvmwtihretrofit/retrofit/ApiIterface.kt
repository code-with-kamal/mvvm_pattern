package com.example.mvvmwtihretrofit.retrofit

import com.example.mvvmwtihretrofit.modal.ProductData
import retrofit2.Response
import retrofit2.http.GET

interface ApiIterface {
    @GET("products")
     suspend fun getUser(): Response<ProductData>

}