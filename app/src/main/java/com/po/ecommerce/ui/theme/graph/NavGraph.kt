package com.po.ecommerce.ui.theme.graph

import android.annotation.SuppressLint
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.po.ecommerce.ui.theme.screen.home.HomeScreen
import com.po.ecommerce.ui.theme.screen.news.DetailScreen
import com.po.ecommerce.ui.theme.viewmodel.EcommerceInfoViewModel

@SuppressLint("UnrememberedGetBackStackEntry")
fun NavGraphBuilder.navGraph(
    navController: NavController
) {
    navigation(
        startDestination = Destination.Home.route,
        route = Routes.HOME
    ) {
        composable(route = Destination.Home.route) {
            // val sharedViewModel: EcommerceInfoViewModel = hiltViewModel()
            val homeBackStackEntry =
                remember { navController.getBackStackEntry(Destination.Home.route) }
            val ecommerceViewModel: EcommerceInfoViewModel = viewModel(homeBackStackEntry)
            HomeScreen(
                navController = navController,
                viewModel = ecommerceViewModel
            )
        }
        composable(
            route = Destination.Detail.route,
        ) {
            val homeBackStackEntry =
                remember { navController.getBackStackEntry(Destination.Home.route) }
            val ecommerceViewModel: EcommerceInfoViewModel = viewModel(homeBackStackEntry)
            DetailScreen(
                navController = navController,
                viewModel = ecommerceViewModel
            )
        }
    }
}

//NavHost(navController = navController, startDestination = "home") {
//    navigation(startDestination = "username", route = "login") {
//        composable("username") {
//            val loginBackStackEntry = remember { navController.getBackStackEntry("login") }
//            val loginViewModel: LoginViewModel = viewModel(loginBackStackEntry)
//            ...
//        }
//        composable("password") {
//            val loginBackStackEntry = remember { navController.getBackStackEntry("login") }
//            val loginViewModel: LoginViewModel = viewModel(loginBackStackEntry)
//            ...
//        }
//        composable("registration") {
//            val loginBackStackEntry = remember { navController.getBackStackEntry("login") }
//            val loginViewModel: LoginViewModel = viewModel(loginBackStackEntry)
//            ...
//        }
//    }
//}