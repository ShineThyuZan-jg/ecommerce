package com.po.ecommerce.ui.theme.graph

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.po.ecommerce.ui.theme.screen.splash.LiveYourPerfectScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Splash.route,
        route = Routes.ROOT_ROUTE
    ) {
        composable(route = Destination.Splash.route) {
            //   SplashLottieScreen(navController = navController)
            LiveYourPerfectScreen(navController = navController)
        }
        navGraph(navController = navController)
    }
}
