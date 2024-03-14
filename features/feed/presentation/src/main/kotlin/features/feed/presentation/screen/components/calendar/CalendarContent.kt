package features.feed.presentation.screen.components.calendar

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
fun LazyGridItemScope.EmptyDateView(
    modifier: Modifier = Modifier
) {
    Spacer(modifier = modifier.size(40.dp))
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyGridItemScope.DateView(
    modifier: Modifier = Modifier,
    item: CalendarDate,
    onClick: () -> Unit
) {

    Column(
        modifier = modifier
            .width(36.dp)
            .padding(horizontal = 4.dp)
            .background(
                color = if (item.selected) colorResource(id = R.color.selected_date_bg) else Color.Transparent,
                shape = RoundedCornerShape(33.dp)
            )
            .padding(vertical = 4.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
            .animateItemPlacement(),
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