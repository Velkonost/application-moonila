package features.feed.presentation.screen.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import com.moonila.features.feed.presentation.R
import features.feed.presentation.contract.CalendarState
import features.feed.presentation.screen.components.calendar.CalendarFooter
import features.feed.presentation.screen.components.calendar.CalendarHeader
import features.feed.presentation.screen.components.calendar.CalendarMonthBlock
import features.feed.presentation.screen.components.calendar.DateView
import features.feed.presentation.screen.components.calendar.DayOfWeek
import features.feed.presentation.screen.components.calendar.EmptyDateView
import kotlinx.coroutines.launch

@OptIn(
    ExperimentalMaterialApi::class, ExperimentalLayoutApi::class,
    ExperimentalFoundationApi::class
)
@Composable
fun CalendarSheet(
    modifier: Modifier = Modifier,
    modalSheetState: ModalBottomSheetState,
    calendarState: CalendarState,
    prevMonthClick: () -> Unit,
    nextMonthClick: () -> Unit
) {
    val scope = rememberCoroutineScope()

    val daysOfWeek = stringArrayResource(id = R.array.days_of_week)

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
                    .fillMaxHeight(0.95f),
            ) {

                CalendarHeader {
                    scope.launch {
                        modalSheetState.hide()
                    }
                }

                LazyVerticalGrid(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .animateContentSize()
                    ,
                    columns = GridCells.Fixed(7),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    state = rememberLazyGridState()
                ) {

                    item(span = { GridItemSpan(7) }, key = "month_block") {
                        CalendarMonthBlock(
                            monthLabel = calendarState.monthLabel,
                            prevMonthClick = prevMonthClick,
                            nextMonthClick = nextMonthClick
                        )
                    }

                    items(daysOfWeek, key = { it }) {
                        DayOfWeek(text = it)
                    }

                    items(calendarState.missedDaysAmount, key = { it }) {
                        EmptyDateView()
                    }

                    items(calendarState.items, key = { it.number }) {
                        DateView(item = it)
                    }

                    item(span = { GridItemSpan(7) }, key = "spacer") {
                        Spacer(
                            modifier
                                .height(30.dp)
                                .animateItemPlacement()
                        )
                    }

                    item(span = { GridItemSpan(7) }, key = "footer") {
                        CalendarFooter()
                    }

                    item(span = { GridItemSpan(7) }, key = "spacer2") {
                        Spacer(modifier.height(60.dp))
                    }
                }
            }

//            Column(
//                modifier = modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight(0.95f)
//                    .verticalScroll(rememberScrollState())
//            ) {
//
//
//
//
//
//                CalendarContent(
//                    emptyDates = calendarState.missedDaysAmount,
//                    dates = calendarState.items
//                )
//
//
//
//
//
//                Spacer(modifier.height(60.dp))
//            }
        }) {}

}