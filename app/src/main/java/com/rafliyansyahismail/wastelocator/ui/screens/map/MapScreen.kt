package com.rafliyansyahismail.wastelocator.ui.screens.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rafliyansyahismail.wastelocator.ui.components.WasteLocatorBottomBar
import com.rafliyansyahismail.wastelocator.ui.theme.ChipGreen
import com.rafliyansyahismail.wastelocator.ui.theme.ChipGrey
import com.rafliyansyahismail.wastelocator.ui.theme.GreenPrimary

data class TpsItem(
    val name: String,
    val distance: String,
    val hours: String,
    val status: String
)

private val dummyTps = listOf(
    TpsItem("TPS Kebayoran Baru", "1.2 km", "06:00 - 22:00", "Active"),
    TpsItem("TPS Senayan", "2.5 km", "06:00 - 22:00", "Active"),
    TpsItem("TPS Melawai", "3.1 km", "Closed", "Inactive")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(navController: NavController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("TPS Locations") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO filter */ }) {
                        Icon(Icons.Filled.FilterList, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            WasteLocatorBottomBar(navController = navController)
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Map gradient area
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFE8F5E9),
                                Color(0xFFE3F2FD)
                            )
                        )
                    )
            ) {
                MapMarker(modifier = Modifier.align(Alignment.Center))
                MapMarker(modifier = Modifier.align(Alignment.TopEnd).offset((-50).dp, 60.dp))
                MapMarker(modifier = Modifier.align(Alignment.BottomStart).offset(40.dp, (-40).dp))

                // User location
                Box(
                    modifier = Modifier
                        .size(14.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = (-12).dp)
                        .clip(CircleShape)
                        .background(Color(0xFF607D8B))
                )
            }

            // Bottom sheet
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                tonalElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 40.dp, height = 4.dp)
                            .clip(RoundedCornerShape(50))
                            .background(Color(0xFFCFD8DC))
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        "Nearby TPS",
                        modifier = Modifier.padding(horizontal = 16.dp),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(dummyTps) { item ->
                            TpsListItem(item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MapMarker(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(22.dp)
            .clip(CircleShape)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(14.dp)
                .clip(CircleShape)
                .background(GreenPrimary)
        )
    }
}

@Composable
private fun TpsListItem(item: TpsItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(Color(0xFFE8F5E9)),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(18.dp)
                    .clip(CircleShape)
                    .background(GreenPrimary)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(item.name, fontWeight = FontWeight.SemiBold)
            Text(item.distance, fontSize = 12.sp, color = Color.Gray)
            Text(item.hours, fontSize = 12.sp, color = Color.Gray)
        }

        val chipColor = if (item.status == "Active") ChipGreen else ChipGrey

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(chipColor)
                .padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
            Text(item.status, color = Color.White, fontSize = 12.sp)
        }
    }
}
