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
import features.feed.presentation.screen.components.Header
import features.feed.presentation.screen.components.MoonInsight
import features.feed.presentation.screen.components.QuoteForToday

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

        MoonInsight(moonInsightState = state.moonInsightState)
        QuoteForToday(text = state.quoteState.text, author = state.quoteState.author)
    }

}