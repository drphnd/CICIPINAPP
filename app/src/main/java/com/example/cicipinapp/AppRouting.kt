package com.example.cicipinapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cicipinapp.views.HomeView
import com.example.cicipinapp.navigation.Screen
import com.example.cicipinapp.navigation.BottomNavigationBar
import com.example.cicipinapp.views.ProfileSettingView
import com.example.cicipinapp.views.RestaurantView
import com.example.cicipinapp.views.RestoRecommendationView
import com.example.cicipinapp.views.ReviewView
import com.example.cicipinapp.views.SettingView
import com.example.cicipinapp.views.WishlistView

@Composable
fun AppRouting() {
    val navController = rememberNavController() // Create a navigation controller

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) } // Pass navController here
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route, // Set the starting screen
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeView(navController) // Pass the navController to HomeView
            }
            composable(Screen.Wishlist.route) {
                WishlistView(navController) // Screen to navigate to
            }
            composable(Screen.Restaurant.route) {
                RestaurantView(navController) // Screen to navigate to
            }
            composable(Screen.Review.route) {
                ReviewView(navController) // Screen to navigate to
            }
            composable(Screen.RestoRecommendation.route) {
                RestoRecommendationView(navController) // Screen to navigate to
            }
            composable(Screen.Setting.route) {
                SettingView(navController) // Screen to navigate to
            }
            composable(Screen.ProfileSetting.route) {
                ProfileSettingView(navController) // Screen to navigate to
            }
        }
    }
}
//test
