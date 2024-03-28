package features.compatibility.presentation.screen.components.content

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DismissDirection
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.compatibility.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.compatibility.presentation.model.CompatibilityItem
import kotlinx.coroutines.delay

@OptIn(
    ExperimentalMaterialApi::class, ExperimentalFoundationApi::class,
    ExperimentalLayoutApi::class
)
@Composable
fun LazyItemScope.CompatibilityItemView(
    modifier: Modifier = Modifier,
    item: CompatibilityItem,
    onClick: () -> Unit,
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
                .padding(top = 16.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onClick
                ),
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

                    FlowRow {
                        Text(
                            text = item.firstName,
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = " & ",
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White.copy(alpha = 0.5f),
                            fontSize = 24.sp,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = item.secondName,
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Start
                        )
                    }

                    Row(modifier = modifier.padding(top = 4.dp)) {
                        Text(
                            text = stringResource(id = R.string.compatibility_percent),
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            modifier = modifier.padding(start = 2.dp),
                            text = "${item.percent}%",
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(id = com.moonila.core.compose.R.color.main_yellow),
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start
                        )
                    }

                    CompatibilityItemFooter(
                        firstMoonIconResId = item.firstMoonIcon,
                        secondMoonIconResId = item.secondMoonIcon,
                        firstSignIconResId = item.firstSignIcon,
                        secondSignIconResId = item.secondSignIcon
                    )

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
