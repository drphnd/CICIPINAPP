package com.example.cicipinapp.views

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cicipinapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterView(){
    var text by remember { mutableStateOf("") }
    var profileImageUri by remember { mutableStateOf<Uri?>(null) }

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    // Launcher untuk memilih foto dari galeri
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }


    Column(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    Image(
        painter = painterResource(R.drawable.cicipinlogo),
        contentDescription = "Logo",
        modifier = Modifier
            .size(270.dp)
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
                    .clickable { launcher.launch("image/*") },
                contentAlignment = Alignment.Center
            ) {
                if (selectedImageUri != null) {
                    // Gambar yang dipilih
                    Image(
                        painter = painterResource(R.drawable.baseline_upload_file_24),
                        contentDescription = "Selected Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    // Placeholder (jika belum ada gambar)
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "Upload Icon",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }

            // Tombol Unggah
            Button(
                onClick = { launcher.launch("image/*") },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(0.5f),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Pilih Foto")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter Text") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .border(1.dp, Color.Red, shape = RoundedCornerShape(18.dp)),

            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Menghilangkan warna default dari TextField
                unfocusedIndicatorColor = Color.Transparent, // Menghilangkan garis hitam saat tidak fokus
                focusedIndicatorColor = Color.Transparent // Menghilangkan garis hitam saat fokus
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter Text") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .border(1.dp, Color.Red, shape = RoundedCornerShape(18.dp)),

            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Menghilangkan warna default dari TextField
                unfocusedIndicatorColor = Color.Transparent, // Menghilangkan garis hitam saat tidak fokus
                focusedIndicatorColor = Color.Transparent // Menghilangkan garis hitam saat fokus
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle login action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            shape = RoundedCornerShape(24.dp), // Membuat tombol dengan sudut membulat
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(48.dp) // Menentukan tinggi tombol
        ) {
            Text(
                text = "Register",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }





}
}

@Preview(showBackground = true)
@Composable
private fun RegisterPreview(){
    RegisterView()
}