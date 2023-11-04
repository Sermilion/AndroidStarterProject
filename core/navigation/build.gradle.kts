@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.readian.android.library)
    alias(libs.plugins.readian.android.library.jacoco)
}

android {
    namespace = "io.readian.android.core.navigation"
}
