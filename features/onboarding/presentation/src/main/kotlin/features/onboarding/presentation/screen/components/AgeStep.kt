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
import com.ozcanalasalvar.datepicker.compose.datepicker.WheelDatePicker
import core.compose.components.TextWithGradientPart
import core.compose.theme.PoppinsFontFamily

@Composable
fun AgeStep(
    modifier: Modifier = Modifier,
    userName: String
) {
    Column(
        modifier = modifier
            .padding(top = 100.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextWithGradientPart(
            text = stringResource(id = R.string.age_title),
            commonTextColor = colorResource(id = R.color.title_color),
            textSize = 24.sp,
            fontWeight = FontWeight.Medium,
            colorfulTextAtEnd = ""
        )

        TextWithGradientPart(
            modifier = modifier.padding(top = 8.dp),
            text = stringResource(id = R.string.age_text),
            commonTextColor = colorResource(id = com.moonila.core.compose.R.color.common_text_color),
            textSize = 14.sp,
            fontWeight = FontWeight.Normal,
            colorfulTextAtStart = userName
        )

        WheelDatePicker(
//            offset =/*offset*/,
//            yearsRange = IntRange(/*minYear*/,/*maxYear*/),
//            startDate =/*startDate*/,
//            textSize =/*textSize*/,
//            selectorEffectEnabled =/*selectorEffectEnabled*/,
//            darkModeEnabled =/*darkModeEnabled*/,
            onDateChanged = { day, month, year, date ->
                /*Handle date changes*/
            }
        )

//        Text(
//            modifier = modifier.padding(top = 8.dp),
//            text = stringResource(id = R.string.gender_text),
//            fontFamily = PoppinsFontFamily,
//            fontWeight = FontWeight.Normal,
//            fontSize = 14.sp,
//            textAlign = TextAlign.Center,
//            color = colorResource(id = com.moonila.core.compose.R.color.common_text_color)
//        )


    }

}