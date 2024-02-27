package features.onboarding.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import features.onboarding.presentation.OnboardingViewModel
import features.onboarding.presentation.contract.OnboardingAction
import features.onboarding.presentation.model.OnboardingStep
import features.onboarding.presentation.screen.components.BackgroundImage
import features.onboarding.presentation.screen.components.StepText

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    viewModel: OnboardingViewModel
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    Box(
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    viewModel.dispatch(OnboardingAction.NextStepClick)
                }
            )
    ) {
        BackgroundImage(step = state.step)

        when (state.step) {
            OnboardingStep.Text1, OnboardingStep.Text2, OnboardingStep.Text3 -> StepText(step = state.step)
            else -> {

            }
        }

    }

}