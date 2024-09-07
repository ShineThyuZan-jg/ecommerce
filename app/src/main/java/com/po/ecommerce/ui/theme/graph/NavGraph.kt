package com.po.ecommerce.ui.theme.graph

import android.annotation.SuppressLint
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.po.ecommerce.ui.theme.common.EcommerceItemVo
import com.po.ecommerce.ui.theme.screen.home.HomeScreen
import com.po.ecommerce.ui.theme.screen.news.DetailScreen
import com.po.ecommerce.ui.theme.viewmodel.MatchInfoViewModel

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
                viewModel = MatchInfoViewModel()
            )
        }
        composable(
            route = Destination.Detail.route,
        ) {
            DetailScreen(
                navController = navController,
                ecommerceItemVo = EcommerceItemVo()
            )
        }
    }
}