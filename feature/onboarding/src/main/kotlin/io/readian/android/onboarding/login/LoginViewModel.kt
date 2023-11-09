package io.readian.android.onboarding.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.readian.android.core.data.UniAppRepository
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