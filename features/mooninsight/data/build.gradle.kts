@file:Suppress("DSL_SCOPE_VIOLATION")

import com.moonila.ANDROID_PACKAGE
import com.moonila.join

plugins {
    `android-common-plugin`
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = ANDROID_PACKAGE.join(
        projects.features,
        projects.features.mooninsight,
        projects.features.mooninsight.data
    )
}

dependencies {
    implementation(libs.koin.core)

    implementation(projects.core.util)
    implementation(projects.core.model)
    implementation(projects.core.network)
    implementation(projects.core.datastore)

    implementation(projects.features.mooninsight.api)
}
