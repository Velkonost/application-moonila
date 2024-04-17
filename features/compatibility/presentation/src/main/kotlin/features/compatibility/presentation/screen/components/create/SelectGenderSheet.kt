package features.compatibility.presentation.screen.components.create

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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.commandiron.wheel_picker_compose.core.WheelPickerDefaults
import com.commandiron.wheel_picker_compose.core.WheelTextPicker
import com.moonila.features.compatibility.presentation.R
import core.compose.components.AppButton
import core.compose.theme.PoppinsFontFamily
import kotlinx.coroutines.launch
import okhttp3.internal.immutableListOf

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectGenderSheet(
    modifier: Modifier = Modifier,
    modalSheetState: ModalBottomSheetState,
    index: Int = 1,
    onSaveClick: (Int, String) -> Unit
) {

    val scope = rememberCoroutineScope()
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val resources = LocalContext.current.resources

    var selectedIndex by remember { mutableIntStateOf(index) }

    val items = remember {
        listOf(
            resources.getString(R.string.gender_female),
            resources.getString(R.string.gender_male),
            resources.getString(R.string.gender_other)
        )
    }

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

                Spacer(modifier = modifier.height(24.dp))

                WheelTextPicker(
                    size = DpSize(screenWidth - 40.dp, 140.dp),
                    texts = items,
                    rowCount = 3,
                    forceSelectorSize = DpSize(screenWidth - 40.dp, 36.dp),
                    infinite = false,
                    style = TextStyle(
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 20.sp
                    ),
                    color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                    selectorProperties = WheelPickerDefaults.selectorProperties(
                        enabled = true,
                        shape = RoundedCornerShape(10.dp),
                        color = colorResource(id = R.color.picker_selector_color),
                        border = null
                    ),
                    startIndex = index,
                    onScrollFinished = { snappedIndex ->
                        selectedIndex = snappedIndex
                        return@WheelTextPicker snappedIndex
                    }
                )

                Spacer(modifier = modifier.height(24.dp))

                AppButton(
                    label = stringResource(id = com.moonila.core.compose.R.string.save_btn),
                    enabled = true
                ) {
                    onSaveClick(selectedIndex, items[selectedIndex])

                    scope.launch {
                        modalSheetState.hide()
                    }
                }


            }
        }
    ) {}
}