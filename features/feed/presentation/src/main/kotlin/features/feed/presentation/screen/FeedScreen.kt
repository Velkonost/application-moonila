package features.feed.presentation.screen

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import features.feed.presentation.FeedViewModel
import features.feed.presentation.screen.components.Header

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
    viewModel: FeedViewModel
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
        ,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(
            dateLabel = "8 Nov, Wed",
            moonState = state.moonState,
            prevDayClick = { /*TODO*/ },
            nextDayClick = { /*TODO*/ },
            calendarClick = {}
        )
    }

}