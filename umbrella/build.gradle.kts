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
    implementation(libs.koin.core)
}
