package features.compatibility.presentation.screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.compatibility.presentation.R
import core.compose.components.AppButton
import core.compose.theme.BonaNovaFontFamily
import core.compose.theme.PoppinsFontFamily

@Composable
fun EmptyView(
    modifier: Modifier = Modifier,
    onAdd: () -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .paint(
                painterResource(id = R.drawable.ic_compatibility_bg),
                contentScale = ContentScale.Crop
            )
            .padding(bottom = 60.dp),
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 90.dp)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier.weight(1f))
            Text(
                text = stringResource(id = R.string.empty_title),
                fontFamily = BonaNovaFontFamily,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.empty_title_color),
                fontSize = 36.sp,
                lineHeight = 36.sp,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = modifier.padding(top = 12.dp),
                text = stringResource(id = R.string.empty_subtitle),
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = com.moonila.core.compose.R.color.cloudy_color),
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier.weight(1f))
        }

        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier.weight(1f))
            AppButton(
                label = stringResource(id = R.string.empty_button),
                enabled = true,
                onClick = onAdd
            )
        }

    }

}