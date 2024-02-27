package features.onboarding.presentation.screen.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.onboarding.presentation.R
import core.compose.composable.blueTextGradient
import core.compose.composable.orangeTextGradient
import core.compose.composable.pinkTextGradient
import core.compose.theme.BonaNovaFontFamily
import core.compose.theme.PoppinsFontFamily
import features.onboarding.presentation.model.OnboardingStep

@Composable
fun StepText(
    modifier: Modifier = Modifier,
    step: OnboardingStep
) {

    AnimatedContent(targetState = step, label = "") {
        val title = stringResource(
            id = when (it) {
                OnboardingStep.Text1 -> R.string.text_1_title
                OnboardingStep.Text2 -> R.string.text_2_title
                else -> R.string.text_3_title
            }
        )

        val text = stringResource(
            id = when (it) {
                OnboardingStep.Text1 -> R.string.text_1_text
                OnboardingStep.Text2 -> R.string.text_2_text
                else -> R.string.text_3_text
            }
        )

        val titleStyle = when (it) {
            OnboardingStep.Text1 -> orangeTextGradient(fontSize = 32.sp)
            OnboardingStep.Text2 -> pinkTextGradient(fontSize = 32.sp)
            else -> blueTextGradient(fontSize = 32.sp)
        }

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier.weight(1f))
            Text(
                text = title,
                fontFamily = BonaNovaFontFamily,
                fontWeight = FontWeight.Bold,
                style = titleStyle
            )
            Text(
                modifier = modifier.padding(top = 12.dp),
                text = text,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.text_color),
            )
            Spacer(modifier.weight(1f))
        }
    }
}