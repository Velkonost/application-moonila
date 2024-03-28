package features.compatibility.presentation.screen.components.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.moonila.features.compatibility.presentation.R

@Composable
fun DetailsProgressBar(
    modifier: Modifier = Modifier,
    percent: Int,
) {
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp.dp - 32.dp

    Box(
        modifier = modifier
            .background(
                color = colorResource(id = R.color.progress_bg),
                shape = RoundedCornerShape(12.dp)
            )
            .width(width)
            .height(21.dp)
    ) {
        Box(
            modifier = modifier
                .background(
                    color = colorResource(id = com.moonila.core.compose.R.color.main_green),
                    shape = RoundedCornerShape(12.dp)
                )
                .height(21.dp)
                .width(width * percent / 100)
        )
    }
}