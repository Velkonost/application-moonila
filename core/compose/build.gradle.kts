@file:Suppress("DSL_SCOPE_VIOLATION")

import com.moonila.ANDROID_PACKAGE
import com.moonila.join
import com.moonila.util.libs

plugins {
    `android-ui-plugin`
}

android {
    namespace = ANDROID_PACKAGE.join(
        projects.core,
        projects.core.compose
    )
}

dependencies {
    implementation(libs.android.compose.lootie)
    implementation(libs.androidx.compose.paging)

    implementation(projects.core.vm)
    implementation(projects.core.util)
    implementation(projects.core.model)
}
