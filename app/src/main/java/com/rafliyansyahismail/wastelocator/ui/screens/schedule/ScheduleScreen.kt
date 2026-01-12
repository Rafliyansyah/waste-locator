package com.rafliyansyahismail.wastelocator.ui.screens.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocalShipping
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rafliyansyahismail.wastelocator.ui.components.WasteLocatorBottomBar
import com.rafliyansyahismail.wastelocator.ui.theme.*

data class ScheduleItem(
    val tps: String,
    val time: String,
    val status: String
)

private val byTpsData = listOf(
    ScheduleItem("TPS Kebayoran Baru", "08:00 - 10:00", "Today"),
    ScheduleItem("TPS Senayan", "14:00 - 16:00", "Today"),
    ScheduleItem("TPS Melawai", "07:00 - 09:00", "Tomorrow"),
    ScheduleItem("TPS Blok M", "15:00 - 17:00", "Tomorrow"),
    ScheduleItem("TPS Senayan", "09:00 - 11:00", "Friday")
)

private val byLocationData = listOf(
    ScheduleItem("Near Your Location", "07:30 - 09:00", "Today"),
    ScheduleItem("Backup Route", "16:00 - 18:00", "This Week")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen(navController: NavController) {

    var selectedTab by remember { mutableStateOf(0) }

    val data = if (selectedTab == 0) byTpsData else byLocationData

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Collection Schedule") }
            )
        },
        bottomBar = { WasteLocatorBottomBar(navController) }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            // Segmented Buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color(0xFFF1F1F1), RoundedCornerShape(50))
            ) {
                SegmentButton(
                    text = "By TPS",
                    selected = selectedTab == 0,
                    modifier = Modifier.weight(1f)
                ) { selectedTab = 0 }

                SegmentButton(
                    text = "By My Location",
                    selected = selectedTab == 1,
                    modifier = Modifier.weight(1f)
                ) { selectedTab = 1 }
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                items(data) { item ->
                    ScheduleCard(item)
                }
            }
        }
    }
}

@Composable
private fun SegmentButton(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val bg = if (selected) GreenPrimary else Color.Transparent
    val textColor = if (selected) Color.White else Color.Black

    Box(
        modifier = modifier
            .padding(4.dp)
            .height(40.dp)
            .background(bg, RoundedCornerShape(50))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = textColor, fontSize = 14.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
private fun ScheduleCard(item: ScheduleItem) {
    val badgeColor = when (item.status) {
        "Today" -> ChipGreen
        "Tomorrow" -> ChipBlue
        else -> ChipGrey
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(18.dp),
        tonalElevation = 2.dp
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFFE8F5E9), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.LocalShipping,
                    contentDescription = null,
                    tint = GreenPrimary
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(item.tps, fontWeight = FontWeight.SemiBold)
                Text(item.time, fontSize = 12.sp, color = Color.Gray)
            }

            Box(
                modifier = Modifier
                    .background(badgeColor, RoundedCornerShape(50))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text(item.status, color = Color.White, fontSize = 12.sp)
            }
        }
    }
}
