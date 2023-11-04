@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.readian.android.library)
    alias(libs.plugins.readian.android.hilt)
    alias(libs.plugins.protobuf)
}

android {
    namespace = "io.readian.android.core.data"
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
    implementation(libs.androidx.datastore)
    implementation(libs.protobuf.kotlin.lite)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.performance)

    implementation(libs.timber)
}
