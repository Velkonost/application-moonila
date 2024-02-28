@file:Suppress("DSL_SCOPE_VIOLATION")

import com.moonila.ANDROID_PACKAGE
import com.moonila.join

plugins {
    `android-common-plugin`
    alias(libs.plugins.ksp)
}

android {
    namespace = ANDROID_PACKAGE.join(
        projects.features,
        projects.features.onboarding,
        projects.features.onboarding.presentation
    )
}

dependencies {
    api(projects.core.vm)
    api(projects.core.util)

    implementation(libs.koin.core)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.koin.androidx.compose)

    api(projects.core.model)
    implementation(projects.core.compose)
    implementation(projects.core.compose.datepicker)
    implementation(projects.features.onboarding.api)
}
