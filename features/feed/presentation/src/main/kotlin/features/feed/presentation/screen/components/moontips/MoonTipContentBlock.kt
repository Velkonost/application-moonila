package features.feed.presentation.screen.components.moontips

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.compose.theme.PoppinsFontFamily
import features.feed.presentation.model.MoonTipContent
import com.moonila.features.feed.presentation.R

@Composable
fun MoonTipContentBlock(
    modifier: Modifier = Modifier,
    item: MoonTipContent
) {

    Box(
        modifier = modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .background(
                color = colorResource(id = R.color.tip_selected_bg),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(20.dp)
    ) {
        Column {
            Spacer(modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.ic_tip_bg),
                contentDescription = null
            )
        }

        Column(modifier = modifier.fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = item.type.titleResId),
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                    fontSize = 20.sp,
                )
                Spacer(modifier.weight(1f))

                Image(
                    modifier = modifier.size(34.dp),
                    painter = painterResource(id = item.type.iconId),
                    contentDescription = null
                )
            }

            Text(
                modifier = modifier.padding(top = 20.dp),
                text = item.text,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.tip_text_color),
                fontSize = 14.sp,
                textAlign = TextAlign.Start
            )

            Row {
                Spacer(modifier.weight(1f))

                Image(
                    modifier = modifier.height(36.dp),
                    painter = painterResource(id = R.drawable.ic_tip_share),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

        }
    }

}