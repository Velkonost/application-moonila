package features.feed.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.feed.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.feed.presentation.contract.MoonTipsState
import features.feed.presentation.model.MoonTipsItem

@Composable
fun MoonTips(
    modifier: Modifier = Modifier,
    moonTipsState: MoonTipsState
) {

    BlockTitle(text = stringResource(id = R.string.moon_tips))


}

@Composable
fun MoonTipsCategoryItem(
    modifier: Modifier = Modifier,
    item: MoonTipsItem,
    selected: Boolean
) {
    Row(
        modifier = modifier
            .height(40.dp)
            .background(
                color = colorResource(id = )
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier.size(20.dp),
            painter = painterResource(id = if (selected) item.iconId else item.inactiveIconId),
            contentDescription = null
        )

        Text(
            modifier = modifier
                .padding(start = 4.dp),
            text = stringResource(id = item.titleResId),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}