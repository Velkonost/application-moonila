package features.onboarding.presentation.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.commandiron.wheel_picker_compose.WheelDatePicker
import com.commandiron.wheel_picker_compose.core.WheelPickerDefaults
import com.moonila.features.onboarding.presentation.R
import core.compose.components.TextWithGradientPart
import core.compose.theme.PoppinsFontFamily
import java.time.LocalDate

@Composable
fun AgeStep(
    modifier: Modifier = Modifier,
    userName: String
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

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

        Spacer(modifier.height(32.dp))

        WheelDatePicker(
            startDate = LocalDate.of(
                1995, 1, 25
            ),
            minDate = LocalDate.MIN,
            maxDate = LocalDate.now(),
            size = DpSize(screenWidth - 40.dp, 250.dp),
            rowCount = 7,
            textStyle = TextStyle(
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            ),
            textColor = colorResource(id = com.moonila.core.compose.R.color.light_color),
            selectorProperties = WheelPickerDefaults.selectorProperties(
                enabled = true,
                shape = RoundedCornerShape(10.dp),
                color = colorResource(id = R.color.default_item)
            )
        ) { snappedDateTime -> }
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