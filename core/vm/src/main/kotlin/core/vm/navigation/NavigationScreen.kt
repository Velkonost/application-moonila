package core.vm.navigation

sealed class NavigationScreen(val route: String) {
    data object SplashNavScreen : NavigationScreen(SPLASH_DESTINATION)

    data object OnboardingNavScreen : NavigationScreen(ONBOARDING_DESTINATION)
}

const val NAV_PREFIX: String = "com.moonila"

const val SPLASH_DESTINATION: String = "$NAV_PREFIX.splash/SplashScreen"
const val ONBOARDING_DESTINATION: String = "$NAV_PREFIX.splash/OnboardingScreen"