package com.rafliyansyahismail.wastelocator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.rafliyansyahismail.wastelocator.ui.navigation.AppNavGraph
import com.rafliyansyahismail.wastelocator.ui.theme.WasteLocatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WasteLocatorApp()
        }
    }
}

@Composable
fun WasteLocatorApp() {
    WasteLocatorTheme {
        val navController = rememberNavController()
        AppNavGraph(navController = navController)
    }
}
