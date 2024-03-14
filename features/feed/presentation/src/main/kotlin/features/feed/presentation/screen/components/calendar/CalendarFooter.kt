package features.feed.presentation.screen.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.feed.presentation.R
import core.compose.theme.PoppinsFontFamily

@Composable
fun ColumnScope.CalendarFooter(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        CalendarFooterItem(
            color = colorResource(id = R.color.holidays_color),
            title = stringResource(id = R.string.holidays),
            subtitle = stringResource(id = R.string.holidays_subtitle)
        )

        CalendarFooterItem(
            color = colorResource(id = R.color.ekadashi_color),
            title = stringResource(id = R.string.ekadashi),
            subtitle = stringResource(id = R.string.ekadashi_subtitle)
        )
    }

    Row(
        modifier = modifier
            .padding(top = 10.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        CalendarFooterItem(
            color = colorResource(id = R.color.lunar_eclipse_color),
            title = stringResource(id = R.string.lunar_eclipse),
            subtitle = stringResource(id = R.string.lunar_eclipse_subtitle)
        )

        CalendarFooterItem(
            color = colorResource(id = R.color.solar_eclipse_color),
            title = stringResource(id = R.string.solar_eclipse),
            subtitle = stringResource(id = R.string.solar_eclipse_subtitle)
        )
    }

}

@Composable
fun RowScope.CalendarFooterItem(
    modifier: Modifier = Modifier,
    color: Color,
    title: String,
    subtitle: String
) {

    Row(
        modifier = modifier
            .weight(1f)
            .background(
                color = colorResource(id = R.color.calendar_footer_bg),
                shape = MaterialTheme.shapes.medium
            )
            .padding(start = 12.dp, end = 8.dp, top = 8.dp, bottom = 10.dp)
    ) {
        Box(
            modifier = modifier
                .padding(top = 1.dp)
                .size(18.dp)
                .background(
                    color = color,
                    shape = CircleShape
                )
        )

        Column(modifier = modifier.padding(start = 6.dp)) {
            Text(
                text = title,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.cloudy_color),
                fontSize = 14.sp,
            )

            Text(
                text = subtitle,
                maxLines = 1,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.secondary_color),
                fontSize = 10.sp,
            )
        }
    }

}