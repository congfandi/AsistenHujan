/*
 * Asisten Hujan
 * MainViewModel.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thengoding.cuacaku.api.ApiClient
import com.thengoding.cuacaku.api.ApiService
import com.thengoding.cuacaku.helpers.API_KEY
import com.thengoding.cuacaku.helpers.LANGUAGE
import com.thengoding.cuacaku.helpers.SharePreferenceHelper
import com.thengoding.cuacaku.models.current.CurrentData
import com.thengoding.cuacaku.models.current.CurrentResponse
import com.thengoding.cuacaku.models.daily.DailyData
import com.thengoding.cuacaku.models.daily.DailyResponse
import com.thengoding.cuacaku.models.hourly.HourlyData
import com.thengoding.cuacaku.models.hourly.HourlyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val currentData = MutableLiveData<CurrentData>()
    private val hourlyData = MutableLiveData<List<HourlyData>>()
    private val dailyData = MutableLiveData<List<DailyData>>()
    private lateinit var queries: List<String>

    internal fun loadCurrent(context: Context) {
        val location = SharePreferenceHelper(context).getLocation()
        queries = listOf(location[0],location[1], API_KEY, LANGUAGE)
        val apiService = ApiClient.config()?.create(ApiService::class.java)
        val request = apiService?.current(queries[0], queries[1], queries[2], queries[3])
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

    internal fun getCurrent(): LiveData<CurrentData> {
        return currentData
    }

    internal fun loadHourly(context: Context) {
        val location = SharePreferenceHelper(context).getLocation()
        queries = listOf(location[0],location[1], API_KEY, LANGUAGE)
        val apiService = ApiClient.config()?.create(ApiService::class.java)
        val request = apiService?.hourly(queries[0], queries[1], queries[2], queries[3])
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

    internal fun loadDaily(context: Context) {
        val location = SharePreferenceHelper(context).getLocation()
        queries = listOf(location[0],location[1], API_KEY, LANGUAGE)
        val apiService = ApiClient.config()?.create(ApiService::class.java)
        val request = apiService?.daily(queries[0], queries[1], queries[2], queries[3])
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