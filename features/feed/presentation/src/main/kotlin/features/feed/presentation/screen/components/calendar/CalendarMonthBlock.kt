package features.feed.presentation.screen.components.calendar

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.core.compose.R
import core.compose.theme.PoppinsFontFamily

@Composable
fun CalendarMonthBlock(
    modifier: Modifier = Modifier,
    monthLabel: String,
    prevDayClick: () -> Unit,
    nextDayClick: () -> Unit
) {
    Row(
        modifier = modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = monthLabel,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.light_color),
            fontSize = 24.sp,
        )
        Spacer(modifier.weight(1f))

        Box(
            modifier = modifier
                .size(32.dp)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = Color.White.copy(alpha = 0.2f),
                    shape = CircleShape
                )
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = prevDayClick
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = modifier
                    .size(14.dp)
                    .rotate(180f),
                painter = painterResource(id = com.moonila.features.feed.presentation.R.drawable.ic_calendar_arrow),
                contentDescription = null,
            )
        }

        Box(
            modifier = modifier
                .padding(start = 8.dp)
                .size(32.dp)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = Color.White.copy(alpha = 0.2f),
                    shape = CircleShape
                )
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = nextDayClick
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = modifier
                    .size(14.dp),
                painter = painterResource(id = com.moonila.features.feed.presentation.R.drawable.ic_calendar_arrow),
                contentDescription = null,
            )
        }
    }
}