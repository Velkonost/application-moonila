package core.vm.navigation

sealed class NavigationScreen(val route: String) {
    data object SplashNavScreen : NavigationScreen(SPLASH_DESTINATION)

    data object OnboardingNavScreen : NavigationScreen(ONBOARDING_DESTINATION)

    data object PaywallNavScreen : NavigationScreen(PAYWALL_DESTINATION)

    data object FeedNavScreen : NavigationScreen(FEED_DESTINATION)

    data object MoonInsightNavScreen : NavigationScreen(MOON_INSIGHT_DESTINATION)
}

const val NAV_PREFIX: String = "com.moonila"

const val SPLASH_DESTINATION: String = "$NAV_PREFIX.splash/SplashScreen"
const val ONBOARDING_DESTINATION: String = "$NAV_PREFIX.splash/OnboardingScreen"
const val PAYWALL_DESTINATION: String = "$NAV_PREFIX.paywall/PaywallScreen"

const val FEED_DESTINATION: String = "$NAV_PREFIX.feed/FeedScreen"
const val MOON_INSIGHT_DESTINATION: String = "$NAV_PREFIX.feed/MoonInsightScreen"
