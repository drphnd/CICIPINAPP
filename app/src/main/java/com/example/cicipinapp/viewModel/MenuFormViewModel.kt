package com.example.cicipinapp.viewModel

//handle create and update

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.cicipinapp.models.GeneralResponseModel
import com.example.cicipinapp.models.MenuModel
import com.example.cicipinapp.repositories.MenuRepository
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MenuFormViewModel(
    private val menuRepository: MenuRepository
) : ViewModel() {

    var menuId by mutableStateOf(-1)
        private set

    var isUpdate by mutableStateOf(false)
        private set

    var nameInput by mutableStateOf("")
        private set

    var imageInput by mutableStateOf("")
        private set

    var descriptionInput by mutableStateOf("")
        private set

    var priceInput by mutableStateOf("")
        private set

    var restaurantIdInput by mutableStateOf(0)
        private set

    var submissionStatus by mutableStateOf<String?>(null)
        private set

    fun changeNameInput(name: String) {
        nameInput = name
    }

    fun changeImageInput(image: String) {
        imageInput = image
    }

    fun changeDescriptionInput(description: String) {
        descriptionInput = description
    }

    fun changePriceInput(price: String) {
        priceInput = price
    }

    fun changeRestaurantIdInput(id: Int) {
        restaurantIdInput = id
    }

    fun resetForm() {
        nameInput = ""
        imageInput = ""
        descriptionInput = ""
        priceInput = ""
        restaurantIdInput = 0
        isUpdate = false
        menuId = -1
        submissionStatus = null
    }

    fun createMenu(token: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            try {
                val call = menuRepository.createMenu(
                    token,
                    nameInput,
                    imageInput,
                    descriptionInput,
                    priceInput,
                    restaurantIdInput
                )
                call.enqueue(object : Callback<GeneralResponseModel> {
                    override fun onResponse(
                        call: Call<GeneralResponseModel>,
                        response: Response<GeneralResponseModel>
                    ) {
                        if (response.isSuccessful) {
                            submissionStatus = "Menu created successfully!"
                            onSuccess()
                            resetForm()
                        } else {
                            submissionStatus = response.message()
                        }
                    }

                    override fun onFailure(call: Call<GeneralResponseModel>, t: Throwable) {
                        submissionStatus = t.localizedMessage
                    }
                })
            } catch (e: IOException) {
                submissionStatus = e.localizedMessage
            }
        }
    }

    fun updateMenu(token: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            try {
                val call = menuRepository.updateMenu(
                    token,
                    menuId,
                    nameInput,
                    imageInput,
                    descriptionInput,
                    priceInput,
                    restaurantIdInput
                )
                call.enqueue(object : Callback<GeneralResponseModel> {
                    override fun onResponse(
                        call: Call<GeneralResponseModel>,
                        response: Response<GeneralResponseModel>
                    ) {
                        if (response.isSuccessful) {
                            submissionStatus = "Menu updated successfully!"
                            onSuccess()
                            resetForm()
                        } else {
                            submissionStatus = response.message()
                        }
                    }

                    override fun onFailure(call: Call<GeneralResponseModel>, t: Throwable) {
                        submissionStatus = t.localizedMessage
                    }
                })
            } catch (e: IOException) {
                submissionStatus = e.localizedMessage
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = ViewModelProvider.Factory {
            MenuFormViewModel(menuRepository = TODO())
        }
    }
}
