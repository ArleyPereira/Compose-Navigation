package br.com.hellodev.navigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.hellodev.navigation.User

@Composable
fun HomeScreen(
    navigateToFriendsListScreen: (User) -> Unit,
    onBackPressed: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "HomeScreen")

        Button(onClick = { navigateToFriendsListScreen(User(1, "Arley Santana")) }) {
            Text(text = "Navigate To Friends ListScreen")
        }

        Button(onClick = { onBackPressed() }) {
            Text(text = "Go back")
        }
    }
}