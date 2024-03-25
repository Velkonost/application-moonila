package core.vm.navigation

sealed class NavigationScreen(val route: String) {
    data object SplashNavScreen : NavigationScreen(SPLASH_DESTINATION)

    data object OnboardingNavScreen : NavigationScreen(ONBOARDING_DESTINATION)

    data object PaywallNavScreen : NavigationScreen(PAYWALL_DESTINATION)

    data object FeedNavScreen : NavigationScreen(FEED_DESTINATION)

    data object MoonInsightNavScreen : NavigationScreen(
        "$MOON_INSIGHT_DESTINATION/?$ARG_MOON_INSIGHT_TYPE={$ARG_MOON_INSIGHT_TYPE}"
    )

    data object SelfKnowledgeNavScreen : NavigationScreen(SELF_KNOWLEDGE_DESTINATION)

    data object CompatibilityNavScreen : NavigationScreen(COMPATIBILITY_DESTINATION)

    data object PracticeNavScreen : NavigationScreen(PRACTICE_DESTINATION)

    data object WisdomNavScreen : NavigationScreen(WISDOM_DESTINATION)
}

const val NAV_PREFIX: String = "com.moonila"

const val SPLASH_DESTINATION: String = "$NAV_PREFIX.splash/SplashScreen"
const val ONBOARDING_DESTINATION: String = "$NAV_PREFIX.splash/OnboardingScreen"
const val PAYWALL_DESTINATION: String = "$NAV_PREFIX.paywall/PaywallScreen"

const val FEED_DESTINATION: String = "$NAV_PREFIX.feed/FeedScreen"
const val MOON_INSIGHT_DESTINATION: String = "$NAV_PREFIX.feed/MoonInsightScreen"

const val SELF_KNOWLEDGE_DESTINATION: String = "$NAV_PREFIX.selfknowledge/SelfKnowledgeScreen"
const val COMPATIBILITY_DESTINATION: String = "$NAV_PREFIX.compatibility/CompatibilityScreen"
const val PRACTICE_DESTINATION: String = "$NAV_PREFIX.practice/PracticeScreen"
const val WISDOM_DESTINATION: String = "$NAV_PREFIX.wisdom/WisdomScreen"

const val ARG_MOON_INSIGHT_TYPE: String = "arg_moon_insight_type"
