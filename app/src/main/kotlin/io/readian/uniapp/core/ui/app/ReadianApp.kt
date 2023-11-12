package io.readian.uniapp.core.ui.app

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import io.readian.uniapp.core.designsystem.component.ReadianBackground
import io.readian.uniapp.core.designsystem.theme.ReadianTheme
import io.readian.uniapp.core.ui.navigation.ReadianNavigationBar
import io.readian.uniapp.core.ui.navigation.ReadianNavigationBarItem
import io.readian.uniapp.core.ui.navigation.TopLevelDestination
import io.readian.uniapp.core.ui.navigation.UniappNavHost
import io.readian.uniapp.core.update.UpdateChecker
import io.readian.uniapp.feature.adlist.navigation.AdListDestination
import io.readian.uniapp.feature.onboarding.navigation.WelcomeDestination
import kotlinx.collections.immutable.ImmutableList

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UniappApp(
  modifier: Modifier = Modifier,
  appState: UniAppAppState = rememberReadianAppState(),
  userLogged: Boolean,
) {
  ReadianTheme {
    ReadianBackground {
      UpdateChecker {
        val topLevelDestinations = appState.topLevelDestinations
        Scaffold(
          modifier = Modifier
            .systemBarsPadding()
            .then(modifier),
          bottomBar = {
            if (appState.showBottomNavigation) {
              ReadianBottomBar(
                destinations = topLevelDestinations,
                onNavigateToDestination = appState::navigate,
                currentDestination = appState.currentDestination,
              )
            }
          },
        ) { innerPadding ->

          ConstraintLayout(
            modifier = Modifier
              .fillMaxSize()
              .padding(innerPadding)
              .consumeWindowInsets(innerPadding)
              .windowInsetsPadding(
                WindowInsets.safeDrawing.only(
                  WindowInsetsSides.Vertical,
                ),
              ),
          ) {
            UniappNavHost(
              navController = appState.navController,
              startDestination = if (userLogged) {
                AdListDestination.route
              } else {
                WelcomeDestination.route
              }
            )
          }
        }
      }
    }
  }
}

@Composable
fun ReadianBottomBar(
  destinations: ImmutableList<TopLevelDestination>,
  onNavigateToDestination: (TopLevelDestination) -> Unit,
  currentDestination: NavDestination?,
  modifier: Modifier = Modifier,
) {
  ReadianNavigationBar(modifier = modifier) {
    destinations.forEach { destination ->
      val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)

      ReadianNavigationBarItem(
        selected = selected,
        onClick = { onNavigateToDestination(destination) },
        icon = { destination.selectedIcon },
        label = { Text(stringResource(destination.iconTextResource)) },
      )
    }
  }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
  this?.hierarchy?.any {
    it.route?.equals(destination.route) ?: false
  } ?: false
