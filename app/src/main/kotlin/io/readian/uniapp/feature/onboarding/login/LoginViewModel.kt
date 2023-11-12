package io.readian.uniapp.feature.onboarding.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.readian.uniapp.core.data.repository.UniAppRepository
import io.readian.uniapp.feature.onboarding.login.LoginContract.SideEffect
import io.readian.uniapp.feature.onboarding.login.LoginContract.SideEffect.Navigation.LoginSuccess
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
  private val repository: UniAppRepository,
) : ViewModel() {

  private val _effect: Channel<SideEffect> = Channel()
  val effect = _effect.receiveAsFlow()

  fun login(
    email: String,
    password: String,
  ) {
    viewModelScope.launch {
      val user = repository.getUser(
        email = email,
        password = password,
      )
      if (user != null) {
        repository.saveLoggedUser(
          email = user.email,
          logged = true,
        )
        setEffect { LoginSuccess }
      } else {
        setEffect { SideEffect.WrongCredentials }
      }
    }
  }

  private fun setEffect(builder: () -> SideEffect) {
    val effectValue = builder()
    viewModelScope.launch { _effect.send(effectValue) }
  }
}