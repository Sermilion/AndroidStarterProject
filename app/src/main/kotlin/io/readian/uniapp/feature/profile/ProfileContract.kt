package io.readian.uniapp.feature.profile

import io.readian.uniapp.core.database.model.UserType
import io.readian.uniapp.core.domain.model.Ad

object ProfileContract {
  sealed interface UiState {
    data class Profile(
      val username: String,
      val email: String,
      val type: UserType,
      val ads: List<Ad>,
    ): UiState

    data object Error: UiState

    data object Loading: UiState
  }
}

