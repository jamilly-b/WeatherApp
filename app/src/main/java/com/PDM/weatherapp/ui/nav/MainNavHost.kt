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
    NavHost(navController, startDestination = BottomNavItem.Route.Home) {
        composable<BottomNavItem.Route.Home> { HomePage() }
        composable<BottomNavItem.Route.List> { ListPage() }
        composable<BottomNavItem.Route.Map> { MapPage() }
    }
}