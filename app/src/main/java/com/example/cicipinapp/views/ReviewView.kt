package com.example.cicipinapp.views

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicipinapp.views.cards.ReviewCard

@Composable
fun ReviewView() {
    var selectedTab by remember { mutableStateOf("Review") }
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
                Text(text = "My Reviews",
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            val reviews = List(10){it}
            items(reviews){
                ReviewCard()
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ReviewPreview() {
    ReviewView()
}