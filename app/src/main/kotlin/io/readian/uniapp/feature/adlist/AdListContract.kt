package io.readian.uniapp.feature.adlist

object AdListContract {

  sealed class UiState {
    data object Loading: UiState()
    data class Content(val ads: List<Ad>): UiState()
  }

  data class Ad(
    val name: String,
    val price: String,
    val description: String,
    val image: String,
    val category: String,
  )
}
