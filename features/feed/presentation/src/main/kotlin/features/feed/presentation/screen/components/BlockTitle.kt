package features.feed.presentation.screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.feed.presentation.R
import core.compose.composable.orangeTextGradient
import core.compose.theme.PoppinsFontFamily

@Composable
fun BlockTitle(
    modifier: Modifier = Modifier,
    text: String,
    includeTopPadding: Boolean = true
) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .padding(top = if (includeTopPadding) 24.dp else 0.dp)
    ) {
        Text(
            text = text,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.secondary_color),
            fontSize = 16.sp
        )
        Spacer(modifier.weight(1f))
    }

}