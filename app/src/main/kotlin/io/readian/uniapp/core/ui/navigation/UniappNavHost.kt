package io.readian.uniapp.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import io.readian.uniapp.feature.onboarding.navigation.WelcomeDestination
import io.readian.uniapp.feature.onboarding.navigation.forgotPasswordGraph
import io.readian.uniapp.feature.onboarding.navigation.loginGraph
import io.readian.uniapp.feature.onboarding.navigation.navigateToForgotPasswordGraph
import io.readian.uniapp.feature.onboarding.navigation.navigateToLoginGraph
import io.readian.uniapp.feature.onboarding.navigation.navigateToRegistrationGraph
import io.readian.uniapp.feature.onboarding.navigation.registrationGraph
import io.readian.uniapp.feature.onboarding.navigation.welcomeGraph

@Composable
fun UniappNavHost(
  navController: NavHostController,
  modifier: Modifier = Modifier,
  startDestination: String = WelcomeDestination.route,
) {
  NavHost(
    navController = navController,
    startDestination = startDestination,
    modifier = modifier,
  ) {
    welcomeGraph(
      onLoginClick = {
        navController.navigateToLoginGraph()
      },
      onRegisterClick = {
        navController.navigateToRegistrationGraph()
      },
    )

    //4
    loginGraph(
      onBackClick = { navController.navigateUp() },
      onForgotPasswordClick = {
        navController.navigateToForgotPasswordGraph()
      }
    )

    registrationGraph(
      onBackClick = { navController.navigateUp() },
      onLoginSuccess = {
        navController.navigateToLoginGraph()
      }
    )

    forgotPasswordGraph(
      onBackClick = { navController.navigateUp() }
    )
  }
}