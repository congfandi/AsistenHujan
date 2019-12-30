package com.thengoding.asistenhujan.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import com.thengoding.asistenhujan.api.ApiClient
import com.thengoding.asistenhujan.api.ApiService
import com.thengoding.asistenhujan.helpers.API_KEY
import com.thengoding.asistenhujan.models.current.CurrentData
import com.thengoding.asistenhujan.models.current.CurrentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrentViewModel : ViewModel() {

    private val currentData = MutableLiveData<CurrentData>()

    internal fun loadData() {
        val apiService = ApiClient.config()?.create(ApiService::class.java)
        val request = apiService?.current("-6.915222", "107.6807272", API_KEY)
        request?.enqueue(object : Callback<CurrentResponse> {
            override fun onFailure(call: Call<CurrentResponse>, t: Throwable) {
                Log.e("gagal cuy", t.toString())
            }

            override fun onResponse(
                call: Call<CurrentResponse>,
                response: Response<CurrentResponse>
            ) {
                Log.e("sukses cuy", "${response.body()?.toString()}")
                currentData.postValue(response.body()?.data?.get(0))
            }

        })
    }

    internal fun getData(): LiveData<CurrentData> {
        return currentData
    }
}