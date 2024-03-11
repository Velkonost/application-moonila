package features.feed.presentation.screen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.moonila.features.feed.presentation.R
import features.feed.presentation.contract.MoonState
import features.feed.presentation.screen.components.header.DateSelector
import features.feed.presentation.screen.components.header.SliderItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ColumnScope.Header(
    modifier: Modifier = Modifier,
    moonState: MoonState,
    dateLabel: String,
    prevDayClick: () -> Unit,
    nextDayClick: () -> Unit,
    calendarClick: () -> Unit,
) {

    val sliderScrollState = rememberLazyListState()

    Box {
        Image(
            modifier = modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.ic_header_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = modifier
                .padding(top = 40.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DateSelector(
                dateLabel = dateLabel,
                prevDayClick = prevDayClick,
                nextDayClick = nextDayClick,
                calendarClick = calendarClick
            )

            LazyRow(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                state = sliderScrollState,
                flingBehavior = rememberSnapFlingBehavior(lazyListState = sliderScrollState),
                userScrollEnabled = true
            ) {
                items(2) {
                    SliderItem(
                        index = it,
                        text = stringResource(id = R.string.slider_title),
                        moonState = moonState
                    )
                }
            }
        }
    }
}

