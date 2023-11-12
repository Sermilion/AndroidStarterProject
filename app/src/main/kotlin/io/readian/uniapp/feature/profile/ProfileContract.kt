package io.readian.uniapp.feature.profile

import io.readian.uniapp.core.database.model.UserType

object ProfileContract {
  sealed interface UiState {
    data class Profile(
      val username: String,
      val email: String,
      val type: UserType,
    ): UiState

    data object Error: UiState

    data object Loading: UiState
  }
}

