package features.feed.presentation.screen.components.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.feed.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.feed.presentation.contract.MoonState

@Composable
fun LazyItemScope.SliderItem(
    modifier: Modifier = Modifier,
    index: Int,
    moonState: MoonState
) {

    Column(
        modifier = modifier
            .fillParentMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = modifier
                .padding(top = 30.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SliderItemPoint(
                title = stringResource(id = if (index == 0) R.string.new_moon else R.string.lunar_eclipse),
                date = if (index == 0) moonState.newMoonDate else moonState.lunarEclipseDate,
                icon = painterResource(id = if (index == 0) R.drawable.ic_new_moon else R.drawable.ic_lunar_eclipse)
            )

            SliderItemPoint(
                title = stringResource(id = if (index == 0) R.string.full_moon else R.string.solar_eclipse),
                date = if (index == 0) moonState.fullMoonDate else moonState.solarEclipseDate,
                icon = painterResource(id = if (index == 0) com.moonila.core.compose.R.drawable.ic_full_moon else R.drawable.ic_solar_eclipse)
            )
        }
    }
}

@Composable
fun SliderItemPoint(
    modifier: Modifier = Modifier,
    title: String,
    date: String,
    icon: Painter
) {

    Row(
        modifier = modifier
            .height(54.dp)
            .width(166.dp)
            .background(
                color = colorResource(id = R.color.slider_point_bg),
                shape = MaterialTheme.shapes.medium
            )
    ) {
        Image(
            modifier = modifier
                .padding(start = 12.dp, top = 8.dp)
                .size(18.dp),
            painter = icon,
            contentDescription = null
        )

        Column(
            modifier = modifier.padding(start = 8.dp, top = 8.dp)
        ) {
            Text(
                text = title,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = colorResource(id = R.color.cloudy_color)
            )

            Text(
                text = date,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = colorResource(id = R.color.secondary_color)
            )
        }

    }

}