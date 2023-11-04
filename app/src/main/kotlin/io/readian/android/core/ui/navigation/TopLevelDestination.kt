package io.readian.android.core.ui.navigation

import androidx.annotation.StringRes
import io.readian.android.core.navigation.ReadianNavigationDestination
import io.readian.android.designsystem.icon.Icon

data class TopLevelDestination(
    override val route: String,
    override val destination: String,
    val selectedIcon: Icon,
    @StringRes val iconTextResource: Int,
) : ReadianNavigationDestination
