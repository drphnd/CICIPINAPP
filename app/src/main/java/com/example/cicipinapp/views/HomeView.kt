package com.example.cicipinapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.example.cicipinapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    var searchText by remember { mutableStateOf("") }
    Scaffold(

    ) { innerPadding ->
        // Content area
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            // Header with greeting and circular image
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(13.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 11.dp)
                        .padding(12.dp)
                ) {
                    Row {
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            "Hello,",
                            color = Color.Black,
                            fontWeight = FontWeight.W900,
                            fontSize = 35.sp
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            "drphnd !",
                            color = Color(0xFFFFB700),
                            fontWeight = FontWeight.Bold,
                            fontSize = 35.sp
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "Circular Image",
                            modifier = Modifier
                                .size(45.dp) // Ukuran lingkaran
                                .clip(CircleShape) // Membuat gambar menjadi bulat
                                .border(2.dp, Color.Red, CircleShape), // Opsional: menambahkan border merah
                            contentScale = ContentScale.Crop // Memotong gambar agar sesuai dengan lingkaran
                        )
                    }
                }

                // Search TextField
                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    placeholder = { Text("Search Restaurant", color = Color.Gray) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search, // Ikon pencarian
                            contentDescription = "Search Icon",
                            tint = Color.Gray
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .height(50.dp) // Tinggi TextField
                        .clip(RoundedCornerShape(28.dp)) // Membuat sudut membulat
                        .background(Color(0xFFF5F5F5)), // Warna latar belakang
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent, // Transparan agar background manual bisa terlihat
                        unfocusedIndicatorColor = Color.Transparent, // Menghilangkan garis bawah default
                        focusedIndicatorColor = Color.Transparent // Menghilangkan garis bawah default
                    ),
                    singleLine = true // Membatasi hanya satu baris
                )
            }

            // Content for Fusion Foods or additional content here


            Spacer(modifier = Modifier.height(16.dp))
            
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomePreview() {
    HomeView()
}
