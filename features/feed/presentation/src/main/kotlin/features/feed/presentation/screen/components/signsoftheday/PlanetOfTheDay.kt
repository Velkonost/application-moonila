package features.feed.presentation.screen.components.signsoftheday

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.feed.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.feed.presentation.model.SignsOfTheDayItem

@Composable
fun PlanetOfTheDay(
    modifier: Modifier = Modifier,
    item: SignsOfTheDayItem
) {
    val expanded = remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
            .background(
                color = colorResource(id = R.color.signs_of_the_day_bg),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(20.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    expanded.value = !expanded.value
                }
            )
    ) {
        Row {
            Column {
                Text(
                    text = stringResource(id = item.titleId),
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                    fontSize = 18.sp,
                )

                Text(
                    modifier = modifier.padding(top = 4.dp),
                    text = item.subtitle,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.secondary_color),
                    fontSize = 14.sp,
                )
            }
            Spacer(modifier.weight(1f))

            Image(
                modifier = modifier.size(44.dp),
                painter = painterResource(id = item.icon1Id!!),
                contentDescription = null
            )
        }

        AnimatedVisibility(visible = expanded.value) {
            Text(
                modifier = modifier
                    .alpha(0.7f)
                    .padding(top = 12.dp),
                text = item.text,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                fontSize = 14.sp,
            )
        }
    }
}