package features.feed.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.moonila.features.feed.presentation.R
import features.feed.presentation.FeedViewModel
import features.feed.presentation.contract.FeedAction
import features.feed.presentation.screen.components.Affirmation
import features.feed.presentation.screen.components.CalendarSheet
import features.feed.presentation.screen.components.DailyTip
import features.feed.presentation.screen.components.Header
import features.feed.presentation.screen.components.MoonInsight
import features.feed.presentation.screen.components.MoonTips
import features.feed.presentation.screen.components.QuoteForToday
import features.feed.presentation.screen.components.SignsOfTheDay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
    viewModel: FeedViewModel
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    val scope = rememberCoroutineScope()
    val calendarSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.main_bg))
            .verticalScroll(rememberScrollState())
            .padding(bottom = 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(
            dateLabel = state.calendarState.selectedDateLabel,
            moonState = state.moonState,
            prevDayClick = {
                viewModel.dispatch(FeedAction.PrevDayClick)
            },
            nextDayClick = {
                viewModel.dispatch(FeedAction.NextDayClick)
            },
            calendarClick = {
                scope.launch {
                    calendarSheetState.show()
                }
            }
        )

        MoonInsight(
            moonInsightState = state.moonInsightState,
            onItemClick = {
                viewModel.dispatch(FeedAction.MoonInsightClick(it))
            }
        )

        QuoteForToday(text = state.quoteState.text, author = state.quoteState.author)

        MoonTips(
            moonTipsState = state.moonTipsState,
            onItemClick = {
                viewModel.dispatch(FeedAction.MoonTipsClick(it))
            }
        )

        DailyTip(dailyTipState = state.dailyTipState)
        Affirmation(affirmationState = state.affirmationState)
        SignsOfTheDay(signsOfTheDayState = state.signsOfTheDayState)
    }

    CalendarSheet(
        modalSheetState = calendarSheetState,
        calendarState = state.calendarState,
        prevMonthClick = {
            viewModel.dispatch(FeedAction.PrevMonthClick)
        },
        nextMonthClick = {
            viewModel.dispatch(FeedAction.NextMonthClick)
        }
    )
}