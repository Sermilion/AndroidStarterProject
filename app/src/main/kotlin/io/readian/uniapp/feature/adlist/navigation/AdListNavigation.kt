package io.readian.uniapp.feature.adlist.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import io.readian.uniapp.core.navigation.UniAppNavigationDestination
import io.readian.uniapp.feature.adlist.ui.AdListScreen

object AdListDestination : UniAppNavigationDestination {
  override val route = "adlist_route"
  override val destination = "adlist_destination"
}

fun NavController.navigateToAdListGraph(navOptions: NavOptions? = null) {
  this.navigate(AdListDestination.route, navOptions)
}

fun NavGraphBuilder.adListGraph() {
  navigation(
    route = AdListDestination.route,
    startDestination = AdListDestination.destination,
  ) {
    composable(
      route = AdListDestination.destination,
    ) {
      AdListScreen()
    }
  }
}