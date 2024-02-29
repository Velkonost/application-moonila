package features.onboarding.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.onboarding.presentation.R
import core.compose.components.TextWithGradientPart
import core.compose.theme.PoppinsFontFamily
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ProfileSettingsStep(
    modifier: Modifier = Modifier
) {

    /**
     * 6000 msec per 100%
     * 1% = 60millis
     * ---
     * 1% = 50 millis
     * 0-10, 30-40, 50-60, 70-90
     * 50% per 80 millis = 4000millis
     * 50$ per 40 millis = 2000millis
     */

    val scope = rememberCoroutineScope()
    val firstPointProgress = remember { mutableIntStateOf(0) }
    val secondPointProgress = remember { mutableIntStateOf(0) }
    val thirdPointProgress = remember { mutableIntStateOf(0) }
    val forthPointProgress = remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        scope.launch {
            while (firstPointProgress.intValue != 100) {
                val currentValue = firstPointProgress.intValue
                if (currentValue in 0..10 || currentValue in 30..40 || currentValue in 50..60 || currentValue in 70..90) {
                    delay(80)
                    firstPointProgress.intValue += 1
                } else {
                    delay(40)
                    firstPointProgress.intValue += 1
                }
            }

            delay(500)
            while (secondPointProgress.intValue != 100) {
                val currentValue = secondPointProgress.intValue
                if (currentValue in 0..10 || currentValue in 30..40 || currentValue in 50..60 || currentValue in 70..90) {
                    delay(80)
                    secondPointProgress.intValue += 1
                } else {
                    delay(40)
                    secondPointProgress.intValue += 1
                }
            }

            delay(500)
            while (thirdPointProgress.intValue != 100) {
                val currentValue = thirdPointProgress.intValue
                if (currentValue in 0..10 || currentValue in 30..40 || currentValue in 50..60 || currentValue in 70..90) {
                    delay(80)
                    thirdPointProgress.intValue += 1
                } else {
                    delay(40)
                    thirdPointProgress.intValue += 1
                }
            }

            delay(500)
            while (forthPointProgress.intValue != 100) {
                val currentValue = forthPointProgress.intValue
                if (currentValue in 0..10 || currentValue in 30..40 || currentValue in 50..60 || currentValue in 70..90) {
                    delay(80)
                    forthPointProgress.intValue += 1
                } else {
                    delay(40)
                    forthPointProgress.intValue += 1
                }
            }
        }
    }

    Column(
        modifier = modifier
            .padding(top = 100.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextWithGradientPart(
            text = stringResource(id = R.string.profile_settings_title),
            commonTextColor = colorResource(id = R.color.title_color),
            textSize = 24.sp,
            fontWeight = FontWeight.Medium,
        )

        TextWithGradientPart(
            modifier = modifier.padding(top = 8.dp),
            text = stringResource(id = R.string.profile_settings_text),
            commonTextColor = colorResource(id = com.moonila.core.compose.R.color.common_text_color),
            textSize = 14.sp,
            fontWeight = FontWeight.Normal
        )

        ProfileSettingsPoint(index = 0, progress = firstPointProgress.intValue)
        ProfileSettingsPoint(index = 1, progress = secondPointProgress.intValue)
        ProfileSettingsPoint(index = 2, progress = thirdPointProgress.intValue)
        ProfileSettingsPoint(index = 3, progress = forthPointProgress.intValue)
    }
}

@Composable
fun ProfileSettingsPoint(
    modifier: Modifier = Modifier,
    index: Int,
    progress: Int
) {

    val text = stringResource(
        id = when (index) {
            0 -> R.string.profile_settings_point_1
            1 -> R.string.profile_settings_point_2
            2 -> R.string.profile_settings_point_3
            else -> R.string.profile_settings_point_4
        }
    )

    Row(modifier = modifier.padding(top = 24.dp)) {
        Text(
            text = text,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = com.moonila.core.compose.R.color.light_color)
        )
        Spacer(modifier.weight(1f))
        Text(
            text = "${progress}%",
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = com.moonila.core.compose.R.color.light_color)
        )
    }

    Spacer(modifier.height(12.dp))

    ProfileSettingsProgressBar(
        percent = progress,
        gradientStart = colorResource(id = com.moonila.core.compose.R.color.orange_gradient_start),
        gradientEnd = colorResource(id = com.moonila.core.compose.R.color.orange_gradient_end),
    )
}

@Composable
fun ProfileSettingsProgressBar(
    modifier: Modifier = Modifier,
    percent: Int,
    gradientStart: Color,
    gradientEnd: Color
) {

    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp.dp - 32.dp

    Box(
        modifier = modifier
            .background(
                color = colorResource(id = R.color.progress_bar_bg),
                shape = RoundedCornerShape(4.dp)
            )
            .width(width)
            .height(12.dp)
    ) {
        Box(
            modifier = modifier
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(gradientStart, gradientEnd)
                    ),
                    shape = RoundedCornerShape(4.dp)
                )
                .height(12.dp)
                .width(width * percent / 100)
        )
    }
}