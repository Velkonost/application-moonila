package activity.di

import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import core.compose.provide
import core.vm.navigation.NavigationScreen
import features.compatibility.presentation.screen.CompatibilityNavRoute
import features.feed.presentation.screen.FeedNavRoute
import features.mooninsight.presentation.screen.MoonInsightNavRoute
import features.onboarding.presentation.screen.OnboardingNavRoute
import features.paywall.presentation.screen.PaywallNavRoute
import features.practice.presentation.screen.PracticeNavRoute
import features.selfknowledge.presentation.screen.SelfKnowledgeNavRoute
import features.splash.presentation.screen.SplashNavRoute
import features.wisdom.presentation.screen.WisdomNavRoute

val AppScreens = setOf(
    PaywallNavRoute
//    AuthNavRoute,
//    AddAreaNavRoute,
//    NoteDetailNavRoute,
//    TaskDetailNavRoute,
//    AbilityDetailsNavRoute,
//    SubscriptionNavRoute
)

val NavigationScreens = setOf(
    FeedNavRoute,
    CompatibilityNavRoute,
    SelfKnowledgeNavRoute,
    PracticeNavRoute,
    WisdomNavRoute
)

fun NavGraphBuilder.addSplashRoute(
    navController: NavHostController,
    forceHideBottomBar: MutableState<Boolean>
) {
    navigation(
        route = "${NavigationScreen.SplashNavScreen.route}_root",
        startDestination = NavigationScreen.SplashNavScreen.route
    ) {
        SplashNavRoute.provide(this, navController, forceHideBottomBar)
        OnboardingNavRoute.provide(this, navController, forceHideBottomBar)
    }
}

fun NavGraphBuilder.addFeedRoute(
    navController: NavHostController,
    forceHideBottomBar: MutableState<Boolean>
) {
    navigation(
        route = "${NavigationScreen.FeedNavScreen.route}_root",
        startDestination = NavigationScreen.FeedNavScreen.route
    ) {
        FeedNavRoute.provide(this, navController, forceHideBottomBar)
        MoonInsightNavRoute.provide(this, navController, forceHideBottomBar)
    }
}

fun NavGraphBuilder.addSelfKnowledgeRoute(
    navController: NavHostController,
    forceHideBottomBar: MutableState<Boolean>
) {
    navigation(
        route = "${NavigationScreen.SelfKnowledgeNavScreen.route}_root",
        startDestination = NavigationScreen.SelfKnowledgeNavScreen.route
    ) {
        SelfKnowledgeNavRoute.provide(this, navController, forceHideBottomBar)
    }
}

fun NavGraphBuilder.addCompatibilityRoute(
    navController: NavHostController,
    forceHideBottomBar: MutableState<Boolean>
) {
    navigation(
        route = "${NavigationScreen.CompatibilityNavScreen.route}_root",
        startDestination = NavigationScreen.CompatibilityNavScreen.route
    ) {
        CompatibilityNavRoute.provide(this, navController, forceHideBottomBar)
    }
}

fun NavGraphBuilder.addPracticeRoute(
    navController: NavHostController,
    forceHideBottomBar: MutableState<Boolean>
) {
    navigation(
        route = "${NavigationScreen.PracticeNavScreen.route}_root",
        startDestination = NavigationScreen.PracticeNavScreen.route
    ) {
        PracticeNavRoute.provide(this, navController, forceHideBottomBar)
    }
}

fun NavGraphBuilder.addWisdomRoute(
    navController: NavHostController,
    forceHideBottomBar: MutableState<Boolean>
) {
    navigation(
        route = "${NavigationScreen.WisdomNavScreen.route}_root",
        startDestination = NavigationScreen.WisdomNavScreen.route
    ) {
        WisdomNavRoute.provide(this, navController, forceHideBottomBar)
    }
}