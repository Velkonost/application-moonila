@file:Suppress("DSL_SCOPE_VIOLATION")

import com.moonila.util.libs

plugins {
    `android-common-plugin`
}

android {
    namespace = com.moonila.ANDROID_PACKAGE
}

dependencies {
    implementation(projects.core.datastore)
    implementation(projects.core.network)

    implementation(projects.features.splash.data)
    implementation(projects.features.splash.presentation)

    implementation(projects.features.onboarding.data)
    implementation(projects.features.onboarding.presentation)

    implementation(projects.features.paywall.data)
    implementation(projects.features.paywall.presentation)

    implementation(projects.features.feed.data)
    implementation(projects.features.feed.presentation)

    implementation(projects.features.selfknowledge.data)
    implementation(projects.features.selfknowledge.presentation)

    implementation(projects.features.compatibility.data)
    implementation(projects.features.compatibility.presentation)

    implementation(projects.features.practice.data)
    implementation(projects.features.practice.presentation)

    implementation(projects.features.wisdom.data)
    implementation(projects.features.wisdom.presentation)

    implementation(projects.features.mooninsight.presentation)

    implementation(libs.koin.core)
}
