package com.example.starbucksfinder.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.starbucksfinder.presentation.ui.shopdetail.ShopDetailsScreen
import com.example.starbucksfinder.presentation.ui.shoplist.ShopListViewModel
import com.example.starbucksfinder.presentation.ui.shoplist.view.ShopsListScreen

@Composable
fun Navigation(
    navController: NavHostController,
    shopsListViewModel: ShopListViewModel = hiltViewModel()
) {
    NavHost(navController = navController, startDestination = Screen.ShopsListScreen.route) {
        composable(route = Screen.ShopsListScreen.route) {
            ShopsListScreen(shopsListViewModel, navController)
        }
        composable(
            route = Screen.ShopDetailScreen.route + "/{shopIndex}",
            arguments = listOf(
                navArgument("shopIndex"){
                    type = NavType.IntType
                }
            )
        ) { entry ->
            ShopDetailsScreen(shopsListViewModel, entry.arguments?.getInt("shopIndex"))
        }
    }
}