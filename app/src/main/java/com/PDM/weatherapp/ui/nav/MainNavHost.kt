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
    NavHost(navController, startDestination = Route.Home) {
        composable<Route.Home> { HomePage() }
        composable<Route.List> { ListPage() }
        composable<Route.Map> { MapPage() }
    }
}