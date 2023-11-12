package io.readian.uniapp.feature.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import io.readian.uniapp.core.navigation.UniAppNavigationDestination
import io.readian.uniapp.feature.profile.ui.ProfileScreen


object ProfileDestination : UniAppNavigationDestination {
  override val route: String = "profile_route"
  override val destination: String = "profile_destination"
}

fun NavController.navigateToProfileGraph(navOptions: NavOptions? = null) {
  this.navigate(ProfileDestination.route, navOptions)
}

fun NavGraphBuilder.profileGraph() {
  navigation(
    route = ProfileDestination.route,
    startDestination = ProfileDestination.destination,
  ) {
    composable(
      route = ProfileDestination.destination,
    ) {
      ProfileScreen()
    }
  }
}