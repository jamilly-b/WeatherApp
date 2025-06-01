package com.PDM.weatherapp.ui.nav


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.PDM.weatherapp.ui.HomePage
import com.PDM.weatherapp.ui.ListPage
import com.PDM.weatherapp.ui.MapPage

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomePage() }
        composable("list") { ListPage() }
        composable("map") { MapPage() }
    }
}