package io.readian.uniapp.feature.onboarding.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.readian.uniapp.core.data.repository.UniAppRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
  private val repository: UniAppRepository,
) : ViewModel() {

  fun signUp(
    username: String,
    email: String,
    password: String,
  ) {
    viewModelScope.launch {
      repository.saveUser(
        username = username,
        email = email,
        password = password,
      )
    }
  }
}
