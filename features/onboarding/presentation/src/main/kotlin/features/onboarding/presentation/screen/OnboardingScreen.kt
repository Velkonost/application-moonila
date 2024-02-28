package features.onboarding.presentation.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import features.onboarding.presentation.screen.components.BackgroundImage
import features.onboarding.presentation.screen.components.GenderStep
import features.onboarding.presentation.screen.components.NameStep
import features.onboarding.presentation.screen.components.OnboardingProgressBar
import features.onboarding.presentation.screen.components.StepText

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    viewModel: OnboardingViewModel
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

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
            else -> {


            }
        }

        Column {
            AnimatedVisibility(
                visible = state.step.position > OnboardingStep.Text3.position,
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
                visible = state.step.position >= OnboardingStep.Text3.position,
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