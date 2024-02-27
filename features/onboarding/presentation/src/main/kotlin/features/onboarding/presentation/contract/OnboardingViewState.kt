package features.onboarding.presentation.contract

import core.vm.contracts.UIContract

data class OnboardingViewState(
    val isLoading: Boolean = false
): UIContract.State