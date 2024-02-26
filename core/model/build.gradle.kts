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
        projects.core,
        projects.core.model
    )
}


dependencies {
    implementation(libs.koin.core)
    implementation(libs.kotlinx.serialization)

//    implementation(projects.core.util)
//    implementation(projects.resources)
}

