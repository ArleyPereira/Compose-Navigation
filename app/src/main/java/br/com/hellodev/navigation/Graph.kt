package br.com.hellodev.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyGraph(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = "profile_screen") {
            ProfileScreen()
        }

        composable(route = "friends_list_screen") {
            FriendsListScreen()
        }
    }
}