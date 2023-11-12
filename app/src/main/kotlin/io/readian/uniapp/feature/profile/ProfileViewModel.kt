package io.readian.uniapp.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.readian.uniapp.core.data.repository.UniAppRepository
import io.readian.uniapp.core.database.model.UserType
import io.readian.uniapp.core.domain.model.AdsMapper.mapToUiModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class ProfileViewModel @Inject constructor(
  private val repository: UniAppRepository,
) : ViewModel() {

  val uiState = repository.getLoggedUserFlow().map {
    if (it != null) {
      val user = repository.getUser(it.email, it.password)
      if (user != null) {
        when (user.type) {
          UserType.Advertiser -> repository.getCreatedAdsForUser(it.email)
          UserType.Company -> repository.getUserWithAds(it.email).map { it?.ads ?: emptyList() }
          UserType.None -> flowOf(emptyList())
        }.flatMapLatest {
          flowOf(
            ProfileContract.UiState.Profile(
              username = user.username,
              email = user.email,
              type = user.type,
              ads = it.mapToUiModel(user),
            )
          )
        }
      } else {
        flowOf(ProfileContract.UiState.Error)
      }
    } else {
      flowOf(ProfileContract.UiState.Error)
    }
  }.flatMapLatest { it }.stateIn(
    scope = viewModelScope,
    started = SharingStarted.WhileSubscribed(5.seconds),
    initialValue = ProfileContract.UiState.Loading,
  )

  fun logout() {
    viewModelScope.launch {
      val email = (uiState.value as? ProfileContract.UiState.Profile)?.email
      if (email != null) {
        repository.saveLoggedUser(
          email = email,
          logged = false
        )
      }
    }
  }

  fun removeAd(id: UUID) {
    viewModelScope.launch {
      val type = (uiState.value as? ProfileContract.UiState.Profile)?.type
      when (type) {
        UserType.Advertiser -> repository.removeAd(id)
        UserType.Company -> repository.removeAdFromProfile(id)
        else -> {
          // intentionally left empty
        }
      }
    }
  }
}