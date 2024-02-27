@file:Suppress("UnstableApiUsage")

import com.moonila.util.libs
import gradle.kotlin.dsl.accessors._f6236583583f76e66ad2c169bded4799.implementation
import gradle.kotlin.dsl.accessors._f6236583583f76e66ad2c169bded4799.kotlinOptions

plugins {
    id("com.android.library")
    kotlin("android")

    id("com.moonila.checks.detekt")
    id("com.moonila.checks.ktlint")
    id("com.moonila.checks.spotless")
}

repositories {
    applyDefault()
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidx.compose.compiler.get()
    }

    kotlinOptions {
        jvmTarget = "18"
    }

    sourceSets.all {
        java.srcDirs("src/$name/kotlin")
    }

    dependencies {
        implementation(libs.koin.core)
        implementation(libs.koin.androidx.compose)
        implementation(libs.kotlinx.coroutines.core)
    }
}

kotlin {
    jvmToolchain(18)

    sourceSets.all {
        languageSettings.apply {
            optIn("kotlin.RequiresOptIn")
            optIn("androidx.compose.animation.ExperimentalAnimationApi")
            optIn("androidx.compose.material3.ExperimentalMaterial3Api")
            optIn("androidx.compose.ui.unit.ExperimentalUnitApi")
        }
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
