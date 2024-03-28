package features.compatibility.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import features.compatibility.presentation.CompatibilityViewModel
import features.compatibility.presentation.contract.CompatibilityAction
import features.compatibility.presentation.screen.components.ContentView

@Composable
fun CompatibilityScreen(
    modifier: Modifier = Modifier,
    viewModel: CompatibilityViewModel
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()

//    EmptyView()

    ContentView(
        items = state.items,
        onAdd = {

        },
        onItemRemove = {
            viewModel.dispatch(CompatibilityAction.ItemDelete(it))
        }
    )

}