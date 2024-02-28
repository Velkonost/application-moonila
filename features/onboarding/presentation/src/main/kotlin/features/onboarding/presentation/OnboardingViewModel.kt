package features.onboarding.presentation

import core.vm.BaseViewModel
import features.onboarding.api.OnboardingRepository
import features.onboarding.presentation.contract.OnboardingAction
import features.onboarding.presentation.contract.OnboardingEvent
import features.onboarding.presentation.contract.OnboardingNavigation
import features.onboarding.presentation.contract.OnboardingViewState
import features.onboarding.presentation.model.Gender
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
        is OnboardingAction.NameChanged -> obtainNameChanged(action.value)
        is OnboardingAction.GenderSelect -> obtainGenderSelect(action.value)
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
            emit(viewState.value.copy(step = nextStep, canGoNextStep = nextStep.canGoNextAfk ))
        }
    }

    private fun obtainNameChanged(value: String) {
        val canGoNext = value.length > NAME_REQUIRED_LENGTH
        emit(viewState.value.copy(nameValue = value, canGoNextStep = canGoNext))
    }

    private fun obtainGenderSelect(value: Gender) {
        val genderViewState = viewState.value.genderViewState.copy(selectedItem = value)
        emit(viewState.value.copy(genderViewState = genderViewState, canGoNextStep = true))
    }

    companion object {
        private const val NAME_REQUIRED_LENGTH = 5
    }

}