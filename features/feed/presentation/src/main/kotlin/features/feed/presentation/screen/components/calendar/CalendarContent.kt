package features.feed.presentation.screen.components.calendar

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.feed.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.feed.presentation.model.CalendarDate

@Composable
fun ColumnScope.CalendarContent(
    modifier: Modifier = Modifier,
    emptyDates: Int,
    dates: List<CalendarDate>
) {

    val daysOfWeek = stringArrayResource(id = R.array.days_of_week)

    LazyVerticalGrid(
        modifier = modifier
            .padding(top = 24.dp)
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .animateContentSize(),
        columns = GridCells.Fixed(7),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(daysOfWeek) {
            DayOfWeek(text = it)
        }

        items(emptyDates) {
            EmptyDateView()
        }

        items(dates, key = { it.number }) {
            DateView(item = it)
        }
    }
}

@Composable
fun EmptyDateView(
    modifier: Modifier = Modifier
) {
    Spacer(modifier = modifier.size(40.dp))
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyGridItemScope.DateView(
    modifier: Modifier = Modifier,
    item: CalendarDate
) {

    Column(
        modifier = modifier.width(40.dp).animateItemPlacement(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = modifier.size(32.dp),
            painter = painterResource(id = item.iconId),
            contentDescription = null
        )

        Text(
            modifier = modifier.padding(top = 5.dp),
            text = item.number,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            fontSize = 14.sp,
        )

        Box(
            modifier = modifier
                .padding(top = 2.dp)
                .size(7.dp)
                .background(
                    color = colorResource(id = R.color.holidays_color),
                    shape = CircleShape
                )
        )
    }

}

@Composable
fun DayOfWeek(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier
            .width(40.dp)
            .alpha(0.5f),
        text = text,
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Normal,
        color = Color.White,
        fontSize = 12.sp,
        textAlign = TextAlign.Center
    )
}