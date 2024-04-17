package features.compatibility.presentation.screen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import features.compatibility.presentation.CompatibilityViewModel
import features.compatibility.presentation.contract.CompatibilityAction
import features.compatibility.presentation.contract.CompatibilityEvent
import features.compatibility.presentation.screen.components.ContentView
import features.compatibility.presentation.screen.components.CreateCompatibilitySheet
import features.compatibility.presentation.screen.components.EmptyView
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CompatibilityScreen(
    modifier: Modifier = Modifier,
    viewModel: CompatibilityViewModel,
    forceHideBottomBar: MutableState<Boolean> = mutableStateOf(false)
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()

    val createSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )

    if (state.items.isEmpty()) {
        EmptyView {
            scope.launch {
                viewModel.dispatch(CompatibilityAction.ClearCreation)
                createSheetState.show()
            }
        }
    } else {
        ContentView(
            items = state.items,
            forceHideBottomBar = forceHideBottomBar,
            onAdd = {
                scope.launch {
                    viewModel.dispatch(CompatibilityAction.ClearCreation)
                    createSheetState.show()
                }
            },
            onItemRemove = {
                viewModel.dispatch(CompatibilityAction.ItemDelete(it))
            }
        )
    }

    CreateCompatibilitySheet(
        modalSheetState = createSheetState,
        createCompatibilityViewState = state.createCompatibilityViewState,
        onFirstPersonNameChanged = {
            viewModel.dispatch(CompatibilityAction.CreateCompatibilityAction.FirstPersonNameChanged(it))
        },
        onSecondPersonNameChanged = {
            viewModel.dispatch(CompatibilityAction.CreateCompatibilityAction.SecondPersonNameChanged(it))
        },
        onFirstPersonDateChanged = { day, month, year ->
            viewModel.dispatch(CompatibilityAction.CreateCompatibilityAction.FirstPersonDateChanged(day, month, year))
        },
        onSecondPersonDateChanged = { day, month, year ->
            viewModel.dispatch(CompatibilityAction.CreateCompatibilityAction.SecondPersonDateChanged(day, month, year))
        },
        onFirstPersonGenderChanged = { index, label ->
            viewModel.dispatch(CompatibilityAction.CreateCompatibilityAction.FirstPersonGenderChanged(index, label))
        },
        onSecondPersonGenderChanged = { index, label ->
            viewModel.dispatch(CompatibilityAction.CreateCompatibilityAction.SecondPersonGenderChanged(index, label))
        },
        onSaveClick = {
            viewModel.dispatch(CompatibilityAction.CreateCompatibilityAction.CreateClick)

        }
    )

    LaunchedEffect(createSheetState.currentValue) {
        forceHideBottomBar.value = createSheetState.isVisible
    }

    LaunchedEffect(Unit) {
        viewModel.events.collectLatest {
            when (it) {
                is CompatibilityEvent.CreatedSuccess -> {
                    createSheetState.hide()
                }

            }
        }
    }

}