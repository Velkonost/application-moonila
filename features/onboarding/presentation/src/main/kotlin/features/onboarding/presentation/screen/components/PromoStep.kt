package features.onboarding.presentation.screen.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.onboarding.presentation.R
import core.compose.components.TextWithGradientPart
import features.onboarding.presentation.di.OnboardingPresentationModule
import features.onboarding.presentation.model.OnboardingStep

@Composable
fun PromoStep(
    modifier: Modifier = Modifier,
    step: OnboardingStep
) {

    val image = painterResource(
        id = when(step) {
            OnboardingStep.Promo1 -> R.drawable.ic_promo_1
            OnboardingStep.Promo2 -> R.drawable.ic_promo_2
            else -> R.drawable.ic_promo_3
        }
    )

    val title = stringResource(
        id = when(step) {
            OnboardingStep.Promo1 -> R.string.promo_1_title
            OnboardingStep.Promo2 -> R.string.promo_2_title
            else -> R.string.promo_3_title
        }
    )

    val textPrefix = stringResource(
        id = when(step) {
            OnboardingStep.Promo1 -> R.string.promo_1_text_prefix
            OnboardingStep.Promo2 -> R.string.promo_2_text_prefix
            else -> R.string.promo_3_text_prefix
        }
    )

    val textOrange = stringResource(
        id = when(step) {
            OnboardingStep.Promo1 -> R.string.promo_1_text_orange
            OnboardingStep.Promo2 -> R.string.promo_2_text_orange
            else -> R.string.promo_3_text_orange
        }
    )

    val textSuffix = stringResource(
        id = when(step) {
            OnboardingStep.Promo1 -> R.string.promo_1_text_suffix
            OnboardingStep.Promo2 -> R.string.promo_2_text_suffix
            else -> R.string.promo_3_text_suffix
        }
    )

    Column(
        modifier = modifier
            .padding(top = 100.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedContent(
            targetState = image, label = "",
            transitionSpec = {
                (fadeIn(animationSpec = tween(300)))
                    .togetherWith(fadeOut(animationSpec = tween(300)))
            }
        ) {
            Image(
                modifier = modifier.fillMaxWidth(),
                painter = it,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier.height(22.dp))

        AnimatedContent(
            targetState = title,
            label = "",
            transitionSpec = {
                (fadeIn(animationSpec = tween(300, delayMillis = 300)))
                    .togetherWith(fadeOut(animationSpec = tween(300)))
            }
        ) {
            TextWithGradientPart(
                text = it,
                commonTextColor = colorResource(id = R.color.title_color),
                textSize = 24.sp,
                fontWeight = FontWeight.Medium,
                colorfulTextAtEnd = ""
            )
        }

        Spacer(modifier.height(8.dp))

        AnimatedContent(
            targetState = textOrange,
            label = "",
            transitionSpec = {
                (fadeIn(animationSpec = tween(300, delayMillis = 300)))
                    .togetherWith(fadeOut(animationSpec = tween(300)))
            }
        ) {
            TextWithGradientPart(
                text = textPrefix,
                suffix = textSuffix,
                commonTextColor = colorResource(id = com.moonila.core.compose.R.color.common_text_color),
                textSize = 16.sp,
                fontWeight = FontWeight.Normal,
                colorfulTextAtEnd = it
            )
        }



    }

}