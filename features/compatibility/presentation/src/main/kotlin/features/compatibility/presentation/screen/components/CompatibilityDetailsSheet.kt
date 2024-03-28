package features.compatibility.presentation.screen.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.compatibility.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.compatibility.presentation.model.CompatibilityItem
import features.compatibility.presentation.screen.components.details.DetailsHeader
import features.compatibility.presentation.screen.components.details.DetailsMoonPhase
import features.compatibility.presentation.screen.components.details.DetailsProgressBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun CompatibilityDetailsSheet(
    modifier: Modifier = Modifier,
    modalSheetState: ModalBottomSheetState,
    item: CompatibilityItem
) {
    val scope = rememberCoroutineScope()

    val longDelay = 90L
    val shortDelay = 30L
    val progress = remember { mutableIntStateOf(0) }

    LaunchedEffect(modalSheetState.currentValue) {
        if (modalSheetState.isVisible) {
            scope.launch {
                progress.intValue = 0

                while (progress.intValue != item.percent.roundToInt()) {
                    val currentValue = progress.intValue
                    if (currentValue in 0..10 || currentValue in 30..40 || currentValue in 50..60 || currentValue in 70..90) {
                        delay(longDelay)
                        progress.intValue += 1
                    } else {
                        delay(shortDelay)
                        progress.intValue += 1
                    }
                }
            }
        }
    }

    BackHandler {
        scope.launch {
            modalSheetState.hide()
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetBackgroundColor = colorResource(id = R.color.main_bg),
        sheetContent = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f),
            ) {
                DetailsHeader {
                    scope.launch {
                        modalSheetState.hide()
                    }
                }

                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 100.dp)
                        .padding(horizontal = 16.dp)
                ) {
                    FlowRow(modifier = modifier.padding(top = 24.dp)) {
                        Text(
                            text = item.firstName,
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                            fontSize = 20.sp,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = " & ",
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(id = com.moonila.core.compose.R.color.light_color).copy(
                                alpha = 0.5f
                            ),
                            fontSize = 20.sp,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = item.secondName,
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                            fontSize = 20.sp,
                            textAlign = TextAlign.Start
                        )
                    }

                    Row(
                        modifier = modifier.padding(top = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.details_subtitle),
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = com.moonila.core.compose.R.color.common_text_color),
                            fontSize = 14.sp,
                            textAlign = TextAlign.Start
                        )

                        Spacer(modifier.weight(1f))

                        Text(
                            text = "${item.percent}%",
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(id = com.moonila.core.compose.R.color.main_green),
                            fontSize = 14.sp,
                            textAlign = TextAlign.Start
                        )
                    }

                    Spacer(modifier.height(12.dp))

                    DetailsProgressBar(percent = progress.intValue)

                    Box(
                        modifier = modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(
                                color = colorResource(id = R.color.compatibility_item_bg),
                                shape = MaterialTheme.shapes.medium
                            )
                    )
                    
                    DetailsMoonPhase(
                        firstIconResId = item.firstMoonIcon,
                        secondIconResId = item.secondMoonIcon,
                        firstTitle = "Waxing Cr",
                        secondTitle = "Waning Gib",
                        textFirstPart = "At birth, your Moon was in Waxing Crescent phase and your partner's Moon was in Waning Gibbous phase.",
                        textSecondPart = "The natives born under Waxing Crescent know the value of hard work because getting what they want can feel challenging at times. You are most compatible with Waning Gibbous since the fearless determination from Gibbous can help you feel passionate to continue pursuing your dreams.\n" +
                                "\n" +
                                "The rising star (waxing crescent) and the mentor (waning gibbous) share a preference for growth and ease. But in some cases, the thoughtful waning gibbous could grow frustrated with the waxing crescent’s carefree curiosity and spontaneity."
                    )
                }

            }
        }
    ) {}
}