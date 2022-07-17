package com.example.starbucksfinder.presentation.ui.navigation

sealed class Screen(val route: String){
    object ShopsListScreen : Screen("shop_list_screen")
    object ShopDetailScreen : Screen("shop_detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    fun withArgs(vararg args: Int): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

