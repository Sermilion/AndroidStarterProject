package io.readian.android.core.ui.navigation.destinations

import io.readian.android.core.navigation.ReadianNavigationDestination

object Spotlight : ReadianNavigationDestination {
    override val route: String = "spotlight_route"
    override val destination: String = "spotlight_destination"
}

object Library : ReadianNavigationDestination {
    override val route: String = "library_route"
    override val destination: String = "library_destination"
}

object Profile : ReadianNavigationDestination {
    override val route: String = "profile_route"
    override val destination: String = "profile_destination"
}
