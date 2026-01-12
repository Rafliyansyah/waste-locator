package com.rafliyansyahismail.wastelocator.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Dashboard : Screen("dashboard")
    object Map : Screen("map")
    object Schedule : Screen("schedule")
    object Report : Screen("report")
    object MyReports : Screen("my_reports")
    object Profile : Screen("profile")
    object ReportDetail : Screen("report_detail")
}
