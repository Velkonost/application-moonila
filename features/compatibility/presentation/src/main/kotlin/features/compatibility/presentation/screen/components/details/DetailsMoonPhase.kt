package features.compatibility.presentation.screen.components.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.compatibility.presentation.R
import core.compose.composable.orangeTextGradient
import core.compose.theme.BonaNovaFontFamily
import core.compose.theme.PoppinsFontFamily

@Composable
fun DetailsMoonPhase(
    modifier: Modifier = Modifier,
    blockTitle: String,
    firstIconResId: Int,
    secondIconResId: Int,
    firstTitle: String,
    secondTitle: String,
    textFirstPart: String,
    textSecondPart: String,
    bgColor: Color
) {

    Box(
        modifier = modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .background(
                color = bgColor,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.TopStart
    ) {
        Image(
            modifier = modifier
                .align(Alignment.TopStart),
            painter = painterResource(id = R.drawable.ic_compatibility_details_moon_phase_union),
            contentDescription = null,
        )

        Column(
            modifier = modifier.padding(20.dp)
        ) {
            Text(
                text = blockTitle,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                fontSize = 20.sp,
                textAlign = TextAlign.Start
            )

            Text(
                modifier = modifier.padding(top = 8.dp),
                text = textFirstPart,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = com.moonila.core.compose.R.color.cloudy_color),
                fontSize = 14.sp,
                textAlign = TextAlign.Start
            )

            Row(
                modifier = modifier.padding(top = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = modifier.size(100.dp),
                    painter = painterResource(id = firstIconResId),
                    contentDescription = null
                )
                Spacer(modifier.weight(1f))
                Image(
                    modifier = modifier.size(26.dp),
                    painter = painterResource(id = R.drawable.ic_compatibility_details_plus),
                    contentDescription = null
                )
                Spacer(modifier.weight(1f))
                Image(
                    modifier = modifier.size(100.dp),
                    painter = painterResource(id = secondIconResId),
                    contentDescription = null
                )
            }

            Row(
                modifier = modifier.padding(top = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = firstTitle,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    style = orangeTextGradient(fontSize = 20.sp)
                )
                Image(
                    modifier = modifier.padding(horizontal = 6.dp).size(12.dp),
                    painter = painterResource(id = R.drawable.ic_compatibility_details_plus),
                    contentDescription = null
                )
                Text(
                    modifier = modifier.padding(top = 2.dp),
                    text = secondTitle,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start
                )

                Spacer(modifier.weight(1f))
            }

            Text(
                modifier = modifier.padding(top = 8.dp),
                text = textSecondPart,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = com.moonila.core.compose.R.color.cloudy_color),
                fontSize = 14.sp,
                textAlign = TextAlign.Start
            )

        }
    }

}