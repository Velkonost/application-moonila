package features.splash.presentation

import core.vm.BaseViewModel
import features.splash.api.SplashRepository
import features.splash.presentation.contract.SplashAction
import features.splash.presentation.contract.SplashEvent
import features.splash.presentation.contract.SplashNavigation
import features.splash.presentation.contract.SplashViewState
import kotlinx.coroutines.delay

class SplashViewModel
internal constructor(
    private val splashRepository: SplashRepository
) : BaseViewModel<SplashViewState, SplashAction, SplashNavigation, SplashEvent>(
    initialState = SplashViewState()
) {

    init {
        setupStartDestination()
    }
    
    private fun setupStartDestination() {
        launchJob {
            delay(1500)
//            val isLoggedIn = authRepository.isUserLoggedIn()
            val shouldShowOnboarding = splashRepository.showOnboarding()

//            val startDestination = if (isLoggedIn) NavigateToMainFlow
//            else if (shouldShowOnboarding) NavigateToOnboarding
//            else NavigateToAuth

//            val startDestination = if (shouldShowOnboarding) SplashNavigation.NavigateToOnboarding
//            else NavigateToAuth

            emit(SplashNavigation.NavigateToOnboarding)
        }
    }

    override fun dispatch(action: SplashAction) = when (action) {
        else -> {

        }
    }

}