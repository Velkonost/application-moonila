package features.selfknowledge.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.moonila.features.selfknowledge.presentation.R
import features.selfknowledge.presentation.SelfKnowledgeViewModel
import features.selfknowledge.presentation.contract.SelfKnowledgeNavigation
import features.selfknowledge.presentation.screen.components.Header
import features.selfknowledge.presentation.screen.components.SelfKnowledgeDetailsSheet
import features.selfknowledge.presentation.screen.components.SelfKnowledgeItemView
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelfKnowledgeScreen(
    modifier: Modifier = Modifier,
    viewModel: SelfKnowledgeViewModel,
    forceHideBottomBar: MutableState<Boolean> = mutableStateOf(false)
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()

    val selectedItemState = remember { mutableStateOf(state.items.first()) }
    val selectedItem by selectedItemState

    val detailsSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .paint(
                painterResource(id = R.drawable.ic_selfknowledge_bg),
                contentScale = ContentScale.Crop
            )
            .padding(bottom = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(
            name = state.userName,
            subtitle = state.userData,
            onProfileClick = {
                viewModel.dispatch(SelfKnowledgeNavigation.NavigateToProfile)
            }
        )

        Spacer(modifier.height(20.dp))

        state.items.map {
            SelfKnowledgeItemView(item = it) {
                selectedItemState.value = it
                scope.launch {
                    detailsSheetState.show()
                }

            }
            Spacer(modifier.height(24.dp))
        }
    }

    SelfKnowledgeDetailsSheet(
        modalSheetState = detailsSheetState,
        item = selectedItem
    )

    LaunchedEffect(detailsSheetState.currentValue) {
        forceHideBottomBar.value = detailsSheetState.isVisible
    }
}