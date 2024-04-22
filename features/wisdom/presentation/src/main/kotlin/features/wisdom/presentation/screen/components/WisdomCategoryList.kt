package features.wisdom.presentation.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import features.wisdom.presentation.screen.components.items.MediumFullImageItem
import features.wisdom.presentation.screen.components.items.MediumItem

@Composable
fun WisdomCategoryList(
    modifier: Modifier = Modifier,
    fullImage: Boolean,
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
            if (fullImage) {
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
            } else {
                MediumItem(
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
}