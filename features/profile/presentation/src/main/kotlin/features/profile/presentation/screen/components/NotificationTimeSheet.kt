package features.profile.presentation.screen.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.commandiron.wheel_picker_compose.WheelTimePicker
import com.commandiron.wheel_picker_compose.core.WheelPickerDefaults
import com.moonila.core.compose.R
import core.compose.components.AppButton
import core.compose.theme.PoppinsFontFamily
import kotlinx.coroutines.launch
import java.time.LocalTime

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NotificationTimeSheet(
    modifier: Modifier = Modifier,
    modalSheetState: ModalBottomSheetState,
    onSubmitClick: (String?) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    var selectedTime by remember { mutableStateOf<String?>(null) }

    val scope = rememberCoroutineScope()
    BackHandler {
        scope.launch {
            modalSheetState.hide()
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetBackgroundColor = colorResource(id = R.color.general_bg),
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
                            color = colorResource(id = R.color.grabber_color),
                            shape = RoundedCornerShape(20.dp)
                        )
                )

                Spacer(modifier = modifier.height(32.dp))
                WheelTimePicker(
                    startTime = LocalTime.now(),
                    size = DpSize(screenWidth - 40.dp, 250.dp),
                    rowCount = 7,
                    textStyle = TextStyle(
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 20.sp
                    ),
                    textColor = colorResource(id = R.color.light_color),
                    selectorProperties = WheelPickerDefaults.selectorProperties(
                        enabled = true,
                        shape = RoundedCornerShape(10.dp),
                        color = colorResource(id = com.moonila.features.profile.presentation.R.color.time_picker),
                        border = null
                    )
                ) { snappedDateTime ->
                    selectedTime = snappedDateTime.toString()
                }

                Spacer(modifier = modifier.height(32.dp))

                AppButton(
                    label = stringResource(id = com.moonila.features.profile.presentation.R.string.notification_submit),
                    enabled = true
                ) {
                    onSubmitClick.invoke(selectedTime)
                }
            }
        }
    ) {}

}