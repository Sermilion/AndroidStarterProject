package io.readian.uniapp.feature.onboarding.login

object LoginContract {

  sealed interface SideEffect {

    data object WrongCredentials: SideEffect

    sealed interface Navigation {
      data object LoginSuccess: SideEffect
    }
  }
}
