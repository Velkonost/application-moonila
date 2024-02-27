package features.onboarding.presentation

import core.vm.BaseViewModel
import features.onboarding.api.OnboardingRepository
import features.onboarding.presentation.contract.OnboardingAction
import features.onboarding.presentation.contract.OnboardingEvent
import features.onboarding.presentation.contract.OnboardingNavigation
import features.onboarding.presentation.contract.OnboardingViewState
import features.onboarding.presentation.model.OnboardingStep
import kotlinx.coroutines.delay

class OnboardingViewModel
internal constructor(
    private val onboardingRepository: OnboardingRepository
) : BaseViewModel<OnboardingViewState, OnboardingAction, OnboardingNavigation, OnboardingEvent>(
    initialState = OnboardingViewState()
) {

    init {
        processTextSteps()
    }

    override fun dispatch(action: OnboardingAction) = when (action) {
        is OnboardingAction.NextStepClick -> increaseStep()
    }

    private fun processTextSteps() {
        val textDelay = 3000L
        launchJob {
            while (viewState.value.step != OnboardingStep.getNextStep(OnboardingStep.Text2)) {
                delay(textDelay)
                increaseStep()
            }
        }
    }

    private fun increaseStep() {
        val nextStep = OnboardingStep.getNextStep(viewState.value.step)
        if (nextStep != null) {
            emit(viewState.value.copy(step = nextStep))
        }
    }

}