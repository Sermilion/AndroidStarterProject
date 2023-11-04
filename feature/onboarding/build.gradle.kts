@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.readian.android.feature)
    alias(libs.plugins.readian.android.library.compose)
}

android {
    namespace = "io.readian.android.core.onboarding"
}
