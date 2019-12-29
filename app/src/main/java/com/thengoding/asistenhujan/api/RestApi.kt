package com.thengoding.asistenhujan.api

import io.reactivex.Observable
import retrofit2.http.GET


interface RestApi {
    @GET("data/2.5/weather")
    fun weather(lat:String,long:String) : Observable<String>
}