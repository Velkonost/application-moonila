package features.onboarding.presentation.screen.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.moonila.features.onboarding.presentation.R
import features.onboarding.presentation.model.OnboardingStep

@Composable
fun BackgroundImage(
    modifier: Modifier = Modifier,
    step: OnboardingStep
) {

    val image = painterResource(
        id = when (step) {
            OnboardingStep.Text1 -> R.drawable.bg_1
            OnboardingStep.Text2 -> R.drawable.bg_2
            OnboardingStep.Text3 -> R.drawable.bg_3
            else -> com.moonila.core.compose.R.drawable.bg_default
        }
    )

    AnimatedContent(
        targetState = image,
        label = "",
        transitionSpec = {
            (fadeIn(animationSpec = tween(2000)))
                .togetherWith(fadeOut(animationSpec = tween(500, delayMillis = 2000)))
        }
    ) {
        Image(
            modifier = modifier.fillMaxSize(),
            painter = it,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }

}