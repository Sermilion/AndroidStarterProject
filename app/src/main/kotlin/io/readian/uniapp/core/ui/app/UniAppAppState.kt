package io.readian.uniapp.core.ui.app

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Domain
import androidx.compose.material.icons.filled.House
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.readian.android.R
import io.readian.uniapp.core.designsystem.icon.Icon
import io.readian.uniapp.core.navigation.UniAppNavigationDestination
import io.readian.uniapp.core.ui.navigation.TopLevelDestination
import io.readian.uniapp.core.ui.navigation.destinations.Profile
import io.readian.uniapp.feature.adlist.navigation.AdListDestination
import io.readian.uniapp.feature.onboarding.navigation.ForgotPasswordDestination
import io.readian.uniapp.feature.onboarding.navigation.LoginDestination
import io.readian.uniapp.feature.onboarding.navigation.RegistrationDestination
import io.readian.uniapp.feature.onboarding.navigation.WelcomeDestination
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun rememberReadianAppState(
  navController: NavHostController = rememberNavController(),
): UniAppAppState {
  return remember(navController) {
    UniAppAppState(navController = navController)
  }
}

@Stable
class UniAppAppState(val navController: NavHostController) {

  val currentDestination: NavDestination?
    @Composable get() = navController.currentBackStackEntryAsState().value?.destination

  val showBottomNavigation: Boolean
    @Composable get() {
      return when (currentDestination?.route) {
        WelcomeDestination.destination,
        LoginDestination.destination,
        ForgotPasswordDestination.destination,
        RegistrationDestination.destination -> false

        null -> false
        else -> true
      }
    }

  val topLevelDestinations: ImmutableList<TopLevelDestination> = listOfNotNull(
    TopLevelDestination(
      route = AdListDestination.route,
      destination = AdListDestination.destination,
      selectedIcon = Icon.ImageVectorIcon(Icons.Default.Domain),
      iconTextResource = R.string.label_ads,
    ),
    TopLevelDestination(
      route = Profile.route,
      destination = Profile.destination,
      selectedIcon = Icon.ImageVectorIcon(Icons.Default.House),
      iconTextResource = R.string.label_profile,
    ),
  ).toImmutableList()

  fun navigate(destination: UniAppNavigationDestination, route: String? = null) {
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
