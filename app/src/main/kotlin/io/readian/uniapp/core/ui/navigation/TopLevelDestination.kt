package io.readian.uniapp.core.ui.navigation

import androidx.annotation.StringRes
import io.readian.uniapp.core.navigation.UniAppNavigationDestination
import io.readian.uniapp.core.designsystem.icon.Icon

data class TopLevelDestination(
    override val route: String,
    override val destination: String,
    val selectedIcon: Icon,
    @StringRes val iconTextResource: Int,
) : UniAppNavigationDestination
