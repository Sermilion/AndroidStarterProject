package io.readian.uniapp.feature.adlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.readian.uniapp.core.data.repository.UniAppRepository
import io.readian.uniapp.core.database.model.AdDataModel
import io.readian.uniapp.feature.adlist.AdListContract.Ad
import io.readian.uniapp.feature.adlist.AdListContract.UiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class AdListViewModel @Inject constructor(
  repository: UniAppRepository,
) : ViewModel() {

  val state = repository.getAds().map { list ->
    UiState.Content(
      ads =
      listOf(
        Ad(
          name = "Google",
          price = "$100",
          description = "Help people interested in this repository understand your project by adding a README.",
          image = "image",
          category = "category",
        ),
        Ad(
          name = "Microsoft",
          price = "$200",
          description = "Help people interested in this repository understand your project by adding a README.",
          image = "image2",
          category = "category2",
        ),
      )
    )
  }.stateIn(
    scope = viewModelScope,
    started = SharingStarted.WhileSubscribed(5.seconds),
    initialValue = UiState.Loading,
  )

  private fun List<AdDataModel>.mapToUiModel(): List<Ad> {
    return this.map { ad ->
      Ad(
        name = ad.name,
        price = ad.price.toString(),
        description = ad.description,
        image = ad.image,
        category = ad.category,
      )
    }
  }
}
