package features.splash.contract

import core.vm.contracts.UIContract

sealed interface SplashNavigation : UIContract.Navigation

//data object NavigateToMainFlow : SplashNavigation {
//    override val event: NavigationEvent = NavigationEvent.NavigateAndPopUpToRoute(
//        route = NavigationScreen.SocialNavScreen.route,
//        popUpTo = NavigationScreen.SplashNavScreen.route,
//        rootRoute = true
//    )
//}
//
//data object NavigateToOnboarding : SplashNavigation {
//    override val event: NavigationEvent = NavigationEvent.NavigateAndPopUpToRoute(
//        route = NavigationScreen.OnboardingNavScreen.route,
//        popUpTo = NavigationScreen.SplashNavScreen.route,
//        rootRoute = false
//    )
//}