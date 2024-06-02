package com.example.mvvmwtihretrofit.viewmodal


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwtihretrofit.errorhandling.ResultRes
import com.example.mvvmwtihretrofit.modal.ProductData
import com.example.mvvmwtihretrofit.repository.RepositoryRetrofit
import kotlinx.coroutines.launch



class MyViewModal : ViewModel() {
    private val repository = RepositoryRetrofit

    fun getuserViewModel(): MutableLiveData<ResultRes<ProductData>> {
        val resultLiveData = MutableLiveData<ResultRes<ProductData>>()
        resultLiveData.value = ResultRes.Loading
        viewModelScope.launch {
            try {
                val data = repository.getUser()
                if (data.isSuccessful){
                    resultLiveData.postValue(ResultRes.Success(data.body()!!))
                }
                else{
                    resultLiveData.postValue(ResultRes.Error(" Some Error found.."))

                }
            } catch (e: Exception) {
                resultLiveData.postValue(ResultRes.Error(e.message!!))
            }
        }
        return resultLiveData
    }

}