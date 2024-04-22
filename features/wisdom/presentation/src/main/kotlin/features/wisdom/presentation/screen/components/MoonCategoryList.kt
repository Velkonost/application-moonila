package features.wisdom.presentation.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MoonCategoryList(
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit,
    onItemFavoriteClick: () -> Unit
) {

    val listState = rememberLazyListState()

    LazyRow(
        modifier = modifier.padding(top = 12.dp),
        state = listState,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(8) {
            MediumFullImageItem(
                title = "Benevolent moon",
                description = "In the ethereal realm of astrology, the term \"Benevolent Moon\" evokes a celestial narrative of grace and benevolence.",
                onClick = {
                    onItemClick()
                },
                onFavoriteClick = {
                    onItemFavoriteClick()
                }
            )
        }
    }
}