package io.readian.uniapp.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.readian.uniapp.core.data.repository.UniAppRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateAdViewModel @Inject constructor(
  private val repository: UniAppRepository,
) : ViewModel() {

  fun onCreateAd(
    adName: String,
    description: String,
    price: Int,
    category: String,
  ) {
    viewModelScope.launch {
      val email = repository.getLoggedUser()?.email ?: return@launch
      repository.addAd(
        adName = adName,
        description = description,
        price = price,
        category = category,
        email = email,
      )
    }
  }
}