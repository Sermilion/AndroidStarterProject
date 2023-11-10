package io.readian.uniapp.feature.advertisers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.readian.uniapp.core.data.repository.UniAppRepository
import io.readian.uniapp.core.database.model.AdvertiserDataModel
import io.readian.uniapp.feature.advertisers.AdvertisersContract.Advertiser
import io.readian.uniapp.feature.advertisers.AdvertisersContract.UiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

class AdvertisersViewModel @Inject constructor(
  repository: UniAppRepository,
) : ViewModel() {

  val state = repository.getAdvertisers().map { list ->
    UiState.Content(advertisers = list.mapToUiModel())
  }.stateIn(
    scope = viewModelScope,
    started = SharingStarted.WhileSubscribed(5.seconds),
    initialValue = UiState.Loading,
  )

  private fun List<AdvertiserDataModel>.mapToUiModel(): List<Advertiser> {
    return this.map { advertiser ->
      Advertiser(
        name = advertiser.name,
        price = advertiser.price,
        description = advertiser.description,
        image = advertiser.image,
        category = advertiser.category,
      )
    }
  }
}
