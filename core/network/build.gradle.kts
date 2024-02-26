@file:Suppress("DSL_SCOPE_VIOLATION")

import com.moonila.ANDROID_PACKAGE
import com.moonila.join

plugins {
    `android-common-plugin`
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = ANDROID_PACKAGE.join(
        projects.core,
        projects.core.network
    )
}

dependencies {
    implementation(libs.koin.core)
    api(libs.bundles.ktor.common)
}
