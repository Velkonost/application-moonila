package core.compose.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import com.moonila.core.compose.R

@Composable
fun orangeTextGradient(fontSize: TextUnit) = TextStyle(
    brush = Brush.linearGradient(
        colors = listOf(
            colorResource(id = R.color.orange_gradient_start),
            colorResource(id = R.color.orange_gradient_end)
        ),
        tileMode = TileMode.Mirror
    ),
    fontSize = fontSize
)

@Composable
fun pinkTextGradient(fontSize: TextUnit) = TextStyle(
    brush = Brush.linearGradient(
        colors = listOf(
            colorResource(id = R.color.pink_gradient_start),
            colorResource(id = R.color.pink_gradient_end)
        ),
        tileMode = TileMode.Mirror
    ),
    fontSize = fontSize
)

@Composable
fun blueTextGradient(fontSize: TextUnit) = TextStyle(
    brush = Brush.linearGradient(
        colors = listOf(
            colorResource(id = R.color.blue_gradient_start),
            colorResource(id = R.color.blue_gradient_end)
        ),
        tileMode = TileMode.Mirror
    ),
    fontSize = fontSize
)