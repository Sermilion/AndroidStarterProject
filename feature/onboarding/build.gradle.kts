@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  alias(libs.plugins.readian.android.feature)
  alias(libs.plugins.readian.android.library.compose)
  alias(libs.plugins.readian.android.library.jacoco)
}

android {
  namespace = "io.readian.android.feature.onboarding"
}

dependencies {

}
