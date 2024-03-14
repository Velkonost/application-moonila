package features.feed.presentation.screen.components.header

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.moonila.features.feed.presentation.R
import core.compose.theme.PoppinsFontFamily

@Composable
fun DateSelector(
    modifier: Modifier = Modifier,
    dateLabel: String,
    prevDayClick: () -> Unit,
    nextDayClick: () -> Unit,
    calendarClick: () -> Unit,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
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
                painter = painterResource(id = R.drawable.ic_calendar_arrow),
                contentDescription = null,
            )
        }

        Spacer(modifier.width(16.dp))

        Box(
            modifier = modifier
                .height(36.dp)
                .clip(RoundedCornerShape(size = 50.dp))
                .background(
                    color = colorResource(id = R.color.date_bg),
                    shape = RoundedCornerShape(size = 50.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color.White.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(size = 50.dp)
                )
                .padding(horizontal = 12.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = calendarClick
                ),
            contentAlignment = Alignment.Center
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = null
                )

                AnimatedContent(targetState = dateLabel, label = "") {
                    Text(
                        modifier = modifier.padding(start = 4.dp, top = 4.dp),
                        text = it,
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }

        }

        Spacer(modifier.width(16.dp))

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
                    onClick = nextDayClick
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = modifier
                    .size(14.dp),
                painter = painterResource(id = R.drawable.ic_calendar_arrow),
                contentDescription = null,
            )
        }

    }
}