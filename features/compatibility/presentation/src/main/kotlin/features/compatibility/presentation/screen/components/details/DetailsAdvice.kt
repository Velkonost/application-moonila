package features.compatibility.presentation.screen.components.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.compatibility.presentation.R
import core.compose.theme.PoppinsFontFamily

@Composable
fun DetailsAdvice(
    modifier: Modifier = Modifier,
    image: Painter,
    text: String
) {

    Column(
        modifier = modifier
            .padding(top = 20.dp)
            .background(
                color = colorResource(id = R.color.details_advice_bg),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(20.dp)
    ) {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )

        Text(
            modifier = modifier.padding(top = 12.dp),
            text = stringResource(id = R.string.details_advice),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = com.moonila.core.compose.R.color.light_color),
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )

        Text(
            modifier = modifier.padding(top = 6.dp),
            text = text,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = com.moonila.core.compose.R.color.cloudy_color),
            fontSize = 14.sp,
            textAlign = TextAlign.Start
        )
    }

}