package features.splash.presentation.contract

import core.vm.contracts.UIContract
import core.vm.navigation.NavigationEvent
import core.vm.navigation.NavigationScreen

sealed interface SplashNavigation : UIContract.Navigation {

    data object NavigateToMainFlow : SplashNavigation {
        override val event: NavigationEvent = NavigationEvent.NavigateAndPopUpToRoute(
            route = NavigationScreen.FeedNavScreen.route,
            popUpTo = NavigationScreen.SplashNavScreen.route,
            rootRoute = true
        )
    }

    data object NavigateToOnboarding : SplashNavigation {
        override val event: NavigationEvent = NavigationEvent.NavigateAndPopUpToRoute(
            route = NavigationScreen.OnboardingNavScreen.route,
            popUpTo = NavigationScreen.SplashNavScreen.route,
            rootRoute = false
        )
    }
}