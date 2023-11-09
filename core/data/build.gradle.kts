@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.readian.android.library)
    alias(libs.plugins.readian.android.library.jacoco)
    alias(libs.plugins.readian.android.hilt)
    id("kotlinx-serialization")
    alias(libs.plugins.readian.android.room)
}

android {
    namespace = "com.google.samples.apps.readian.core.data"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

android {
    namespace = "io.readian.android.core.data"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.database)
    implementation(libs.androidx.datastore)
    implementation(libs.protobuf.kotlin.lite)

    implementation(libs.androidx.core.ktx)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.performance)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.timber)
}
