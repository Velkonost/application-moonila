package features.compatibility.presentation.screen.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.compatibility.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.compatibility.presentation.contract.CreateCompatibilityViewState
import features.compatibility.presentation.screen.components.create.CreateHeader
import features.compatibility.presentation.screen.components.create.PersonData
import features.compatibility.presentation.screen.components.create.SelectDateSheet
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
fun CreateCompatibilitySheet(
    modifier: Modifier = Modifier,
    modalSheetState: ModalBottomSheetState,
    createCompatibilityViewState: CreateCompatibilityViewState,
    onFirstPersonNameChanged: (String) -> Unit,
    onSecondPersonNameChanged: (String) -> Unit,
    onFirstPersonDateChanged: (Int, Int, Int) -> Unit,
    onSecondPersonDateChanged: (Int, Int, Int) -> Unit
) {
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    val selectDateSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )
    val selectGenderSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )

    val selectDatePersonIndex = remember { mutableIntStateOf(0) }

    BackHandler {
        scope.launch {
            modalSheetState.hide()

            selectDateSheetState.hide()
            selectGenderSheetState.hide()
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetBackgroundColor = colorResource(id = R.color.main_bg),
        sheetContent = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f),
            ) {
                CreateHeader {
                    scope.launch {
                        modalSheetState.hide()
                    }
                }

                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .verticalScroll(scrollState)
                        .padding(bottom = 100.dp)
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        modifier = modifier.padding(top = 24.dp),
                        text = stringResource(id = R.string.create_title),
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                        fontSize = 16.sp,
                    )

                    Text(
                        modifier = modifier.padding(top = 8.dp),
                        text = stringResource(id = R.string.create_text),
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = com.moonila.core.compose.R.color.common_text_color),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Start
                    )

                    Box(
                        modifier = modifier
                            .alpha(0.5f)
                            .padding(top = 20.dp)
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(
                                color = colorResource(id = R.color.compatibility_item_bg),
                                shape = MaterialTheme.shapes.medium
                            )
                    )

                    PersonData(
                        title = stringResource(id = R.string.first_person),
                        name = createCompatibilityViewState.firstPersonName,
                        date = createCompatibilityViewState.firstPersonDate.label,
                        onNameChanged = onFirstPersonNameChanged,
                        onDateClick = {
                            scope.launch {
                                selectDatePersonIndex.intValue = 0
                                selectDateSheetState.show()
                            }
                        },
                    )

                    Spacer(modifier = modifier.height(20.dp))

                    PersonData(
                        title = stringResource(id = R.string.second_person),
                        name = createCompatibilityViewState.secondPersonName,
                        date = createCompatibilityViewState.secondPersonDate.label,
                        onNameChanged = onSecondPersonNameChanged,
                        onDateClick = {
                            scope.launch {
                                selectDatePersonIndex.intValue = 1
                                selectDateSheetState.show()
                            }
                        },
                    )

                }
            }
        }
    ) {}

    SelectDateSheet(
        modalSheetState = selectDateSheetState,
        year = if (selectDatePersonIndex.intValue == 0) createCompatibilityViewState.firstPersonDate.year
        else createCompatibilityViewState.secondPersonDate.year,
        month = if (selectDatePersonIndex.intValue == 0) createCompatibilityViewState.firstPersonDate.month
        else createCompatibilityViewState.secondPersonDate.month,
        dayOfMonth = if (selectDatePersonIndex.intValue == 0) createCompatibilityViewState.firstPersonDate.day
        else createCompatibilityViewState.secondPersonDate.day,
        onSaveClick = { day, month, year ->
            if (selectDatePersonIndex.intValue == 0) {
                onFirstPersonDateChanged(day, month, year)
            } else {
                onSecondPersonDateChanged(day, month, year)
            }
        }
    )
}