package features.feed.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.feed.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.feed.presentation.contract.MoonTipsState
import features.feed.presentation.model.MoonTipsItem
import features.feed.presentation.screen.components.moontips.MoonTipContentBlock
import features.feed.presentation.screen.components.moontips.MoonTipsCategoryItem

@Composable
fun MoonTips(
    modifier: Modifier = Modifier,
    moonTipsState: MoonTipsState,
    onItemClick: (MoonTipsItem) -> Unit
) {

    val listState = rememberLazyListState()

    BlockTitle(text = stringResource(id = R.string.moon_tips))

    LazyRow(
        modifier = modifier.padding(top = 12.dp),
        state = listState,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(moonTipsState.items) {
            MoonTipsCategoryItem(
                item = it,
                selected = it == moonTipsState.selectedItem.type,
                onClick = {
                    onItemClick(it)
                }
            )
        }
    }

    MoonTipContentBlock(item = moonTipsState.selectedItem)

}

