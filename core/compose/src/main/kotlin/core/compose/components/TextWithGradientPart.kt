package core.compose.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import com.moonila.core.compose.R
import core.compose.theme.PoppinsFontFamily

@Composable
fun TextWithGradientPart(
    modifier: Modifier = Modifier,
    text: String,
    suffix: String? = null,
    colorfulTextAtStart: String? = null,
    colorfulTextAtEnd: String? = null,
    commonTextColor: Color,
    textSize: TextUnit,
    fontWeight: FontWeight
) {
    val annotatedText = buildAnnotatedString {

        colorfulTextAtStart?.let {
            withStyle(
                style = SpanStyle(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            colorResource(id = R.color.orange_gradient_start),
                            colorResource(id = R.color.orange_gradient_end)
                        ),
                        tileMode = TileMode.Mirror
                    ),
                )
            ) {
                append(colorfulTextAtStart)
            }
        }

        withStyle(style = SpanStyle(color = commonTextColor)) {
            append(text)
        }

        colorfulTextAtEnd?.let {
            withStyle(
                style = SpanStyle(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            colorResource(id = R.color.orange_gradient_start),
                            colorResource(id = R.color.orange_gradient_end)
                        ),
                        tileMode = TileMode.Mirror
                    ),
                )
            ) {
                append(colorfulTextAtEnd)
            }
        }

        suffix?.let {
            withStyle(style = SpanStyle(color = commonTextColor)) {
                append(it)
            }
        }

    }

    Text(
        text = annotatedText,
        fontFamily = PoppinsFontFamily,
        fontSize = textSize,
        fontWeight = fontWeight,
        textAlign = TextAlign.Center
    )

}