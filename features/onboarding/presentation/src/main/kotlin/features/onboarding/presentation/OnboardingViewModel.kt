package features.onboarding.presentation

import core.vm.BaseViewModel
import features.onboarding.presentation.contract.OnboardingAction
import features.onboarding.presentation.contract.OnboardingEvent
import features.onboarding.presentation.contract.OnboardingNavigation
import features.onboarding.presentation.contract.OnboardingViewState


class OnboardingViewModel
internal constructor(
) : BaseViewModel<OnboardingViewState, OnboardingAction, OnboardingNavigation, OnboardingEvent>(
    initialState = OnboardingViewState()
) {

    init {
    }


    override fun dispatch(action: OnboardingAction) = when (action) {
        else -> {

        }
    }

}