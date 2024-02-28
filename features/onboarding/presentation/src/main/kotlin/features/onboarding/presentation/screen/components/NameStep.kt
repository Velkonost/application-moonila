package features.onboarding.presentation.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.onboarding.presentation.R
import core.compose.components.SingleLineTextField
import core.compose.components.TextWithGradientPart
import core.compose.theme.PoppinsFontFamily

@Composable
fun NameStep(
    modifier: Modifier = Modifier,
    value: String,
    onValueChanged: (String) -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextWithGradientPart(
            text = stringResource(id = R.string.welcome_to),
            commonTextColor = colorResource(id = R.color.title_color),
            textSize = 24.sp,
            fontWeight = FontWeight.Medium,
            colorfulTextAtEnd = stringResource(id = com.moonila.core.compose.R.string.app_name)
        )

        Text(
            modifier = modifier.padding(top = 8.dp),
            text = stringResource(id = R.string.name_text),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = com.moonila.core.compose.R.color.common_text_color)
        )

        SingleLineTextField(
            modifier = modifier.padding(top = 24.dp),
            value = value,
            placeholderText = stringResource(id = R.string.name_hint),
            onValueChanged = onValueChanged,
            onClearClick = {

            }
        )
    }
}