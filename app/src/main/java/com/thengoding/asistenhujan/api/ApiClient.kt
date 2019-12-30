package com.thengoding.asistenhujan.api

import com.google.gson.GsonBuilder
import com.thengoding.asistenhujan.helpers.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        private var gson = GsonBuilder()
            .setLenient()
            .create()

        private var retrofit: Retrofit? = null

        fun config(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit
        }
    }
}