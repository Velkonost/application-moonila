package features.paywall.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.paywall.presentation.R
import core.compose.theme.PoppinsFontFamily

@Composable
fun FooterView(
    modifier: Modifier = Modifier,
    onPrivacyClick: () -> Unit,
    onTermsClick: () -> Unit,
    onRestoreClick: () -> Unit
) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onPrivacyClick
            ),
            text = stringResource(id = R.string.privacy_policy),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.offer_hint_color)
        )

        Spacer(modifier.weight(1f))
        VerticalBreakline()
        Spacer(modifier.weight(1f))

        Text(
            modifier = modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onRestoreClick
            ),
            text = stringResource(id = R.string.restore_purchase),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.offer_hint_color)
        )

        Spacer(modifier.weight(1f))
        VerticalBreakline()
        Spacer(modifier.weight(1f))

        Text(
            modifier = modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onTermsClick
            ),
            text = stringResource(id = R.string.terms_of_use),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.offer_hint_color)
        )
    }

}

@Composable
fun VerticalBreakline() {
    Box(
        modifier = Modifier
            .height(12.dp)
            .width(1.dp)
            .background(
                color = colorResource(id = com.moonila.core.compose.R.color.light_color).copy(alpha = 0.2f)
            )
    )
}