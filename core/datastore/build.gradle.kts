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
        projects.core.datastore
    )
}


dependencies {
    api(libs.datastore)

    implementation(libs.koin.core)
    implementation(libs.kotlinx.coroutines.core)
}
