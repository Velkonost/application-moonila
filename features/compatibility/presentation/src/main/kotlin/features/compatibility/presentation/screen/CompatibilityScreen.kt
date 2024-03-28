package features.compatibility.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import features.compatibility.presentation.CompatibilityViewModel
import features.compatibility.presentation.contract.CompatibilityAction
import features.compatibility.presentation.screen.components.ContentView
import features.compatibility.presentation.screen.components.EmptyView

@Composable
fun CompatibilityScreen(
    modifier: Modifier = Modifier,
    viewModel: CompatibilityViewModel,
    forceHideBottomBar: MutableState<Boolean> = mutableStateOf(false)
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()

    if (state.items.isEmpty()) {
        EmptyView()
    } else {
        ContentView(
            items = state.items,
            forceHideBottomBar = forceHideBottomBar,
            onAdd = {

            },
            onItemRemove = {
                viewModel.dispatch(CompatibilityAction.ItemDelete(it))
            }
        )
    }

}