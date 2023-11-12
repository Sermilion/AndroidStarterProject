package io.readian.uniapp.feature.onboarding.signup

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.readian.uniapp.core.data.repository.UniAppRepository
import io.readian.uniapp.core.database.model.UserType
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class SignUpViewModel @Inject constructor(
  private val repository: UniAppRepository,
) : ViewModel() {

  val uiState = flowOf(
    listOf(
      UserType.Advertiser.name,
      UserType.Company.name,
    )
  ).stateIn(
    scope = viewModelScope,
    started = SharingStarted.WhileSubscribed(5.seconds),
    initialValue = listOf(
      UserType.Advertiser.name,
      UserType.Company.name,
    ),
  )

  fun signUp(
    username: String,
    email: String,
    password: String,
    type: UserType,
  ) {
    viewModelScope.launch {
      try {
        repository.saveUser(
          username = username,
          email = email,
          password = password,
          type = type,
        )
      } catch (e: SQLiteConstraintException) {
        // user exists
      }
    }
  }
}
