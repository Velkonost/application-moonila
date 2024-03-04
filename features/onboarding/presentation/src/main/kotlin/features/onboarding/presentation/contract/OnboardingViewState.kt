package features.onboarding.presentation.contract

import core.vm.contracts.UIContract
import features.onboarding.presentation.model.Feedback
import features.onboarding.presentation.model.Gender
import features.onboarding.presentation.model.Goal
import features.onboarding.presentation.model.Improve
import features.onboarding.presentation.model.OnboardingStep

data class OnboardingViewState(
    val isLoading: Boolean = false,
    val step: OnboardingStep = OnboardingStep.entries.last(),
    val canGoNextStep: Boolean = true,

    val nameValue: String = "",
    val genderViewState: GenderViewState = GenderViewState(),
    val dateValue: String = "",
    val improveViewState: ImproveViewState = ImproveViewState(),
    val goalViewState: GoalViewState = GoalViewState(),
    val profileSettingsViewState: ProfileSettingsViewState = ProfileSettingsViewState()
): UIContract.State

data class GenderViewState(
    val items: List<Gender> = Gender.entries,
    val selectedItem: Gender? = null
)

data class ImproveViewState(
    val items: List<Improve> = Improve.entries,
    val selectedItems: List<Improve> = emptyList()
)

data class GoalViewState(
    val items: List<Goal> = Goal.entries,
    val selectedItems: List<Goal> = emptyList()
)

data class ProfileSettingsViewState(
    val feedbacks: List<Feedback> = Feedback.entries
)