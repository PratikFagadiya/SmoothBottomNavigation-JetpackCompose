package com.pratikfagadiya.animatedbottomnavigation.navigation

sealed class Screens(
    val route: String,
) {
    object HomeScreen : Screens("homeScreen")
    object TrendingScreen : Screens("trendingScreen")
    object FeedScreen : Screens("feedScreen")
    object ProfileScreen : Screens("profileScreen")
}
