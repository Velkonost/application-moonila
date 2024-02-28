@file:Suppress("DSL_SCOPE_VIOLATION")

import com.moonila.ANDROID_PACKAGE
import com.moonila.join

plugins {
    `android-ui-plugin`
    alias(libs.plugins.ksp)
}

android {
    namespace = ANDROID_PACKAGE.join(
        projects.core,
        projects.core.compose,
        projects.core.compose.datepicker
    )
}

