package com.example.cicipinapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
<<<<<<< Updated upstream:app/src/main/java/com/example/cicipinapp/views/RestoRecommendation.kt
import androidx.compose.foundation.border
=======
import androidx.compose.foundation.clickable
>>>>>>> Stashed changes:app/src/main/java/com/example/cicipinapp/views/RestoRecommendationView.kt
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cicipinapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestoRecommendationView(navController: NavController) {
    Scaffold(
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(19.dp),

            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = "Back Icon",
                    modifier = Modifier
                        .size(24.dp) // Ukuran ikon
                        .clip(CircleShape) // Membuat gambar menjadi bulat (opsional untuk ikon back)
                        .clickable {
                            // Logika Back
                            navController.popBackStack()
                        }
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Recommendation",
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
//            Masukkin Resto Card Recommendation disini
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RestoRecommendationPreview() {
    RestoRecommendationView(navController = rememberNavController())
}