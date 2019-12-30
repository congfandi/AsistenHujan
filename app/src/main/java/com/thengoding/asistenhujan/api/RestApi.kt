package com.thengoding.asistenhujan.api

import com.thengoding.asistenhujan.models.current.CurrentData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


interface RestApi {
    @GET("current")
    fun current(@Path("lat") lat: String, @Path("lon") lon: String): Observable<CurrentData>
}