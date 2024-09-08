package com.po.ecommerce.ui.theme.graph

object Routes {
    const val ROOT_ROUTE = "root"
    const val HOME = "ecommerce"
}

sealed class Destination(
    val route: String
) {
    object Splash : Destination(route = "splash_screen")
    object Home : Destination("home")
    object Detail : Destination("detail/{ecommerceVo}")
}