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
    ":core:compose:wheelpicker",
    ":core:datastore",
    ":core:model",
    ":core:network",
    ":core:util",
    ":core:vm",
    ":umbrella",

    ":features:splash:api",
    ":features:splash:data",
    ":features:splash:presentation",

    ":features:onboarding:api",
    ":features:onboarding:data",
    ":features:onboarding:presentation",

    ":features:paywall:api",
    ":features:paywall:data",
    ":features:paywall:presentation",

    ":features:feed:api",
    ":features:feed:data",
    ":features:feed:presentation",

    ":features:mooninsight:api",
    ":features:mooninsight:data",
    ":features:mooninsight:presentation",

    ":features:compatibility:api",
    ":features:compatibility:data",
    ":features:compatibility:presentation",

    ":features:selfknowledge:api",
    ":features:selfknowledge:data",
    ":features:selfknowledge:presentation",
)
