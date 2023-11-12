package io.readian.uniapp.feature.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import io.readian.uniapp.core.navigation.UniAppNavigationDestination
import io.readian.uniapp.feature.profile.ui.CreateAdScreen
import io.readian.uniapp.feature.profile.ui.ProfileScreen


object ProfileDestination : UniAppNavigationDestination {
  override val route: String = "profile_route"
  override val destination: String = "profile_destination"
}

object CreateAdDestination : UniAppNavigationDestination {
  override val route: String = "create_ad_route"
  override val destination: String = "create_ad_destination"
}

fun NavController.navigateCreateAdGraph(navOptions: NavOptions? = null) {
  this.navigate(CreateAdDestination.route, navOptions)
}

fun NavGraphBuilder.profileGraph(
  onCreateAd: () -> Unit,
) {
  navigation(
    route = ProfileDestination.route,
    startDestination = ProfileDestination.destination,
  ) {
    composable(
      route = ProfileDestination.destination,
    ) {
      ProfileScreen(onCreateAd = onCreateAd)
    }
  }
}

fun NavGraphBuilder.createAdGraph(
  onClose: () -> Unit,
) {
  navigation(
    route = CreateAdDestination.route,
    startDestination = CreateAdDestination.destination,
  ) {
    composable(
      route = CreateAdDestination.destination,
    ) {
      CreateAdScreen(onClose = onClose)
    }
  }
}