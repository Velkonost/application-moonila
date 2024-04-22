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
        projects.features.profile,
        projects.features.profile.presentation
    )
}

dependencies {
    implementation(projects.core.vm)
    implementation(projects.core.util)
    implementation(projects.core.model)
    implementation(projects.core.compose)
    
    implementation(projects.features.profile.api)
}
