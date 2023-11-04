import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import io.readian.android.ReadianBuildType

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("kapt")
    alias(libs.plugins.protobuf)
    alias(libs.plugins.ksp)
    alias(libs.plugins.readian.android.application)
    alias(libs.plugins.readian.android.application.compose)
    alias(libs.plugins.readian.android.application.flavors)
    alias(libs.plugins.readian.android.application.jacoco)
    alias(libs.plugins.readian.android.hilt)
    id("jacoco")
    alias(libs.plugins.readian.android.application.firebase)
}

val localProperties by lazy {
    gradleLocalProperties(rootDir)
}

android {
    namespace = "io.readian.android"

    defaultConfig {
        applicationId = "io.readian.android"
        versionCode = localProperties.getProperty("version.code", "9999").toInt()
        versionName = localProperties.getProperty("version.name", "DEV")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ReadianBuildType.DEBUG.applicationIdSuffix
        }
        val release by getting {
            isMinifyEnabled = true
            applicationIdSuffix = ReadianBuildType.RELEASE.applicationIdSuffix
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            signingConfig = try {
                signingConfigs.getByName("release")
            } catch (e: UnknownDomainObjectException) {
                signingConfigs.getByName("debug")
            }
        }
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("META-INF/versions/**")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                val java by registering {
                    option("lite")
                }
                val kotlin by registering {
                    option("lite")
                }
            }
        }
    }
}

dependencies {
    coreLibraryDesugaring(libs.android.desugarJdkLibs)

    implementation(project(":core:designsystem"))
    implementation(project(":core:navigation"))
    implementation(project(":feature:onboarding"))

    androidTestImplementation(kotlin("test"))

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.window.manager)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.kotlinx.coroutines.guava)
    implementation(libs.coil.kt)

    implementation(libs.compose.material3)
    implementation(libs.compose.material)
    implementation(libs.compose.material.icons)
    implementation(libs.compose.constraintlayout)

    implementation(libs.kotlinx.collections.immutable)

    implementation(libs.okhttp)
    implementation(libs.retrofit)

    implementation(libs.play.update.compose)

    implementation(libs.timber)

    // Core functions
    testImplementation(libs.androidx.navigation.testing)
    testImplementation(libs.accompanist.testharness)
    testImplementation(libs.work.testing)
    testImplementation(kotlin("test"))
    kaptTest(libs.hilt.compiler)
}
