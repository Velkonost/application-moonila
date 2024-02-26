package features.splash

import core.vm.BaseViewModel
import features.splash.contract.SplashAction
import features.splash.contract.SplashEvent
import features.splash.contract.SplashNavigation
import features.splash.contract.SplashViewState

class SplashViewModel
internal constructor(
) : BaseViewModel<SplashViewState, SplashAction, SplashNavigation, SplashEvent>(
    initialState = SplashViewState()
) {

    init {
        setupStartDestination()
    }


    private fun setupStartDestination() {
//        launchJob {
//            delay(500)
//            val isLoggedIn = authRepository.isUserLoggedIn()
//            val shouldShowOnboarding = splashRepository.shouldShowOnboarding()
//
//            val startDestination = if (isLoggedIn) NavigateToMainFlow
//            else if (shouldShowOnboarding) NavigateToOnboarding
//            else NavigateToAuth
//
//            emit(startDestination)
//        }
    }

    override fun dispatch(action: SplashAction) = when (action) {
        else -> {

        }
    }

}