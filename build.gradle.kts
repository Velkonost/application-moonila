buildscript {
    repositories.applyDefault()

    plugins.apply("com.moonila.checks.detekt")
    plugins.apply("com.moonila.checks.ktlint")
    plugins.apply("com.moonila.checks.spotless")
    plugins.apply("com.moonila.checks.dependency-updates")
}
