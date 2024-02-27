package features.onboarding.presentation.contract

import core.vm.contracts.UIContract
import features.onboarding.presentation.model.OnboardingStep

data class OnboardingViewState(
    val isLoading: Boolean = false,
    val step: OnboardingStep = OnboardingStep.entries.first()
): UIContract.State