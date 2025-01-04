package com.example.cicipinapp.repositories

import com.example.cicipinapp.Service.MenuAPIService
import com.example.cicipinapp.models.GeneralResponseModel
import com.example.cicipinapp.models.GetAllMenusResponse
import com.example.cicipinapp.models.GetMenuResponse
import com.example.cicipinapp.models.MenuModelRequest
import retrofit2.Call

interface MenuRepository {
    fun getAllMenus(token: String): Call<GetAllMenusResponse>

    fun createMenu(
        token: String,
        name: String,
        image: String,
        description: String,
        price: String,
        restaurantId: Int
    ): Call<GeneralResponseModel>

    fun getMenubyId(token: String, menuId: Int): Call<GetMenuResponse>

    fun updateMenu(
        token: String,
        menuId: Int,
        name: String,
        image: String,
        description: String,
        price: String,
        restaurantId: Int
    ): Call<GeneralResponseModel>

    fun deleteMenu(token: String, menuId: Int): Call<GeneralResponseModel>
}

class NetworkMenuRepository(
    private val menuAPIService: MenuAPIService
) : MenuRepository {
    override fun getAllMenus(token: String): Call<GetAllMenusResponse> {
        return menuAPIService.getAllMenus(token)
    }

    override fun createMenu(
        token: String,
        name: String,
        image: String,
        description: String,
        price: String,
        restaurantId: Int
    ): Call<GeneralResponseModel> {
        return menuAPIService.createMenu(
            token,
            MenuModelRequest(name, image, description, price, restaurantId)
        )
    }

    override fun getMenubyId(token: String, menuId: Int): Call<GetMenuResponse> {
        return menuAPIService.getMenubyId(token, menuId)
    }

    override fun updateMenu(
        token: String,
        menuId: Int,
        name: String,
        image: String,
        description: String,
        price: String,
        restaurantId: Int
    ): Call<GeneralResponseModel> {
        return menuAPIService.updateMenu(
            token,
            menuId,
            MenuModelRequest(name, image, description, price, restaurantId)
        )
    }

    override fun deleteMenu(token: String, menuId: Int): Call<GeneralResponseModel> {
        return menuAPIService.deleteMenu(token, menuId)
    }
}