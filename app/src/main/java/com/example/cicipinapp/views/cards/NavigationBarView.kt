package com.example.cicipinapp.views.cards

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
import com.example.cicipinapp.views.RestaurantView
import com.example.cicipinapp.views.ReviewView
import com.example.cicipinapp.views.WishlistView

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf("Home", "Wishlist", "Restaurant", "Review")
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
                    navController.navigate(item) // Navigate to selected page
                },
                icon = {
                    Icon(
                        imageVector = icons[index],
                        contentDescription = item,
                        tint = if (selectedItem == index) activeColor else inactiveColor
                    )
                },
                label = {
                    Text(
                        text = item,
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
        startDestination = "Home",
        modifier = modifier
    ) {
        composable("Home") { HomeView() }
        composable("Wishlist") { WishlistView() }
        composable("Restaurant") { RestaurantView() }
        composable("Review") { ReviewView() }
    }
}