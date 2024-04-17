package features.compatibility.presentation.screen.components.create

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.moonila.features.compatibility.presentation.R
import core.compose.components.AppButton
import core.compose.theme.PoppinsFontFamily
import kotlinx.coroutines.launch
import java.time.LocalDate

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectDateSheet(
    modifier: Modifier = Modifier,
    modalSheetState: ModalBottomSheetState,
    year: Int = 1995,
    month: Int = 1,
    dayOfMonth: Int = 25,
    onSaveClick: (Int, Int, Int) -> Unit
) {

    val scope = rememberCoroutineScope()
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val selectedDate: MutableState<LocalDate?> = remember { mutableStateOf(null) }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetBackgroundColor = colorResource(id = R.color.main_bg),
        sheetContent = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
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
                    modifier = modifier.padding(24.dp),
                    startDate = LocalDate.of(year, month, dayOfMonth),
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
                        color = colorResource(id = R.color.picker_selector_color),
                        border = null
                    )
                ) { snappedDateTime ->
                    selectedDate.value = snappedDateTime
                }

                Spacer(modifier = modifier.height(24.dp))

                AppButton(
                    label = stringResource(id = com.moonila.core.compose.R.string.save_btn),
                    enabled = true
                ) {
                    selectedDate.value?.let {
                        onSaveClick(it.dayOfMonth, it.monthValue, it.year)
                    }

                    scope.launch {
                        modalSheetState.hide()
                    }
                }

            }
        }
    ) {}
}