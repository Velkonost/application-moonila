package features.compatibility.presentation.screen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissState
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.moonila.features.compatibility.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.compatibility.presentation.model.CompatibilityItem
import features.compatibility.presentation.screen.components.content.ContentViewHeader
import kotlinx.coroutines.delay

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
            state = listState
        ) {
            items(items, key = { it.id }) {
                CompatibilityItemView(item = it) {
                    onItemRemove(it)
                }
            }
        }
    }


}

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun LazyItemScope.CompatibilityItemView(
    modifier: Modifier = Modifier,
    item: CompatibilityItem,
    onRemove: () -> Unit
) {

    var show by remember { mutableStateOf(true) }

    val dismissState = rememberDismissState(
        confirmStateChange = {
            if (it == DismissValue.DismissedToStart) {
                show = false
                true
            } else false
        }
    )

    AnimatedVisibility(
        modifier = modifier.animateItemPlacement(),
        visible = show, exit = fadeOut(spring())
    ) {
        SwipeToDismiss(
            state = dismissState,
            directions = setOf(DismissDirection.EndToStart),
            modifier = modifier
                .animateItemPlacement()
                .padding(top = 16.dp),
            background = {
                DismissBackground(dismissState = dismissState)
            },
            dismissContent = {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(
                            color = colorResource(id = R.color.compatibility_item_bg),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(vertical = 20.dp, horizontal = 16.dp)
                ) {
                    Text(
                        text = "${item.firstName} & ${item.secondName}",
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Start
                    )

                    Row(modifier = modifier.padding(top = 8.dp)) {
                        Text(
                            text = stringResource(id = R.string.compatibility_percent),
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            modifier = modifier.padding(start = 2.dp),
                            text = item.percent,
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(id = com.moonila.core.compose.R.color.main_yellow),
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start
                        )
                    }

                }
            }
        )
    }

    LaunchedEffect(show) {
        if (!show) {
            delay(800)
            onRemove()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DismissBackground(
    modifier: Modifier = Modifier,
    dismissState: DismissState
) {
    val direction = dismissState.dismissDirection

    Row(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = colorResource(id = R.color.dismiss_bg),
                shape = RoundedCornerShape(16.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier.weight(1f))
        Image(
            modifier = modifier
                .padding(end = 12.dp)
                .size(24.dp),
            painter = painterResource(id = R.drawable.ic_compatibility_trash),
            contentDescription = null
        )
    }
}