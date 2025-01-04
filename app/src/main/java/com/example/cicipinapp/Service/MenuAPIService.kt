package com.example.cicipinapp.Service

import com.example.cicipinapp.models.GeneralResponseModel
import com.example.cicipinapp.models.GetAllMenusResponse
import com.example.cicipinapp.models.GetMenuResponse
import com.example.cicipinapp.models.MenuModel
import com.example.cicipinapp.models.MenuModelRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MenuAPIService {
    @GET("api/menu")
    fun getAllMenus(@Header("X-API-TOKEN") token: String): Call<GetAllMenusResponse>

    @GET("api/menu/{id}")
    fun getMenubyId(
        @Header("X-API-STRING") token: String,
        @Path("id") menuId: Int
    ): Call<GetMenuResponse>

    @POST("api/menu")
    fun createMenu(
        @Header("X-API-TOKEN") token: String,
        @Body menuModel: MenuModelRequest
    ): Call<GeneralResponseModel>

    @PUT("api/menu/{id}")
    fun updateMenu(
        @Header("X-API-STRING") token: String,
        @Path("id") menuId: Int,
        @Body menuModel: MenuModelRequest
    ): Call<GeneralResponseModel>

    @DELETE("api/menu/{id}")
    fun deleteMenu(
        @Header("X-API-STRING") token: String,
        @Path("id") menuId: Int
    ): Call<GeneralResponseModel>
}