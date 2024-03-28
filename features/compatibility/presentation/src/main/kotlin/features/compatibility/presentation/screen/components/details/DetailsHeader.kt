package features.compatibility.presentation.screen.components.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.moonila.core.compose.R
import core.compose.theme.PoppinsFontFamily

@Composable
fun DetailsHeader(
    modifier: Modifier = Modifier,
    onCloseClick: () -> Unit
) {

    Row(
        modifier = modifier
            .zIndex(2f)
            .fillMaxWidth()
            .background(
                color = colorResource(id = R.color.sheet_header_bg)
            )
            .padding(top = 16.dp, bottom = 10.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier
                .size(16.dp)
                .padding(1.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onCloseClick
                ),
            painter = painterResource(id = R.drawable.ic_details_cross),
            contentDescription = null
        )
        Spacer(modifier.weight(1f))
        Text(
            text = stringResource(id = com.moonila.features.compatibility.presentation.R.string.details_title),
            fontFamily = PoppinsFontFamily,
            maxLines = 1,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.blue_color),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier.weight(1f))
        Spacer(modifier.size(16.dp))
    }
}