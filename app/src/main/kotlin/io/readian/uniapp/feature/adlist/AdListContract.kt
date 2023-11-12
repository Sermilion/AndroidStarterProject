package io.readian.uniapp.feature.adlist

import io.readian.uniapp.core.database.model.UserType
import io.readian.uniapp.core.domain.model.Ad

object AdListContract {

  sealed class UiState {
    data object Loading: UiState()
    data object Error: UiState()
    data object Empty: UiState()
    data class Content(
      val ads: List<Ad>,
      val userType: UserType,
      val email: String?,
    ): UiState()
  }

}
