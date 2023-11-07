package io.readian.uniapp.main.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import io.readian.android.onboarding.PasswordRecovery.PasswordRecoveryViewModel
import io.readian.android.onboarding.login.LoginScreen
import io.readian.android.onboarding.welcome.ui.WelcomeScreen
import io.readian.uniapp.core.ui.app.ReadianApp
import io.readian.uniapp.designsystem.theme.ReadianTheme
import io.readian.uniapp.main.MainActivityViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        splashScreen.setKeepOnScreenCondition { viewModel.isLoading.value }
        setContent {
            ReadianTheme {
                LoginScreen()
            }

//            ReadianApp()
        }
    }
}
