package features.onboarding.presentation.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.moonila.core.compose.R
import core.compose.components.AppButton
import core.compose.theme.PoppinsFontFamily
import features.onboarding.presentation.OnboardingViewModel
import features.onboarding.presentation.contract.OnboardingAction
import features.onboarding.presentation.model.OnboardingStep
import features.onboarding.presentation.screen.components.AgeStep
import features.onboarding.presentation.screen.components.BackgroundImage
import features.onboarding.presentation.screen.components.GenderStep
import features.onboarding.presentation.screen.components.GoalsStep
import features.onboarding.presentation.screen.components.ImproveStep
import features.onboarding.presentation.screen.components.NameStep
import features.onboarding.presentation.screen.components.OnboardingProgressBar
import features.onboarding.presentation.screen.components.ProfileSettingsStep
import features.onboarding.presentation.screen.components.PromoStep
import features.onboarding.presentation.screen.components.StepText

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    viewModel: OnboardingViewModel
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()
    val forceHideButton = remember { mutableStateOf(false) }

    Box {
        BackgroundImage(step = state.step)

        when (state.step) {
            OnboardingStep.Text1, OnboardingStep.Text2, OnboardingStep.Text3 -> StepText(step = state.step)
            OnboardingStep.Name -> NameStep(
                value = state.nameValue,
                onValueChanged = {
                    viewModel.dispatch(OnboardingAction.NameChanged(it))
                },
            )

            OnboardingStep.Gender -> GenderStep(
                userName = state.nameValue,
                items = state.genderViewState.items,
                selectedItem = state.genderViewState.selectedItem,
                itemClick = {
                    viewModel.dispatch(OnboardingAction.GenderSelect(it))
                }
            )

            OnboardingStep.Age -> AgeStep(
                userName = state.nameValue
            )

            OnboardingStep.Promo1, OnboardingStep.Promo2, OnboardingStep.Promo3 -> PromoStep(
                step = state.step
            )

            OnboardingStep.Improve -> ImproveStep(
                userName = state.nameValue,
                items = state.improveViewState.items,
                selectedItems = state.improveViewState.selectedItems,
                itemClick = {
                    viewModel.dispatch(OnboardingAction.ImproveSelect(it))
                }
            )

            OnboardingStep.Goals -> GoalsStep(
                userName = state.nameValue,
                items = state.goalViewState.items,
                selectedItems = state.goalViewState.selectedItems,
                itemClick = {
                    viewModel.dispatch(OnboardingAction.GoalSelect(it))
                }
            )

            OnboardingStep.ProfileSettings -> ProfileSettingsStep(
                forceHideButton = forceHideButton,
                feedbacks = state.profileSettingsViewState.feedbacks
            )
        }

        Column {
            AnimatedVisibility(
                visible = state.step.position > OnboardingStep.Age.position && state.step != OnboardingStep.ProfileSettings,
                enter = fadeIn(animationSpec = tween(1000, delayMillis = 1000)),
                exit = fadeOut(animationSpec = tween(1000))
            ) {
                Box {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 23.dp)
                            .padding(top = 32.dp)
                            .height(44.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier.weight(1f))
                        OnboardingProgressBar(percent = state.step.percent)
                        Spacer(modifier.weight(1f))
                    }

                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 23.dp)
                            .padding(top = 32.dp)
                            .height(44.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier.weight(1f))
                        Text(
                            modifier = modifier
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null,
                                    onClick = { viewModel.dispatch(OnboardingAction.SkipClick) }
                                ),
                            text = stringResource(
                                id = com.moonila.features.onboarding.presentation.R.string.skip_btn
                            ),
                            color = colorResource(
                                id = com.moonila.features.onboarding.presentation.R.color.main_text_color
                            ),
                            fontSize = 14.sp,
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            Spacer(modifier.weight(1f))

            AnimatedVisibility(
                visible = state.step.position >= OnboardingStep.Text3.position && !forceHideButton.value,
                enter = fadeIn(animationSpec = tween(1000, delayMillis = 1000)),
                exit = fadeOut(animationSpec = tween(1000))
            ) {
                AppButton(
                    enabled = state.canGoNextStep,
                    label = stringResource(id = R.string.continue_btn),
                    onClick = {
                        viewModel.dispatch(OnboardingAction.NextStepClick)
                    }
                )
            }
        }

    }

}