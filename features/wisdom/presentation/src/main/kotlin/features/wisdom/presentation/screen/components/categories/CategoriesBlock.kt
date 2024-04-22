package features.wisdom.presentation.screen.components.categories

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
import com.moonila.features.wisdom.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.wisdom.presentation.model.CategoryItem

@Composable
fun CategoriesBlock(
    modifier: Modifier = Modifier,
    items: List<CategoryItem>,
    selectedItem: CategoryItem,
    onCategoryClick: (CategoryItem) -> Unit
) {

    val listState = rememberLazyListState()

    LazyRow(
        modifier = modifier.padding(top = 16.dp),
        state = listState,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) {
            CategoryItem(
                item = it,
                selected = it == selectedItem,
                onClick = {
                    onCategoryClick(it)
                }
            )
        }
    }

}

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    item: CategoryItem,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .height(40.dp)
            .background(
                color = colorResource(id = if (selected) R.color.tip_selected_bg else R.color.tip_unselected_bg),
                shape = RoundedCornerShape(50.dp)
            )
            .padding(horizontal = 16.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier.size(20.dp),
            painter = painterResource(id = item.iconId),
            contentDescription = null
        )

        Text(
            modifier = modifier
                .padding(start = 4.dp, top = 2.dp),
            text = stringResource(id = item.titleResId),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}