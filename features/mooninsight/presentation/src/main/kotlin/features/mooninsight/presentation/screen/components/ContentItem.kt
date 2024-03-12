package features.mooninsight.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.mooninsight.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.mooninsight.presentation.contract.ContentBlock

@Composable
fun ColumnScope.ContentItem(
    modifier: Modifier = Modifier,
    item: ContentBlock
) {

    Row(
        modifier = modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = item.title,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = colorResource(id = R.color.content_title_color)
        )

        if (!item.hint.isNullOrEmpty()) {
            Box(
                modifier = modifier
                    .padding(start = 8.dp)
                    .background(
                        color = colorResource(id = R.color.content_hint_bg),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(horizontal = 4.dp)
            ) {
                Text(
                    text = item.hint,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }

        Spacer(modifier.weight(1f))

        if (!item.number.isNullOrEmpty()) {
            Box(
                modifier = modifier
                    .size(30.dp)
                    .background(
                        color = colorResource(id = com.moonila.core.compose.R.color.blue_color),
                        shape = CircleShape
                    )
            ) {

                Text(
                    modifier = modifier
                        .align(Alignment.Center)
                        .padding(top = 2.dp, end = 1.dp),
                    text = item.number,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )

            }
        } else if (item.iconId != null) {
            Box(
                modifier = modifier
                    .size(30.dp)
                    .background(
                        color = colorResource(id = R.color.content_zodiak_bg),
                        shape = CircleShape
                    )
            ) {
                Image(
                    modifier = modifier
                        .align(Alignment.Center)
                        .size(18.dp),
                    painter = painterResource(id = item.iconId),
                    contentDescription = null
                )
            }
        }
    }

    Text(
        modifier = modifier.padding(top = 10.dp, start = 16.dp, end = 16.dp),
        text = item.text,
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = colorResource(id = R.color.content_text_color),
        textAlign = TextAlign.Start
    )

}