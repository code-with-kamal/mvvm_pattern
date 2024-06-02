package com.example.mvvmwtihretrofit.repository


import com.example.mvvmwtihretrofit.modal.ProductData
import com.example.mvvmwtihretrofit.retrofit.RetrofitClient
import retrofit2.Response


object RepositoryRetrofit {


    suspend fun getUser():Response<ProductData>{
        return RetrofitClient.api.getUser()
    }








//    fun getUser(): MutableLiveData<ArrayList<ProductData>> {
//        val resultLiveData = MutableLiveData<ResultRes<ProductData>>()
//        resultLiveData.value = ResultRes.Loading
//        val call = RetrofitClient.api.getUser()
//        call.enqueue(object : Callback<ProductData> {
//            override fun onResponse(call: Call<ProductData>, response: Response<ProductData>) {
//                println("RepositoryRetrofit.onResponse  ${response.body()}")
//                if (response.isSuccessful) {
//                    val data = response.body()
//                    resultLiveData.postValue(ResultRes.Success())
//                }
//            }
//
//            override fun onFailure(call: Call<ProductData>, t: Throwable) {
//                println("RepositoryRetrofit.onFailure   ${t.message}")
//            }
//
//        })
//        return dataList
//    }

}