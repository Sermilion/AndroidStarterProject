package io.readian.uniapp.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.readian.uniapp.core.data.repository.UniAppRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class ProfileViewModel @Inject constructor(
  private val repository: UniAppRepository,
) : ViewModel() {

  val uiState = repository.getLoggedUser().map {
    if (it != null) {
      val user = repository.getUser(it.email, it.password)
      if (user != null) {
        ProfileContract.UiState.Profile(
          username = user.username,
          email = user.email,
          type = user.type,
        )
      } else {
        ProfileContract.UiState.Error
      }
    } else {
      ProfileContract.UiState.Error
    }
  }.stateIn(
    scope = viewModelScope,
    started = SharingStarted.WhileSubscribed(5.seconds),
    initialValue = ProfileContract.UiState.Loading,
  )

  fun logout() {
    viewModelScope.launch {
      repository.deleteLoggedUser()
    }
  }
}