package com.example.cicipinapp.models

import com.google.gson.annotations.SerializedName

data class MenuModel(
    val id: Int = 0,
    val name: String = "",
    val image: String = "",
    val description: String = "",
    val price: String = "",
    val RestaurantsID: Int = 0,
)

data class GetAllMenusResponse(
    val data: List<MenuModel>
)

data class GetMenuResponse(
    val data: MenuModel
)

data class MenuModelRequest(
    val name: String = "",
    val image: String = "",
    val description: String = "",
    val price: String = "",

    @SerializedName("restaurant_id")
    val restaurantId: Int = 0
)
