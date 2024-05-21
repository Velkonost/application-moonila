package features.selfknowledge.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.selfknowledge.presentation.R
import core.compose.theme.BonaNovaFontFamily
import core.compose.theme.PoppinsFontFamily

@Composable
fun Header(
    modifier: Modifier = Modifier,
    name: String,
    subtitle: String,
    onProfileClick: () -> Unit
) {
    Box {
        Column(
            modifier = modifier
                .padding(top = 40.dp)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {

                Spacer(modifier = modifier.size(28.dp))
                Spacer(modifier = modifier.weight(1f))

                Text(
                    text = stringResource(id = R.string.about_me),
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                    fontSize = 16.sp
                )

                Spacer(modifier = modifier.weight(1f))

                Image(
                    modifier = modifier
                        .size(28.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = onProfileClick
                        ),
                    painter = painterResource(id = com.moonila.core.compose.R.drawable.ic_profile),
                    contentDescription = null
                )
            }


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