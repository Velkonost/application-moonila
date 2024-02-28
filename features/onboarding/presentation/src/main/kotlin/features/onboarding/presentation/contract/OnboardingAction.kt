package features.onboarding.presentation.contract

import core.vm.contracts.UIContract

sealed interface OnboardingAction: UIContract.Action {

    data object NextStepClick : OnboardingAction

    data class NameChanged(val value: String) : OnboardingAction

}