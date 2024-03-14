package features.feed.presentation.screen.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import com.moonila.features.feed.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.feed.presentation.contract.CalendarState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CalendarSheet(
    modifier: Modifier = Modifier,
    modalSheetState: ModalBottomSheetState,
    calendarState: CalendarState,
    prevDayClick: () -> Unit,
    nextDayClick: () -> Unit
) {
    val scope = rememberCoroutineScope()

    BackHandler {
        scope.launch {
            modalSheetState.hide()
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetBackgroundColor = colorResource(id = R.color.calendar_sheet_bg),
        sheetContent = {

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(
                            color = colorResource(id = R.color.calendar_header_bg)
                        )
                        .padding(top = 16.dp, bottom = 10.dp, start = 16.dp, end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = modifier
                            .size(16.dp)
                            .padding(1.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {
                                    scope.launch {
                                        modalSheetState.hide()
                                    }
                                }
                            ),
                        painter = painterResource(id = R.drawable.ic_calendar_cross),
                        contentDescription = null
                    )
                    Spacer(modifier.weight(1f))
                    Text(
                        text = stringResource(id = R.string.calendar),
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = com.moonila.core.compose.R.color.blue_color),
                        fontSize = 16.sp,
                    )
                    Spacer(modifier.weight(1f))
                    Spacer(modifier.size(16.dp))
                }

                Row(
                    modifier = modifier.padding(top = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = calendarState.monthLabel,
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                        fontSize = 24.sp,
                    )
                    Spacer(modifier.weight(1f))

                    Box(
                        modifier = modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .border(
                                width = 1.dp,
                                color = Color.White.copy(alpha = 0.2f),
                                shape = CircleShape
                            )
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = prevDayClick
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = modifier
                                .size(14.dp)
                                .rotate(180f),
                            painter = painterResource(id = R.drawable.ic_calendar_arrow),
                            contentDescription = null,
                        )
                    }

                    Box(
                        modifier = modifier
                            .padding(start = 8.dp)
                            .size(32.dp)
                            .clip(CircleShape)
                            .border(
                                width = 1.dp,
                                color = Color.White.copy(alpha = 0.2f),
                                shape = CircleShape
                            )
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = nextDayClick
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = modifier
                                .size(14.dp),
                            painter = painterResource(id = R.drawable.ic_calendar_arrow),
                            contentDescription = null,
                        )
                    }
                }
            }
        }) {}

}