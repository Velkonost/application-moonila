package features.wisdom.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.core.compose.R
import core.compose.theme.PoppinsFontFamily

@Composable
fun Header(
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit
) {

    Row(
        modifier = modifier
            .padding(top = 40.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
    ) {
        Spacer(modifier.width(32.dp))
        Spacer(modifier.weight(1f))
        Text(
            text = stringResource(id = com.moonila.features.wisdom.presentation.R.string.wisdom_title),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.light_color),
            fontSize = 16.sp
        )
        Spacer(modifier.weight(1f))

        Image(
            modifier = modifier.size(32.dp).clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onFavoriteClick
            ),
            painter = painterResource(id = com.moonila.features.wisdom.presentation.R.drawable.ic_wisdom_favorite),
            contentDescription = null
        )
    }
}