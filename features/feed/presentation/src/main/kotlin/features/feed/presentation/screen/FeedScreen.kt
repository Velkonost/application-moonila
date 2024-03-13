package features.feed.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.moonila.features.feed.presentation.R
import features.feed.presentation.FeedViewModel
import features.feed.presentation.contract.FeedAction
import features.feed.presentation.screen.components.Affirmation
import features.feed.presentation.screen.components.DailyTip
import features.feed.presentation.screen.components.Header
import features.feed.presentation.screen.components.MoonInsight
import features.feed.presentation.screen.components.MoonTips
import features.feed.presentation.screen.components.QuoteForToday
import features.feed.presentation.screen.components.SignsOfTheDay

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
    viewModel: FeedViewModel
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.main_bg))
            .verticalScroll(rememberScrollState())
            .padding(bottom = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(
            dateLabel = "8 Nov, Wed",
            moonState = state.moonState,
            prevDayClick = { /*TODO*/ },
            nextDayClick = { /*TODO*/ },
            calendarClick = {}
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

}