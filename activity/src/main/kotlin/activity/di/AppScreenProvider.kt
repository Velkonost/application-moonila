package activity.di

import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import core.compose.provide
import core.vm.navigation.NavigationScreen
import features.onboarding.presentation.screen.OnboardingNavRoute
import features.paywall.presentation.screen.PaywallNavRoute
import features.splash.presentation.screen.SplashNavRoute

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
    SplashNavRoute,
//    DiaryNavRoute,
//    CalendarsNavRoute,
//    AbilitiesNavRoute,
//    ProfileNavRoute
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