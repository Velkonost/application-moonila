package features.feed.presentation.screen.components

import android.widget.Space
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.moonila.features.feed.presentation.R
import features.feed.presentation.contract.CalendarState
import features.feed.presentation.screen.components.calendar.CalendarContent
import features.feed.presentation.screen.components.calendar.CalendarFooter
import features.feed.presentation.screen.components.calendar.CalendarHeader
import features.feed.presentation.screen.components.calendar.CalendarMonthBlock
import kotlinx.coroutines.launch

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

                CalendarHeader {
                    scope.launch {
                        modalSheetState.hide()
                    }
                }

                CalendarMonthBlock(
                    monthLabel = calendarState.monthLabel,
                    prevDayClick = prevDayClick,
                    nextDayClick = nextDayClick
                )

                CalendarContent()

                Spacer(modifier.weight(1f))

                CalendarFooter()

                Spacer(modifier.height(60.dp))
            }
        }) {}

}