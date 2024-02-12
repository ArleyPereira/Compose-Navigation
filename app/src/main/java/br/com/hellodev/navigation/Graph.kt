package br.com.hellodev.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.hellodev.navigation.screens.FriendsListScreen
import br.com.hellodev.navigation.screens.HomeScreen
import br.com.hellodev.navigation.screens.SearchScreen

@Composable
fun MyGraph(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = "home_screen") {
            HomeScreen(
                navigateToFriendsListScreen = {
                    navController.navigate("friends_list_screen")
                },
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = "friends_list_screen") {
            FriendsListScreen(
                navigateToSearchScreen = {
                    navController.navigate("search_screen")
                },
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = "search_screen") {
            SearchScreen(
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}