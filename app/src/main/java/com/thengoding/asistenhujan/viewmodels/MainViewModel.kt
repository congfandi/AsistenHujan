/*
 * Asisten Hujan
 * MainViewModel.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.asistenhujan.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thengoding.asistenhujan.api.ApiClient
import com.thengoding.asistenhujan.api.ApiService
import com.thengoding.asistenhujan.helpers.API_KEY
import com.thengoding.asistenhujan.helpers.LANGUAGE
import com.thengoding.asistenhujan.models.current.CurrentData
import com.thengoding.asistenhujan.models.current.CurrentResponse
import com.thengoding.asistenhujan.models.daily.DailyData
import com.thengoding.asistenhujan.models.daily.DailyResponse
import com.thengoding.asistenhujan.models.hourly.HourlyData
import com.thengoding.asistenhujan.models.hourly.HourlyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val currentData = MutableLiveData<CurrentData>()
    private val hourlyData = MutableLiveData<List<HourlyData>>()
    private val dailyData = MutableLiveData<List<DailyData>>()

    internal fun loadData() {
        val apiService = ApiClient.config()?.create(ApiService::class.java)
        val request = apiService?.current("-6.915222", "107.6807272", API_KEY, LANGUAGE)
        request?.enqueue(object : Callback<CurrentResponse> {
            override fun onFailure(call: Call<CurrentResponse>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<CurrentResponse>,
                response: Response<CurrentResponse>
            ) {
                currentData.postValue(response.body()?.data?.get(0))
            }

        })
    }

    internal fun getData(): LiveData<CurrentData> {
        return currentData
    }

    internal fun loadHourly() {
        val apiService = ApiClient.config()?.create(ApiService::class.java)
        val request = apiService?.hourly("-6.915222", "107.6807272", API_KEY, LANGUAGE)
        request?.enqueue(object : Callback<HourlyResponse> {
            override fun onFailure(call: Call<HourlyResponse>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<HourlyResponse>,
                response: Response<HourlyResponse>
            ) {
                hourlyData.postValue(response.body()?.data?.subList(0, 5))
            }

        })
    }

    internal fun getHourly(): LiveData<List<HourlyData>> {
        return hourlyData
    }

    internal fun loadDaily() {
        val apiService = ApiClient.config()?.create(ApiService::class.java)
        val request = apiService?.daily("-6.915222", "107.6807272", API_KEY, LANGUAGE)
        request?.enqueue(object : Callback<DailyResponse> {
            override fun onFailure(call: Call<DailyResponse>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<DailyResponse>,
                response: Response<DailyResponse>
            ) {
                dailyData.postValue(response.body()?.data?.subList(1, 7))
            }

        })
    }

    internal fun getDaily(): LiveData<List<DailyData>> {
        return dailyData
    }
}