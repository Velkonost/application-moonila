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
        projects.core.compose,
        projects.core.compose.wheelpicker
    )
}

dependencies {
    implementation("dev.chrisbanes.snapper:snapper:0.3.0")

}
