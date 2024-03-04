package features.paywall.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.paywall.presentation.R
import core.compose.components.TextWithGradientPart
import core.compose.theme.PoppinsFontFamily
import features.paywall.presentation.model.Offer

@Composable
fun OfferItem(
    modifier: Modifier = Modifier,
    item: Offer,
    selected: Boolean,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .background(
                color = colorResource(
                    id = if (selected) R.color.active_offer_bg
                    else R.color.inactive_offer_bg
                ),
                shape = MaterialTheme.shapes.medium
            )
            .padding(vertical = 10.dp)
            .padding(end = 10.dp, start = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = modifier
        ) {

            if (selected) {
                Text(
                    text = stringResource(id = item.title),
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = colorResource(id = com.moonila.core.compose.R.color.blue_color)
                )
            } else {
                TextWithGradientPart(
                    text = "",
                    commonTextColor = colorResource(id = com.moonila.core.compose.R.color.common_text_color),
                    textSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    colorfulTextAtEnd = stringResource(id = item.title)
                )
            }

            Text(
                modifier = modifier.padding(top = 4.dp),
                text = stringResource(id = item.text),
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = colorResource(
                    id = if (selected) com.moonila.core.compose.R.color.blue_color
                    else com.moonila.core.compose.R.color.light_color
                )
            )
        }

        Spacer(modifier.weight(1f))

        item.discount?.let {
            DiscountView(text = stringResource(id = it))
        }
    }
}

@Composable
fun DiscountView(
    modifier: Modifier = Modifier,
    text: String
) {

    Text(
        modifier = modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        colorResource(id = R.color.discount_gradient_start),
                        colorResource(id = R.color.discount_gradient_end)
                    )
                )
            )
            .padding(horizontal = 7.dp, vertical = 11.dp),
        text = text,
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        color = colorResource(id = com.moonila.core.compose.R.color.light_color)
    )

}