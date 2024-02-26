@file:Suppress("DSL_SCOPE_VIOLATION")

import com.moonila.ANDROID_PACKAGE
import com.moonila.join

plugins {
    `android-app-plugin`
    alias(libs.plugins.android.crashlytics)
}

android {
    namespace = ANDROID_PACKAGE.join(projects.app)
}

dependencies {
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
    implementation(libs.firebase.android.analytics)

    implementation(projects.umbrella)
    implementation(projects.activity)
}
