package io.readian.android.core.ui.app

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Domain
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.LocalLibrary
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.readian.android.R
import io.readian.android.core.navigation.ReadianNavigationDestination
import io.readian.android.core.ui.navigation.TopLevelDestination
import io.readian.android.core.ui.navigation.destinations.Library
import io.readian.android.core.ui.navigation.destinations.Profile
import io.readian.android.core.ui.navigation.destinations.Spotlight
import io.readian.android.designsystem.icon.Icon
import io.readian.android.onboarding.navigation.WelcomeDestination
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun rememberReadianAppState(
    navController: NavHostController = rememberNavController(),
): ReadianAppState {
    return remember(navController) {
        ReadianAppState(navController = navController)
    }
}

@Stable
class ReadianAppState(val navController: NavHostController) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val showBottomNavigation: Boolean
        @Composable get() {
            return when (currentDestination?.route) {
                WelcomeDestination.destination -> false
                null -> false
                else -> true
            }
        }

    val topLevelDestinations: ImmutableList<TopLevelDestination> = listOfNotNull(
        TopLevelDestination(
            route = Spotlight.route,
            destination = Spotlight.destination,
            selectedIcon = Icon.ImageVectorIcon(Icons.Default.Domain),
            iconTextResource = R.string.label_spotlight,
        ),
        TopLevelDestination(
            route = Library.route,
            destination = Library.destination,
            selectedIcon = Icon.ImageVectorIcon(Icons.Default.LocalLibrary),
            iconTextResource = R.string.label_library,
        ),
        TopLevelDestination(
            route = Profile.route,
            destination = Profile.destination,
            selectedIcon = Icon.ImageVectorIcon(Icons.Default.House),
            iconTextResource = R.string.label_profile,
        ),
    ).toImmutableList()

    /**
     * UI logic for navigating to a particular destination in the app. The NavigationOptions to
     * navigate with are based on the type of destination, which could be a top level destination or
     * just a regular destination.
     *
     * Top level destinations have only one copy of the destination of the back stack, and save and
     * restore state whenever you navigate to and from it.
     * Regular destinations can have multiple copies in the back stack and state isn't saved nor
     * restored.
     *
     * @param destination: The [ReadianNavigationDestination] the app needs to navigate to.
     * @param route: Optional route to navigate to in case the destination contains arguments.
     */
    fun navigate(destination: ReadianNavigationDestination, route: String? = null) {
        if (destination is TopLevelDestination) {
            navController.navigate(route ?: destination.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        } else {
            navController.navigate(route ?: destination.route)
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}
