/*
 * Asisten Hujan
 * ApiClient.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.api

import com.google.gson.GsonBuilder
import com.thengoding.cuacaku.helpers.BASE_URL
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