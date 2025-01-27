package com.example.cicipinapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cicipinapp.views.HomeView
import com.example.cicipinapp.views.ProfileSettingView
import com.example.cicipinapp.views.RestaurantView
import com.example.cicipinapp.views.ReviewView
import com.example.cicipinapp.views.SettingView
import com.example.cicipinapp.views.WishlistView

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Screen.Home,
        Screen.Wishlist,
        Screen.Restaurant,
        Screen.Review
    )

    val icons = listOf(
        Icons.Filled.Home,    // Icon for Home
        Icons.Filled.Star,    // Icon for Wishlist
        Icons.Filled.Place,   // Icon for Restaurant
        Icons.Filled.List     // Icon for Review
    )

    val activeColor = Color(0xFFFFC107) // Yellow color for active item
    val inactiveColor = Color.Gray      // Gray color for inactive item

    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar(
        containerColor = Color.White // Set the background color to white
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route) // Use the route from Screen
                },
                icon = {
                    Icon(
                        imageVector = icons[index],
                        contentDescription = item.route,
                        tint = if (selectedItem == index) activeColor else inactiveColor
                    )
                },
                label = {
                    Text(
                        text = item.route.capitalize(),
                        color = if (selectedItem == index) activeColor else inactiveColor
                    )
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) { HomeView(navController = navController) }
        composable(Screen.Wishlist.route) { WishlistView(navController = navController) }
        composable(Screen.Restaurant.route) { RestaurantView(navController = navController) }
        composable(Screen.Review.route) { ReviewView(navController = navController) }
        composable(Screen.RestoRecommendation.route) { RestaurantView(navController = navController) }
        composable(Screen.Setting.route) { SettingView(navController = navController) }
        composable(Screen.ProfileSetting.route) { ProfileSettingView(navController = navController) }
    }
}
