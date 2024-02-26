@file:Suppress("DSL_SCOPE_VIOLATION")

import com.moonila.ANDROID_PACKAGE
import com.moonila.join


plugins {
    `android-common-plugin`
    alias(libs.plugins.ksp)
}

android {
    namespace = ANDROID_PACKAGE.join(
        projects.core,
        projects.core.util
    )
}

dependencies {
    implementation(libs.koin.core)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.core)

    implementation(projects.core.network)
}
