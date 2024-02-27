package features.onboarding.presentation

import core.vm.BaseViewModel
import features.onboarding.presentation.contract.OnboardingAction
import features.onboarding.presentation.contract.OnboardingEvent
import features.onboarding.presentation.contract.OnboardingNavigation
import features.onboarding.presentation.contract.OnboardingViewState
import features.onboarding.presentation.model.OnboardingStep

class OnboardingViewModel
internal constructor(
) : BaseViewModel<OnboardingViewState, OnboardingAction, OnboardingNavigation, OnboardingEvent>(
    initialState = OnboardingViewState()
) {

    override fun dispatch(action: OnboardingAction) = when (action) {
        is OnboardingAction.NextStepClick -> increaseStep()
    }

    private fun increaseStep() {
        val nextStep = OnboardingStep.getNextStep(viewState.value.step)
        if (nextStep != null) {
            emit(viewState.value.copy(step = nextStep))
        }
    }

}