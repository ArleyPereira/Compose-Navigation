package br.com.hellodev.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.hellodev.navigation.screens.FriendsListScreen
import br.com.hellodev.navigation.screens.HomeScreen
import br.com.hellodev.navigation.screens.SearchScreen
import br.com.hellodev.navigation.util.fromJson
import br.com.hellodev.navigation.util.toJson

@Composable
fun MyGraph(navController: NavHostController, startDestination: String) {

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = "home_screen") {
            HomeScreen(
                navigateToFriendsListScreen = { user ->
                    navController.navigate("friends_list_screen?user=${user?.toJson()}")
                },
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "friends_list_screen?user={user}",
            arguments = listOf(navArgument("user") { nullable = true })
        ) { navBackStackEntry ->
            val user = navBackStackEntry.arguments?.getString("user")?.fromJson<User>()
            val backResult = navBackStackEntry.savedStateHandle.get<String>("back_result")
            FriendsListScreen(
                user = user,
                backResult = backResult,
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
                onBackPressed = { result ->
                    navController.previousBackStackEntry
                        ?.savedStateHandle
                        ?.set("back_result", result)
                    navController.popBackStack()
                }
            )
        }
    }
}