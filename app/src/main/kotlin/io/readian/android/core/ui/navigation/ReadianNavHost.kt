package io.readian.android.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import io.readian.android.onboarding.navigation.WelcomeDestination
import io.readian.android.onboarding.navigation.onboardingGraph

@Composable
fun ReadianNavHost(
    navController: NavHostController,
//  onNavigateToDestination: (ReadianNavigationDestination, String) -> Unit,
//  onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = WelcomeDestination.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        onboardingGraph(
            onLoginClicked = {
            },
            onSignUpClick = {
            },
            onSkipClick = {
            },
        )
    }
}
