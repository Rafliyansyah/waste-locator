package com.rafliyansyahismail.wastelocator.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rafliyansyahismail.wastelocator.ui.screens.dashboard.DashboardScreen
import com.rafliyansyahismail.wastelocator.ui.screens.login.LoginScreen
import com.rafliyansyahismail.wastelocator.ui.screens.map.MapScreen
import com.rafliyansyahismail.wastelocator.ui.screens.splash.SplashScreen
import com.rafliyansyahismail.wastelocator.ui.screens.schedule.ScheduleScreen
import com.rafliyansyahismail.wastelocator.ui.screens.reports.ReportScreen
import com.rafliyansyahismail.wastelocator.ui.screens.reports.MyReportsScreen
import com.rafliyansyahismail.wastelocator.ui.screens.reports.ReportDetailScreen
import com.rafliyansyahismail.wastelocator.ui.screens.profile.ProfileScreen


@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.Dashboard.route) {
            DashboardScreen(navController)
        }
        composable(route = Screen.Map.route) {
            MapScreen(navController)
        }
        composable(Screen.Schedule.route) {
            ScheduleScreen(navController)
        }
        composable(Screen.Report.route) {
            ReportScreen(navController)
        }
        composable(Screen.MyReports.route) {
            MyReportsScreen(navController)
        }
        composable(Screen.ReportDetail.route) {
            ReportDetailScreen(navController)
        }
        composable(Screen.MyReports.route) {
            MyReportsScreen(navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}
