package io.readian.uniapp.feature.advertisers

object AdvertisersContract {

  sealed class UiState {
    data object Loading: UiState()
    data class Content(val advertisers: List<Advertiser>): UiState()
  }

  data class Advertiser(
    val name: String,
    val price: Int,
    val description: String,
    val image: String,
    val category: String,
  )
}
