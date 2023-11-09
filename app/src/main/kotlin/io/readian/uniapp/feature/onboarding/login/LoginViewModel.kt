package io.readian.uniapp.feature.onboarding.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.readian.uniapp.core.data.repository.UniAppRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
  private val repository: UniAppRepository,
) : ViewModel() {

  fun login(
    email: String,
    password: String,
  ) {
    viewModelScope.launch {
      val user = repository.getUser(
        email = email,
        password = password,
      )
      user
    }
  }
}