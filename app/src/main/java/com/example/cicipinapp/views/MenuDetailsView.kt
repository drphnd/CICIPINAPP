package com.example.cicipinapp.views

import android.annotation.SuppressLint
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicipinapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun MenuDetailsView() {
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var menuName by remember { mutableStateOf(TextFieldValue("")) }
    var menuDescription by remember { mutableStateOf(TextFieldValue("")) }

    // Launcher untuk memilih foto dari galeri
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(19.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "Circular Image",
                modifier = Modifier
                    .size(24.dp) // Ukuran lingkaran
                    .clip(CircleShape) // Membuat gambar menjadi bulat
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Add Menu   ",
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            Text(
                text = "Insert Image Menu",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )

            Spacer(Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.LightGray)
                    .height(140.dp)
                    .clickable { launcher.launch("image/*") },
                contentAlignment = Alignment.Center

            ) {
                if (selectedImageUri != null) {
                    Image(
                        painter = painterResource(R.drawable.baseline_upload_file_24),
                        contentDescription = "Selected Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "Upload Icon",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
        Spacer(Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            Text(
                text = "Menu Name",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )

            Spacer(Modifier.height(10.dp))

            TextField(
                value = menuName,
                onValueChange = { menuName = it },
                label = { Text("Menu Name ") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(18.dp)),

                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent, // Menghilangkan warna default dari TextField
                    unfocusedIndicatorColor = Color.Transparent, // Menghilangkan garis hitam saat tidak fokus
                    focusedIndicatorColor = Color.Transparent // Menghilangkan garis hitam saat fokus
                )
            )

        }

        Spacer(Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            Text(
                text = "Menu Description",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )

            Spacer(Modifier.height(10.dp))

            TextField(
                value = menuDescription,
                onValueChange = { menuDescription = it },
                label = { Text("Menu Description") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(18.dp)),

                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent, // Menghilangkan warna default dari TextField
                    unfocusedIndicatorColor = Color.Transparent, // Menghilangkan garis hitam saat tidak fokus
                    focusedIndicatorColor = Color.Transparent // Menghilangkan garis hitam saat fokus
                )
            )

        }

        Spacer(Modifier.height(16.dp))

        
        Button(
            onClick = { /* Handle submit action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            shape = RoundedCornerShape(24.dp), // Membuat tombol dengan sudut membulat
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(40.dp) // Menentukan tinggi tombol

        ) {
            Text(
                text = "Submit",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun MenuDetailsPreview() {
    MenuDetailsView()
}