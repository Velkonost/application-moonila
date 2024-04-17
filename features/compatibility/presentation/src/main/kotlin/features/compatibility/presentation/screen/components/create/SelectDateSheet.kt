package features.compatibility.presentation.screen.components.create

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.compatibility.presentation.R
import core.compose.theme.PoppinsFontFamily
import java.time.LocalDate

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectDateSheet(
    modifier: Modifier = Modifier,
    modalSheetState: ModalBottomSheetState,
) {

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetBackgroundColor = colorResource(id = R.color.main_bg),
        sheetContent = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = modifier
                        .padding(top = 6.dp)
                        .width(66.dp)
                        .height(4.dp)
                        .background(
                            color = colorResource(id = R.color.sheet_grabber_color),
                            shape = RoundedCornerShape(20.dp)
                        )
                )

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
                        color = colorResource(id = R.color.default_item),
                        border = null
                    )
                ) { snappedDateTime -> }

            }
        }
    ) {}
}