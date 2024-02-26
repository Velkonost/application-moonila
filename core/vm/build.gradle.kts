@file:Suppress("DSL_SCOPE_VIOLATION")

import com.moonila.ANDROID_PACKAGE
import com.moonila.join
import com.moonila.util.libs

plugins {
    `android-common-plugin`
    alias(libs.plugins.ksp)
}

android {
    namespace = ANDROID_PACKAGE.join(
        projects.core,
        projects.core.vm
    )
}

dependencies {
    implementation(libs.koin.core)
    implementation(libs.kotlinx.coroutines.core)

//    api(libs.rickclephas.kmm.viewmodel)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(projects.core.util)
    implementation(projects.core.model)
}

