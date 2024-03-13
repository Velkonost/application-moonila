package features.feed.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.feed.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.feed.presentation.contract.DailyTipState

@Composable
fun DailyTip(
    modifier: Modifier = Modifier,
    dailyTipState: DailyTipState
) {
    BlockTitle(text = stringResource(id = R.string.your_daily_tip))

    Column(
        modifier = modifier
            .padding(top = 12.dp)
            .padding(horizontal = 16.dp)
            .background(
                color = colorResource(id = R.color.daily_tip_bg),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(20.dp)
    ) {

        Image(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
            painter = painterResource(id = R.drawable.ic_daily_tip),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = modifier
                .padding(top = 12.dp),
            text = dailyTipState.title,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = com.moonila.core.compose.R.color.light_color),
            fontSize = 18.sp,
            textAlign = TextAlign.Start
        )

        Text(
            modifier = modifier
                .padding(top = 8.dp),
            text = dailyTipState.text,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = com.moonila.core.compose.R.color.light_color),
            fontSize = 14.sp,
            textAlign = TextAlign.Start
        )
    }
}