package com.example.cicipinapp.Service

import retrofit2.http.GET
import retrofit2.http.Query

interface RoutingService {
    @GET("v2/directions/driving-car")
    suspend fun getDirections(
        @Query("api_key") apiKey: String,
        @Query("start") start: String,
        @Query("end") end: String
    ): DirectionsResponse
}
