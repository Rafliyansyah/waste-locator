package com.rafliyansyahismail.wastelocator.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rafliyansyahismail.wastelocator.ui.navigation.Screen
import com.rafliyansyahismail.wastelocator.ui.theme.GreenPrimary

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // HEADER ILUSTRASI
            Box(
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 24.dp)
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(32.dp))
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color(0xFFE0F2F1),
                                Color(0xFFE1F5FE)
                            )
                        )
                    )
            ) {
                // dua lingkaran sebagai dekorasi (mirip Figma)
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .offset(x = 32.dp, y = 30.dp)
                        .background(Color(0xFF81C784), CircleShape)
                )
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .offset(x = 220.dp, y = 40.dp)
                        .background(Color(0xFF81D4FA), CircleShape)
                )
            }

            // TEXT JUDUL
            Text(
                text = "Welcome Back",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            )

            Text(
                text = "Sign in to continue managing waste",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Gray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )

            // EMAIL
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                leadingIcon = {
                    Icon(Icons.Outlined.Email, contentDescription = null)
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            )

            // PASSWORD
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                leadingIcon = {
                    Icon(Icons.Outlined.Lock, contentDescription = null)
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            )

            // TOMBOL LOGIN
            Button(
                onClick = {
                    // sementara langsung ke dashboard (akan kita buat setelah ini)
                    navController.navigate(Screen.Dashboard.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenPrimary
                )
            ) {
                Text("Log In")
            }

            // TOMBOL CREATE ACCOUNT
            OutlinedButton(
                onClick = { /* TODO: ke screen register */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(top = 12.dp),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text("Create an Account")
            }

            TextButton(
                onClick = {
                    navController.navigate(Screen.Dashboard.route)
                },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = "Continue as Guest",
                    color = Color(0xFF1E88E5),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp
                )
            }
        }
    }
}
