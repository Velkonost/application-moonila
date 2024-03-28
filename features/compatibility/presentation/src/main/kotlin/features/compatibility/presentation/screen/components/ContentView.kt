package features.compatibility.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.moonila.features.compatibility.presentation.R
import features.compatibility.presentation.model.CompatibilityItem
import features.compatibility.presentation.screen.components.content.CompatibilityItemView
import features.compatibility.presentation.screen.components.content.ContentViewHeader
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ContentView(
    modifier: Modifier = Modifier,
    items: List<CompatibilityItem>,
    forceHideBottomBar: MutableState<Boolean>,
    onAdd: () -> Unit,
    onItemRemove: (CompatibilityItem) -> Unit
) {

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val detailsSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )
    var selectedItem by remember { mutableStateOf(items.first()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_bg))
            .padding(horizontal = 16.dp)
    ) {
        ContentViewHeader(onAddClick = onAdd)
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 120.dp)
        ) {
            items(items, key = { it.id }) {
                CompatibilityItemView(
                    item = it,
                    onClick = {
                        selectedItem = it
                        scope.launch {
                            detailsSheetState.show()
                        }
                    },
                    onRemove = {
                        onItemRemove(it)
                    }
                )
            }
        }
    }

    CompatibilityDetailsSheet(
        modalSheetState = detailsSheetState,
        item = selectedItem
    )

    LaunchedEffect(detailsSheetState.currentValue) {
        forceHideBottomBar.value = detailsSheetState.isVisible
    }

}

