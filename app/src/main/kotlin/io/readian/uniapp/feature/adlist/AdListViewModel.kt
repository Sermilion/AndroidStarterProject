package io.readian.uniapp.feature.adlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.readian.uniapp.core.data.repository.UniAppRepository
import io.readian.uniapp.core.domain.model.AdsMapper.mapToUiModel
import io.readian.uniapp.feature.adlist.AdListContract.UiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class AdListViewModel @Inject constructor(
  private val repository: UniAppRepository,
) : ViewModel() {

  val state = combine(repository.getAds(), repository.getLoggedUserFlow()) { list, dataModel ->
    val user = dataModel ?: return@combine UiState.Error
    if (list.isEmpty()) {
      UiState.Empty
    } else {
      UiState.Content(
        ads = list.mapToUiModel(user),
        userType = user.type,
        email = user.email,
      )
    }
  }.stateIn(
    scope = viewModelScope,
    started = SharingStarted.WhileSubscribed(5.seconds),
    initialValue = UiState.Loading,
  )

  fun onAdSelected(name: String) {
    viewModelScope.launch {
      val state = (state.value as? UiState.Content)
      val ad = state?.ads?.find { it.name == name } ?: return@launch

      if (state.email == null) {
        return@launch
      }

      repository.saveAd(
        adId = ad.id,
        email = state.email,
      )
    }
  }
}
