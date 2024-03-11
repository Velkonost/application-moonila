package features.feed.presentation.screen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.feed.presentation.R
import core.compose.composable.orangeTextGradient
import core.compose.theme.BonaNovaFontFamily
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
    val currentSliderIndex =
        remember { derivedStateOf { sliderScrollState.layoutInfo.visibleItemsInfo.lastOrNull()?.index } }

    Box {
        Image(
            modifier = modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.ic_header_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = modifier
                .padding(top = 50.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DateSelector(
                dateLabel = dateLabel,
                prevDayClick = prevDayClick,
                nextDayClick = nextDayClick,
                calendarClick = calendarClick
            )

            Image(
                modifier = modifier
                    .padding(top = 28.dp)
                    .size(100.dp),
                painter = painterResource(id = R.drawable.ic_slider_moon),
                contentDescription = null
            )

            Text(
                modifier = modifier.padding(top = 22.dp),
                text = stringResource(id = R.string.slider_title),
                fontFamily = BonaNovaFontFamily,
                fontWeight = FontWeight.Bold,
                style = orangeTextGradient(fontSize = 32.sp)
            )

            LazyRow(
                modifier = modifier
                    .fillMaxWidth(),
                state = sliderScrollState,
                flingBehavior = rememberSnapFlingBehavior(lazyListState = sliderScrollState),
                userScrollEnabled = true
            ) {
                items(2) {
                    SliderItem(
                        index = it,
                        moonState = moonState
                    )
                }
            }

            Row(modifier = modifier.padding(top = 16.dp)) {
                SliderDot(selected = currentSliderIndex.value == 0)
                SliderDot(selected = currentSliderIndex.value == 1)
            }

            Box(
                modifier = modifier
                    .padding(top = 25.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(
                        color = colorResource(id = R.color.divider_color),
                        shape = MaterialTheme.shapes.medium
                    )
            )
        }
    }
}

@Composable
fun SliderDot(
    modifier: Modifier = Modifier,
    selected: Boolean
) {
    Box(
        modifier = modifier
            .padding(horizontal = 4.dp)
            .size(8.dp)
            .clip(CircleShape)
            .background(
                color = colorResource(id = if (selected) R.color.selected_dot else R.color.unselected_dot),
                shape = CircleShape
            )
    )
}

