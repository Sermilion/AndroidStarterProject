package io.readian.uniapp.feature.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import io.readian.uniapp.core.navigation.NoBottomNavDestination
import io.readian.uniapp.feature.onboarding.password_recovery.ui.PasswordRecoveryScreen
import io.readian.uniapp.feature.onboarding.signup.ui.SignUpScreen
import io.readian.uniapp.feature.onboarding.welcome.ui.WelcomeScreen

object WelcomeDestination : NoBottomNavDestination {
  override val route = "welcome_route"
  override val destination = "welcome_destination"
}

// 1
object LoginDestination : NoBottomNavDestination {
  override val route = "login_route"
  override val destination = "login_destination"
}

object RegistrationDestination : NoBottomNavDestination {
  override val route = "registration_route"
  override val destination = "registration_destination"
}

object ForgotPasswordDestination : NoBottomNavDestination {
  override val route = "forgot_password_route"
  override val destination = "forgot_password_destination"
}

//3
fun NavController.navigateToLoginGraph(navOptions: NavOptions? = null) {
  this.navigate(LoginDestination.route, navOptions)
}

fun NavController.navigateToRegistrationGraph(navOptions: NavOptions? = null) {
  this.navigate(RegistrationDestination.route, navOptions)
}

fun NavController.navigateToForgotPasswordGraph(navOptions: NavOptions? = null) {
  this.navigate(ForgotPasswordDestination.route, navOptions)
}

fun NavGraphBuilder.welcomeGraph(
  onLoginClick: () -> Unit,
  onRegisterClick: () -> Unit,
) {
  navigation(
    route = WelcomeDestination.route,
    startDestination = WelcomeDestination.destination,
  ) {
    composable(
      route = WelcomeDestination.destination,
    ) {
      WelcomeScreen(
        onLoginClick = onLoginClick,
        onRegisterClick = onRegisterClick,
      )
    }
  }
}

//2
fun NavGraphBuilder.loginGraph(
  onBackClick: () -> Unit,
  onForgotPasswordClick: () -> Unit,
) {
  navigation(
    route = LoginDestination.route,
    startDestination = LoginDestination.destination,
  ) {
    composable(
      route = LoginDestination.destination,
    ) {
      io.readian.uniapp.feature.onboarding.login.ui.LoginScreen(
        onBackClick = onBackClick,
        onForgotPasswordClick = onForgotPasswordClick,
      )
    }
  }
}

fun NavGraphBuilder.registrationGraph(
  onBackClick: () -> Unit,
  onLoginSuccess: () -> Unit,
) {
  navigation(
    route = RegistrationDestination.route,
    startDestination = RegistrationDestination.destination,
  ) {
    composable(
      route = RegistrationDestination.destination,
    ) {
      SignUpScreen(
        onBackClick = onBackClick,
        onLoginSuccess = onLoginSuccess,
      )
    }
  }
}

fun NavGraphBuilder.forgotPasswordGraph(
  onBackClick: () -> Unit,
) {
  navigation(
    route = ForgotPasswordDestination.route,
    startDestination = ForgotPasswordDestination.destination,
  ) {
    composable(
      route = ForgotPasswordDestination.destination,
    ) {
      PasswordRecoveryScreen(onBackClick = onBackClick)
    }
  }
}
