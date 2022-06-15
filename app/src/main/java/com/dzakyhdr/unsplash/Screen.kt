package com.dzakyhdr.unsplash

const val DETAIL_ID = "id"

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Detail : Screen(route = "detail_screen/{$DETAIL_ID}") {
        fun passId(id: String?): String {
            return this.route.replace(oldValue = "{$DETAIL_ID}", newValue = id ?: "xcYaxvcAv3E")
        }
    }
}
