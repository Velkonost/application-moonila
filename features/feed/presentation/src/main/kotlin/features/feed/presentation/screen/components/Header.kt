package features.feed.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.moonila.features.feed.presentation.R
import features.feed.presentation.screen.components.header.DateSelector

@Composable
fun ColumnScope.Header(
    modifier: Modifier = Modifier,
    dateLabel: String,
    prevDayClick: () -> Unit,
    nextDayClick: () -> Unit,
    calendarClick: () -> Unit,
) {

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
        }
    }
}

