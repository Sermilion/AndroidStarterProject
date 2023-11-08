package io.readian.uniapp.main.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import io.readian.android.onboarding.password_recovery.PasswordRecoveryScreen
import io.readian.android.onboarding.profile.ui.ProfileScreen
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
                ProfileScreen()
            }

//            ReadianApp()
        }
    }
}
