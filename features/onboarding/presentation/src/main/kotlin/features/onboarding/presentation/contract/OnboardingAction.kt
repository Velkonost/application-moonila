package features.onboarding.presentation.contract

import core.vm.contracts.UIContract
import features.onboarding.presentation.model.Gender

sealed interface OnboardingAction: UIContract.Action {

    data object NextStepClick : OnboardingAction

    data class NameChanged(val value: String) : OnboardingAction

    data class GenderSelect(val value: Gender) : OnboardingAction

}