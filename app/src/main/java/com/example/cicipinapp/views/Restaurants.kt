package com.example.cicipinapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicipinapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantView() {
    var selectedTab by remember { mutableStateOf("Find Resto") }
    val items = listOf("Home", "Wishlist", "Find Resto", "Review")
    val icons = listOf(
        Icons.Filled.Home,    // Ikon untuk Home
        Icons.Filled.Star,    // Ikon untuk Wishlist
        Icons.Filled.Place,   // Ikon untuk Find Resto
        Icons.Filled.List     // Ikon untuk Review
    )
    val activeColor = Color(0xFFFFC107) // Warna kuning untuk item aktif
    val inactiveColor = Color.Gray      // Warna abu-abu untuk item tidak aktif
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(19.dp)
            ) {
                Text(text = "Restaurants",
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        bottomBar = {
            // Bottom navigation bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ) {
                items.forEachIndexed { index, item ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Icon(
                            imageVector = icons[index],
                            contentDescription = item,
                            tint = if (selectedTab == item) activeColor else inactiveColor,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = item,
                            fontSize = 12.sp,
                            fontWeight = if (selectedTab == item) FontWeight.Bold else FontWeight.Normal,
                            color = if (selectedTab == item) activeColor else inactiveColor
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
//            Masukkin Random Resto Card disini
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RestaurantPreview() {
    RestaurantView()
}