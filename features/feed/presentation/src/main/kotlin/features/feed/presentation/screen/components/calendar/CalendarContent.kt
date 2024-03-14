package features.feed.presentation.screen.components.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.feed.presentation.R
import core.compose.theme.PoppinsFontFamily

@Composable
fun ColumnScope.CalendarContent(
    modifier: Modifier = Modifier
) {

    val daysOfWeek = stringArrayResource(id = R.array.days_of_week)

    Row(
        modifier = modifier
            .padding(top = 24.dp)
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        daysOfWeek.forEach {
            DayOfWeek(text = it)
        }
    }
}

@Composable
fun DayOfWeek(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier.alpha(0.5f),
        text = text,
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Normal,
        color = Color.White,
        fontSize = 12.sp,
    )
}