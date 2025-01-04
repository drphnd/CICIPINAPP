package com.example.cicipinapp.Service

import retrofit2.http.GET

interface RoutingService {
    @GET("v2/directions/driving-car")
    suspend fun getDirections(
        @retrofit2.http.Query("api_key") apiKey: String,
        @retrofit2.http.Query("start") start: String,
        @retrofit2.http.Query("end") end: String
    ): DirectionsResponse
}
