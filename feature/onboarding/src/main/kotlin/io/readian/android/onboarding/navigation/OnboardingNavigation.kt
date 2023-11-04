package io.readian.android.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import io.readian.android.core.navigation.NoBottomNavDestination
import io.readian.android.onboarding.welcome.ui.WelcomeScreen

object WelcomeDestination : NoBottomNavDestination {
    override val route = "welcome_route"
    override val destination = "welcome_destination"
}

fun NavGraphBuilder.onboardingGraph(
    onLoginClicked: () -> Unit,
    onSignUpClick: () -> Unit,
    onSkipClick: () -> Unit,
) {
    navigation(
        route = WelcomeDestination.route,
        startDestination = WelcomeDestination.destination,
    ) {
        composable(
            route = WelcomeDestination.destination,
        ) {
            WelcomeScreen(
                onLoginClicked = onLoginClicked,
                onSignUpClicked = onSignUpClick,
                onSkipClicked = onSkipClick,
            )
        }
    }
}
