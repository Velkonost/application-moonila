package features.compatibility.presentation.screen.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.compatibility.presentation.R
import core.compose.components.AppButton
import core.compose.components.Keyboard
import core.compose.components.keyboardAsState
import core.compose.theme.PoppinsFontFamily
import features.compatibility.presentation.contract.CreateCompatibilityViewState
import features.compatibility.presentation.screen.components.create.CreateHeader
import features.compatibility.presentation.screen.components.create.PersonData
import features.compatibility.presentation.screen.components.create.SelectDateSheet
import features.compatibility.presentation.screen.components.create.SelectGenderSheet
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
    onSecondPersonDateChanged: (Int, Int, Int) -> Unit,
    onFirstPersonGenderChanged: (Int, String) -> Unit,
    onSecondPersonGenderChanged: (Int, String) -> Unit,
    onSaveClick: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val isKeyboardOpen by keyboardAsState()


    val selectDateSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )
    val selectGenderSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )

    val currentPersonIndex = remember { mutableIntStateOf(0) }

    BackHandler {
        scope.launch {
            if (selectDateSheetState.isVisible) {
                selectDateSheetState.hide()
            } else if (selectGenderSheetState.isVisible) {
                selectGenderSheetState.hide()
            } else modalSheetState.hide()
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetBackgroundColor = colorResource(id = R.color.main_bg),
        sheetContent = {
            Box(
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
                        .padding(bottom = 260.dp, top = 52.dp)
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
                        gender = createCompatibilityViewState.firstPersonGender.label,
                        errors = createCompatibilityViewState.firstPersonErrors,
                        onNameChanged = onFirstPersonNameChanged,
                        onGenderClick = {
                            scope.launch {
                                currentPersonIndex.intValue = 0
                                selectGenderSheetState.show()
                            }
                        },
                        onDateClick = {
                            scope.launch {
                                currentPersonIndex.intValue = 0
                                selectDateSheetState.show()
                            }
                        },
                    )

                    Spacer(modifier = modifier.height(20.dp))

                    PersonData(
                        title = stringResource(id = R.string.second_person),
                        name = createCompatibilityViewState.secondPersonName,
                        date = createCompatibilityViewState.secondPersonDate.label,
                        gender = createCompatibilityViewState.secondPersonGender.label,
                        errors = createCompatibilityViewState.secondPersonErrors,
                        onNameChanged = onSecondPersonNameChanged,
                        onGenderClick = {
                            scope.launch {
                                currentPersonIndex.intValue = 1
                                selectGenderSheetState.show()
                            }
                        },
                        onDateClick = {
                            scope.launch {
                                currentPersonIndex.intValue = 1
                                selectDateSheetState.show()
                            }
                        },
                    )

                }

                if (isKeyboardOpen == Keyboard.Closed) {
                    Column(modifier = modifier.fillMaxSize()) {
                        Spacer(modifier.weight(1f))

                        Box(
                            modifier = modifier
                                .height(180.dp)
                                .fillMaxWidth()
                                .background(
                                    brush = Brush.verticalGradient(
                                        0.1f to Color.Transparent,
                                        0.5f to colorResource(id = R.color.main_bg),
                                    )
                                )
                        )
                    }

                    Column(modifier = modifier.fillMaxSize()) {
                        Spacer(modifier.weight(1f))

                        AppButton(
                            label = stringResource(
                                id = if (createCompatibilityViewState.eligible) R.string.done_btn
                                else R.string.add_details_btn
                            ),
                            enabled = true,
                            onClick = onSaveClick
                        )
                    }
                }
            }
        }
    ) {}

    SelectDateSheet(
        modalSheetState = selectDateSheetState,
        year = if (currentPersonIndex.intValue == 0) createCompatibilityViewState.firstPersonDate.year
        else createCompatibilityViewState.secondPersonDate.year,
        month = if (currentPersonIndex.intValue == 0) createCompatibilityViewState.firstPersonDate.month
        else createCompatibilityViewState.secondPersonDate.month,
        dayOfMonth = if (currentPersonIndex.intValue == 0) createCompatibilityViewState.firstPersonDate.day
        else createCompatibilityViewState.secondPersonDate.day,
        onSaveClick = { day, month, year ->
            if (currentPersonIndex.intValue == 0) {
                onFirstPersonDateChanged(day, month, year)
            } else {
                onSecondPersonDateChanged(day, month, year)
            }
        }
    )

    SelectGenderSheet(
        modalSheetState = selectGenderSheetState,
        index = if (currentPersonIndex.intValue == 0) createCompatibilityViewState.firstPersonGender.index
        else createCompatibilityViewState.secondPersonGender.index,
        onSaveClick = { index, label ->
            if (currentPersonIndex.intValue == 0) {
                onFirstPersonGenderChanged(index, label)
            } else {
                onSecondPersonGenderChanged(index, label)
            }
        }
    )
}