package com.PDM.weatherapp.ui.nav


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.PDM.weatherapp.model.MainViewModel
import com.PDM.weatherapp.ui.HomePage
import com.PDM.weatherapp.ui.ListPage
import com.PDM.weatherapp.ui.MapPage

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    NavHost(navController, startDestination = Route.Home) {
        composable<Route.Home> { HomePage(viewModel) }
        composable<Route.List> { ListPage(modifier, viewModel) }
        composable<Route.Map> { MapPage(viewModel) }
    }
}