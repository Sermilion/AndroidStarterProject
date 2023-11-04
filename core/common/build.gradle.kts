@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.readian.android.library)
    alias(libs.plugins.readian.android.library.jacoco)
    alias(libs.plugins.readian.android.hilt)
}

android {
    namespace = "io.readian.android.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}
