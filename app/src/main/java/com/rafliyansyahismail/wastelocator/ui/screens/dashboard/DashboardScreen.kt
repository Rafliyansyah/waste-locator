package com.rafliyansyahismail.wastelocator.ui.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Report
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rafliyansyahismail.wastelocator.ui.components.WasteLocatorBottomBar
import com.rafliyansyahismail.wastelocator.ui.navigation.Screen
import com.rafliyansyahismail.wastelocator.ui.theme.GreenPrimary
import com.rafliyansyahismail.wastelocator.ui.theme.SurfaceLight

@Composable
fun DashboardScreen(navController: NavController) {
    Scaffold(
        bottomBar = { WasteLocatorBottomBar(navController) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(SurfaceLight)
        ) {
            // ---------------- HEADER ----------------
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(GreenPrimary, RoundedCornerShape(bottomStart = 28.dp, bottomEnd = 28.dp))
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text("Good morning", style = MaterialTheme.typography.labelMedium, color = Color.White.copy(alpha = 0.8f))
                    Text("Hello, Sarah", style = MaterialTheme.typography.headlineSmall, color = Color.White)
                }

                // Profile avatar
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(20.dp)
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.9f))
                        .clickable { navController.navigate(Screen.Profile.route) },
                    contentAlignment = Alignment.Center
                ) {
                    Text("SJ", color = GreenPrimary)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // ---------------- SUMMARY CARDS ----------------
            SummaryCard(
                title = "Nearest TPS",
                subtitle = "TPS Kebayoran Baru",
                badge = "Active",
                badgeColor = Color(0xFF81C784) // green light
            )
            Spacer(modifier = Modifier.height(12.dp))

            SummaryCard(
                title = "Latest Report",
                subtitle = "Illegal dumping reported",
                badge = "In Progress",
                badgeColor = Color(0xFFFFCC80) // orange light
            )

            Spacer(modifier = Modifier.height(20.dp))

            // ---------------- QUICK ACTIONS ----------------
            Text(
                "Quick Actions",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            QuickActionsGrid(navController)
        }
    }
}

// ===============================================================
// Summary Card Reusable Component
// ===============================================================
@Composable
fun SummaryCard(title: String, subtitle: String, badge: String, badgeColor: Color) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(title, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(badgeColor)
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(badge, color = Color.White, style = MaterialTheme.typography.labelSmall)
                }
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(subtitle, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text("1.2 km away", color = Color.Gray, style = MaterialTheme.typography.labelSmall)
        }
    }
}

// ===============================================================
// Quick Actions Grid
// ===============================================================
@Composable
fun QuickActionsGrid(navController: NavController) {
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

            QuickActionItem("TPS Locations", Icons.Filled.Map) {
                navController.navigate(Screen.Map.route)
            }

            QuickActionItem("Collection Schedule", Icons.Filled.CalendarMonth) {
                navController.navigate(Screen.Schedule.route)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

            QuickActionItem("Report Waste", Icons.Filled.Report) {
                navController.navigate(Screen.Report.route)
            }

            QuickActionItem("My Reports", Icons.Filled.List) {
                navController.navigate(Screen.MyReports.route)
            }
        }
    }
}

@Composable
fun QuickActionItem(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {
    ElevatedCard(
        modifier = Modifier
            .size(width = 150.dp, height = 110.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Icon(icon, contentDescription = label, tint = GreenPrimary)
            Spacer(modifier = Modifier.height(8.dp))
            Text(label, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
