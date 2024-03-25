package features.compatibility.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import features.compatibility.presentation.CompatibilityViewModel
import features.compatibility.presentation.screen.components.EmptyView

@Composable
fun CompatibilityScreen(
    modifier: Modifier = Modifier,
    viewModel: CompatibilityViewModel
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()

    EmptyView()
}