package features.onboarding.presentation.contract

import core.vm.contracts.UIContract
import core.vm.navigation.NavigationEvent
import core.vm.navigation.NavigationScreen

sealed interface OnboardingNavigation: UIContract.Navigation {

    data object NavigateToMainFlow : OnboardingNavigation {
        override val event: NavigationEvent = NavigationEvent.NavigateAndPopUpToRoute(
            route = NavigationScreen.FeedNavScreen.route,
            popUpTo = NavigationScreen.OnboardingNavScreen.route,
            rootRoute = true
        )
    }

}