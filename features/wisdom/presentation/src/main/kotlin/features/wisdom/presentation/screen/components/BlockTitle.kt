package features.wisdom.presentation.screen.components

import android.widget.Space
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.wisdom.presentation.R
import core.compose.theme.PoppinsFontFamily

@Composable
fun BlockTitle(
    modifier: Modifier = Modifier,
    title: String,
    paddingTop: Int = 32
) {
    Row {
        Text(
            modifier = modifier.padding(top = paddingTop.dp, start = 16.dp),
            text = title,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = com.moonila.core.compose.R.color.common_text_color),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier.weight(1f))
    }
}