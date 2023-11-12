package io.readian.uniapp.main.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import io.readian.uniapp.core.ui.app.UniappApp
import io.readian.uniapp.main.MainActivityContract
import io.readian.uniapp.main.MainActivityContract.UiState
import io.readian.uniapp.main.MainActivityViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  private val viewModel: MainActivityViewModel by viewModels()
  override fun onCreate(savedInstanceState: Bundle?) {
    val splashScreen = installSplashScreen()
    super.onCreate(savedInstanceState)

    splashScreen.setKeepOnScreenCondition { viewModel.isLoading.value }
    setContent {
      val uiState by viewModel.state.collectAsStateWithLifecycle()
      when (val state = uiState) {
        is UiState.Content -> {
          UniappApp(userLogged = state.logged)
        }
        UiState.Loading -> {
          // showing splash screen
        }
      }
    }
  }
}
