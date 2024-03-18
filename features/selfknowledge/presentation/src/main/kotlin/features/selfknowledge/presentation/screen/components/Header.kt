package features.selfknowledge.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.selfknowledge.presentation.R
import core.compose.composable.orangeTextGradient
import core.compose.theme.BonaNovaFontFamily
import core.compose.theme.PoppinsFontFamily

@Composable
fun Header(
    modifier: Modifier = Modifier,
    name: String,
    subtitle: String
) {
    Box {

        Column(
            modifier = modifier
                .padding(top = 40.dp)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(id = R.string.about_me),
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                fontSize = 16.sp
            )

            Text(
                modifier = modifier.padding(top = 26.dp),
                text = name,
                fontFamily = BonaNovaFontFamily,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            colorResource(id = R.color.name_gradient_1),
                            colorResource(id = R.color.name_gradient_2),
                            colorResource(id = R.color.name_gradient_3),
//                            colorResource(id = R.color.name_gradient_4),
//                            colorResource(id = R.color.name_gradient_5),
                        ),
                        tileMode = TileMode.Clamp
                    ),
                    fontSize = 32.sp
                ),
            )

            Text(
                modifier = modifier.padding(top = 16.dp),
                text = subtitle,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Box(
                modifier = modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(
                        color = colorResource(id = R.color.divider_color),
                        shape = MaterialTheme.shapes.medium
                    )
            )
        }
    }
}