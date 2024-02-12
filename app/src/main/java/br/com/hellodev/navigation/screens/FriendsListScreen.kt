package br.com.hellodev.navigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FriendsListScreen(
    navigateToSearchScreen: () -> Unit,
    onBackPressed: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "FriendsListScreen")

        Button(onClick = { navigateToSearchScreen() }) {
            Text(text = "Navigate To SearchScreen")
        }

        Button(onClick = { onBackPressed() }) {
            Text(text = "Go back")
        }
    }
}