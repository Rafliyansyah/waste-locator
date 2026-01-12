package com.rafliyansyahismail.wastelocator.ui.screens.reports

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rafliyansyahismail.wastelocator.ui.components.WasteLocatorBottomBar

@Composable
fun MyReportsScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            WasteLocatorBottomBar(navController = navController)
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF5F7F6))
                .padding(16.dp)
        ) {

            Text(
                text = "My Reports",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            ReportItem(
                title = "Illegal Dumping",
                time = "2 hours ago",
                status = ReportStatus.IN_PROGRESS
            )

            ReportItem(
                title = "Overflowing Bin",
                time = "Yesterday",
                status = ReportStatus.ACCEPTED
            )

            ReportItem(
                title = "Missed Collection",
                time = "3 days ago",
                status = ReportStatus.DONE
            )

            ReportItem(
                title = "Damaged Bin",
                time = "1 week ago",
                status = ReportStatus.SUBMITTED
            )
        }
    }
}

@Composable
private fun ReportItem(
    title: String,
    time: String,
    status: ReportStatus
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Thumbnail placeholder
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFE0E0E0)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.Image,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = time,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            StatusChip(status = status)
        }
    }
}

@Composable
private fun StatusChip(status: ReportStatus) {
    val (text, color) = when (status) {
        ReportStatus.SUBMITTED -> "Submitted" to Color(0xFFBDBDBD)
        ReportStatus.ACCEPTED -> "Accepted" to Color(0xFF64B5F6)
        ReportStatus.IN_PROGRESS -> "In Progress" to Color(0xFFFFB74D)
        ReportStatus.DONE -> "Done" to Color(0xFF81C784)
    }

    Surface(
        color = color.copy(alpha = 0.2f),
        shape = RoundedCornerShape(50)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            color = color,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

private enum class ReportStatus {
    SUBMITTED,
    ACCEPTED,
    IN_PROGRESS,
    DONE
}
