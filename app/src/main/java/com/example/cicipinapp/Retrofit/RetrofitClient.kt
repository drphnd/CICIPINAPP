package com.example.cicipinapp.Retrofit

import com.example.cicipinapp.Service.RoutingService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.openrouteservice.org/"

    val instance: RoutingService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RoutingService::class.java)
    }
}
