enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Moonila"
include(
    ":app",
    ":activity",
    ":core:compose",
    ":core:datastore",
    ":core:model",
    ":core:network",
    ":core:util",
    ":core:vm",
    ":umbrella",

    ":features:onboarding:api",
    ":features:onboarding:data",
    ":features:onboarding:presentation",

    ":features:splash:api",
    ":features:splash:data",
    ":features:splash:presentation",
)
