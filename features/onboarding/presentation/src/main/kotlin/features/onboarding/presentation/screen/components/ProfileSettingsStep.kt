package features.onboarding.presentation.screen.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.onboarding.presentation.R
import core.compose.components.TextWithGradientPart
import core.compose.theme.PoppinsFontFamily
import features.onboarding.presentation.model.Feedback
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileSettingsStep(
    modifier: Modifier = Modifier,
    forceHideButton: MutableState<Boolean>,
    feedbacks: List<Feedback>
) {

    val scope = rememberCoroutineScope()
    val firstPointProgress = remember { mutableIntStateOf(0) }
    val secondPointProgress = remember { mutableIntStateOf(0) }
    val thirdPointProgress = remember { mutableIntStateOf(0) }
    val forthPointProgress = remember { mutableIntStateOf(0) }

    val firstMarkVisible = remember { mutableStateOf(false) }
    val secondMarkVisible = remember { mutableStateOf(false) }
    val thirdMarkVisible = remember { mutableStateOf(false) }
    val forthMarkVisible = remember { mutableStateOf(false) }

    val longDelay = 90L
    val shortDelay = 30L
    val feedbackDuration = 4000L

    val scrollState = rememberLazyListState()

    LaunchedEffect(Unit) {
        scope.launch {
            forceHideButton.value = true

            while (firstPointProgress.intValue != 100) {
                val currentValue = firstPointProgress.intValue
                if (currentValue in 0..10 || currentValue in 30..40 || currentValue in 50..60 || currentValue in 70..90) {
                    delay(longDelay)
                    firstPointProgress.intValue += 1
                } else {
                    delay(shortDelay)
                    firstPointProgress.intValue += 1
                }
            }

            delay(500)
            firstMarkVisible.value = true

            while (secondPointProgress.intValue != 100) {
                val currentValue = secondPointProgress.intValue
                if (currentValue in 0..10 || currentValue in 30..40 || currentValue in 50..60 || currentValue in 70..90) {
                    delay(longDelay)
                    secondPointProgress.intValue += 1
                } else {
                    delay(shortDelay)
                    secondPointProgress.intValue += 1
                }
            }

            delay(500)
            secondMarkVisible.value = true

            while (thirdPointProgress.intValue != 100) {
                val currentValue = thirdPointProgress.intValue
                if (currentValue in 0..10 || currentValue in 30..40 || currentValue in 50..60 || currentValue in 70..90) {
                    delay(longDelay)
                    thirdPointProgress.intValue += 1
                } else {
                    delay(shortDelay)
                    thirdPointProgress.intValue += 1
                }
            }

            delay(500)
            thirdMarkVisible.value = true

            while (forthPointProgress.intValue != 100) {
                val currentValue = forthPointProgress.intValue
                if (currentValue in 0..10 || currentValue in 30..40 || currentValue in 50..60 || currentValue in 70..90) {
                    delay(longDelay)
                    forthPointProgress.intValue += 1
                } else {
                    delay(shortDelay)
                    forthPointProgress.intValue += 1
                }
            }

            delay(500)
            forthMarkVisible.value = true
            forceHideButton.value = false
        }
    }

    LaunchedEffect(Unit) {
        while (scrollState.firstVisibleItemIndex < feedbacks.size) {
            delay(feedbackDuration)
            val currentPosition = scrollState.firstVisibleItemIndex
            scrollState.animateScrollToItem(currentPosition + 1)
        }
    }

    Column(
        modifier = modifier
            .padding(top = 80.dp)
            .fillMaxWidth(),
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

        ProfileSettingsPoint(
            index = 0,
            progress = firstPointProgress.intValue,
            markVisible = firstMarkVisible.value
        )
        ProfileSettingsPoint(
            index = 1,
            progress = secondPointProgress.intValue,
            markVisible = secondMarkVisible.value
        )
        ProfileSettingsPoint(
            index = 2,
            progress = thirdPointProgress.intValue,
            markVisible = thirdMarkVisible.value
        )
        ProfileSettingsPoint(
            index = 3,
            progress = forthPointProgress.intValue,
            markVisible = forthMarkVisible.value
        )

        Text(
            modifier = modifier.padding(top = 16.dp),
            text = stringResource(id = R.string.feedbacks_title),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = com.moonila.core.compose.R.color.cloudy_color)
        )

        LazyRow(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            state = scrollState,
            flingBehavior = rememberSnapFlingBehavior(lazyListState = scrollState),
            userScrollEnabled = false
        ) {
            items(feedbacks, key = { it.name }) {
                FeedBackItem(item = it)
            }
        }
    }
}

@Composable
fun LazyItemScope.FeedBackItem(
    modifier: Modifier = Modifier,
    item: Feedback
) {
    Column(
        modifier = modifier
            .fillParentMaxWidth()
            .padding(horizontal = 32.dp)
            .background(
                color = colorResource(id = R.color.feedback_bg).copy(alpha = 0.2f),
                shape = MaterialTheme.shapes.medium
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = modifier
                .padding(top = 8.dp),
            text = stringResource(id = item.title),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = com.moonila.core.compose.R.color.cloudy_color)
        )

        Image(
            modifier = modifier
                .padding(top = 6.dp)
                .height(24.dp),
            painter = painterResource(id = R.drawable.ic_five_stars),
            contentDescription = null
        )

        Text(
            modifier = modifier
                .padding(top = 6.dp, bottom = 12.dp)
                .padding(horizontal = 16.dp),
            text = stringResource(id = item.text),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = com.moonila.core.compose.R.color.cloudy_color)
        )
    }
}

@Composable
fun ProfileSettingsPoint(
    modifier: Modifier = Modifier,
    index: Int,
    progress: Int,
    markVisible: Boolean
) {

    val text = stringResource(
        id = when (index) {
            0 -> R.string.profile_settings_point_1
            1 -> R.string.profile_settings_point_2
            2 -> R.string.profile_settings_point_3
            else -> R.string.profile_settings_point_4
        }
    )

    val gradientStart = colorResource(
        id = when (index) {
            0 -> com.moonila.core.compose.R.color.orange_gradient_start
            1 -> com.moonila.core.compose.R.color.pink_gradient_start
            2 -> com.moonila.core.compose.R.color.green_gradient_start
            else -> com.moonila.core.compose.R.color.blue_gradient_start
        }
    )

    val gradientEnd = colorResource(
        id = when (index) {
            0 -> com.moonila.core.compose.R.color.orange_gradient_end
            1 -> com.moonila.core.compose.R.color.pink_gradient_end
            2 -> com.moonila.core.compose.R.color.green_gradient_end
            else -> com.moonila.core.compose.R.color.blue_gradient_end
        }
    )

    Row(
        modifier = modifier
            .padding(top = 16.dp)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = text,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = com.moonila.core.compose.R.color.cloudy_color)
        )
        Spacer(modifier.weight(1f))

        AnimatedContent(targetState = markVisible, label = "") {
            if (it) {
                Image(
                    modifier = modifier.size(22.dp),
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = null
                )
            } else {
                Text(
                    text = "${progress}%",
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = colorResource(
                        id = if (progress == 0) com.moonila.core.compose.R.color.common_text_color
                        else com.moonila.core.compose.R.color.light_color
                    )
                )
            }
        }

    }

    Spacer(modifier.height(8.dp))

    ProfileSettingsProgressBar(
        percent = progress,
        gradientStart = gradientStart,
        gradientEnd = gradientEnd,
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