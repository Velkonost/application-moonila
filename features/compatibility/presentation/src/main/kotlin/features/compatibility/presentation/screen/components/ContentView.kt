package features.compatibility.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.moonila.features.compatibility.presentation.R
import features.compatibility.presentation.model.CompatibilityItem
import features.compatibility.presentation.screen.components.content.CompatibilityItemView
import features.compatibility.presentation.screen.components.content.ContentViewHeader

@Composable
fun ContentView(
    modifier: Modifier = Modifier,
    items: List<CompatibilityItem>,
    onAdd: () -> Unit,
    onItemRemove: (CompatibilityItem) -> Unit
) {

    val listState = rememberLazyListState()

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
                CompatibilityItemView(item = it) {
                    onItemRemove(it)
                }
            }
        }
    }
}

