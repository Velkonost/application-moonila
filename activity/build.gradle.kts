import com.moonila.ANDROID_PACKAGE
import com.moonila.join

plugins {
    `android-ui-plugin`
}

android {
    namespace = ANDROID_PACKAGE.join(projects.activity)
}

dependencies {
    implementation(projects.core.compose)

    implementation(projects.features.splash.presentation)

    implementation(projects.core.vm)
    implementation(projects.core.util)

    implementation(libs.firebase.android.analytics)
}
