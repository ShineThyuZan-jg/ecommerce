package com.po.ecommerce.ui.theme.graph

import android.annotation.SuppressLint
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.po.ecommerce.ui.theme.screen.home.HomeScreen
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
            HomeScreen(
                navController = navController,
                viewModel = EcommerceInfoViewModel()
            )
        }
        composable(
            route = Destination.Detail.route,

        ) { navBackStackEntry ->
            val gson: Gson = GsonBuilder().create()
            val ecommerceJson = navBackStackEntry.arguments?.getString("ecommerceVo")
            Log.d("ecommerceJson.dd", ecommerceJson.toString())
            // val ecommerceObject = gson.fromJson(ecommerceJson, EcommerceItemVo::class.java)
//            DetailScreen(
//                navController = navController,
//                ecommerceItemVo = ecommerceObject
//            )
        }
    }
}