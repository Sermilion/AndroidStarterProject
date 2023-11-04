package io.readian.uniapp.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun ReadianNavHost(
    navController: NavHostController,
//  onNavigateToDestination: (ReadianNavigationDestination, String) -> Unit,
//  onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = "login",
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        // some screen
    }
}
