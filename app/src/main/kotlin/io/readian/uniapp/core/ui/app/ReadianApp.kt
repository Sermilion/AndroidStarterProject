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
import io.readian.uniapp.core.ui.navigation.ReadianNavHost
import io.readian.uniapp.core.ui.navigation.ReadianNavigationBar
import io.readian.uniapp.core.ui.navigation.ReadianNavigationBarItem
import io.readian.uniapp.core.ui.navigation.TopLevelDestination
import io.readian.uniapp.core.update.UpdateChecker
import io.readian.uniapp.designsystem.component.ReadianBackground
import io.readian.uniapp.designsystem.theme.ReadianTheme
import kotlinx.collections.immutable.ImmutableList

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ReadianApp(
  modifier: Modifier = Modifier,
  appState: ReadianAppState = rememberReadianAppState(),
//  scope: CoroutineScope = rememberCoroutineScope(),
) {
    ReadianTheme {
        ReadianBackground {
            UpdateChecker {
                val topLevelDestinations = appState.topLevelDestinations
                Scaffold(
                    modifier = Modifier.systemBarsPadding().then(modifier),
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
                        ReadianNavHost(
                            navController = appState.navController,
//              onBackClick = appState::onBackClick,
//              onNavigateToDestination = appState::navigate,
//              onOpenDrawer = { scope.launch { appState.drawerState.open() } },
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
