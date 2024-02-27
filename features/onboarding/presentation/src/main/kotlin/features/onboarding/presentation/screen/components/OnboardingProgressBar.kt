package features.onboarding.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.moonila.features.onboarding.presentation.R


@Composable
fun OnboardingProgressBar(
    modifier: Modifier = Modifier,
    percent: Int
) {

    val width = remember { 220.dp }

    Box(
        modifier = modifier
            .background(
                color = colorResource(id = R.color.progress_bar_bg),
                shape = RoundedCornerShape(6.dp)
            )
            .width(width)
            .height(4.dp)
    ) {
        Box(
            modifier = modifier
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            colorResource(id = com.moonila.core.compose.R.color.orange_gradient_start),
                            colorResource(id = com.moonila.core.compose.R.color.orange_gradient_end)
                        )
                    ),
                    shape = RoundedCornerShape(6.dp)
                )
                .height(4.dp)
                .width(width * percent / 100)
        )
    }
}