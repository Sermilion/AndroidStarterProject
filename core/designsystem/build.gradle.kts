@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.readian.android.library)
    alias(libs.plugins.readian.android.library.compose)
    alias(libs.plugins.readian.android.library.jacoco)
}

android {
    namespace = "io.readian.android.core.designsystem"
}

dependencies {
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.compose.material.icons)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.util)
    api(libs.compose.animation)

    debugApi(libs.androidx.compose.ui.tooling)

    implementation(libs.androidx.core.ktx)
    implementation(libs.coil.kt.compose)
}
