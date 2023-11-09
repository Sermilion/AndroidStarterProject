@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  alias(libs.plugins.readian.android.library)
  alias(libs.plugins.readian.android.library.jacoco)
  alias(libs.plugins.readian.android.hilt)
  alias(libs.plugins.readian.android.room)
}

android {
  namespace = "io.readian.android.core.database"
}

dependencies {
  implementation(libs.kotlinx.coroutines.android)
  implementation(libs.kotlinx.datetime)
}