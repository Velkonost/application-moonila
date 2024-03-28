package features.compatibility.presentation.screen.components.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
fun DetailsImportantPoints(
    modifier: Modifier = Modifier,
    items: List<String>
) {

    Column(
        modifier = modifier
            .padding(top = 20.dp)
            .background(
                color = colorResource(id = R.color.details_important_points_bg),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.details_important_points),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = com.moonila.core.compose.R.color.light_color),
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )

        items.forEach {
            Row(modifier = modifier.padding(top = 16.dp)) {
                Image(
                    modifier = modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_compatibility_details_point),
                    contentDescription = null
                )

                Text(
                    modifier = modifier.padding(start = 6.dp),
                    text = it,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = com.moonila.core.compose.R.color.cloudy_color),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}