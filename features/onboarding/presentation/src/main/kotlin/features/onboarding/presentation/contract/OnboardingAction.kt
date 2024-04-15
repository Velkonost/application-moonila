package features.onboarding.presentation.contract

import core.vm.contracts.UIContract
import features.onboarding.presentation.model.Gender
import features.onboarding.presentation.model.Goal
import features.onboarding.presentation.model.Improve

sealed interface OnboardingAction: UIContract.Action {

    data object NextStepClick : OnboardingAction

    data object SkipClick : OnboardingAction

    data class NameChanged(val value: String) : OnboardingAction

    data class GenderSelect(val value: Gender) : OnboardingAction

    data class ImproveSelect(val value: Improve) : OnboardingAction

    data class GoalSelect(val value: Goal) : OnboardingAction

}