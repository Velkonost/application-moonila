package features.feed.presentation.screen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.feed.presentation.R
import core.compose.theme.PoppinsFontFamily
import core.model.MoonInsightType
import features.feed.presentation.contract.MoonInsightState
import features.feed.presentation.model.MoonInsightItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ColumnScope.MoonInsight(
    modifier: Modifier = Modifier,
    moonInsightState: MoonInsightState,
    onItemClick: (MoonInsightType) -> Unit
) {
    val scrollState = rememberLazyListState()

    BlockTitle(text = stringResource(id = R.string.moon_insight), includeTopPadding = false)

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        state = scrollState,
        flingBehavior = rememberSnapFlingBehavior(lazyListState = scrollState),
        userScrollEnabled = true,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(moonInsightState.items) {
            MoonInsightItem(item = it, onClick = { onItemClick(it.type) })
        }

    }

}

@Composable
fun MoonInsightItem(
    modifier: Modifier = Modifier,
    item: MoonInsightItem,
    onClick: () -> Unit
) {

    val headerShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    val contentShape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)

    val title = stringResource(
        id = when (item.type) {
            MoonInsightType.MoonDay -> R.string.moon_day
            MoonInsightType.MoonSign -> R.string.moon_sign
            MoonInsightType.MoonPhase -> R.string.moon_phase
        }
    )

    val icon = painterResource(
        id = when (item.type) {
            MoonInsightType.MoonDay -> R.drawable.ic_moon_day
            MoonInsightType.MoonSign -> R.drawable.ic_moon_sign
            MoonInsightType.MoonPhase -> R.drawable.ic_moon_phase
        }
    )

    val bgColor = colorResource(
        id = when (item.type) {
            MoonInsightType.MoonDay -> R.color.moon_day_bg
            MoonInsightType.MoonSign -> R.color.moon_sign_bg
            MoonInsightType.MoonPhase -> R.color.moon_phase_bg
        }
    )

    Column(
        modifier = modifier
            .width(280.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .height(48.dp)
                .clip(headerShape)
                .background(
                    color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                    shape = headerShape
                )
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = bgColor,
                fontSize = 20.sp,
            )
            Spacer(modifier.weight(1f))

            if (item.type in listOf(MoonInsightType.MoonDay, MoonInsightType.MoonSign)) {
                Box(
                    modifier = modifier
                        .size(30.dp)
                        .background(
                            color = bgColor,
                            shape = CircleShape
                        )
                ) {

                    if (item.type == MoonInsightType.MoonDay) {
                        Text(
                            modifier = modifier
                                .align(Alignment.Center)
                                .padding(top = 2.dp, end = 1.dp),
                            text = item.number ?: "",
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                    } else if (item.type == MoonInsightType.MoonSign && item.iconId != null) {
                        Image(
                            modifier = modifier
                                .align(Alignment.Center)
                                .size(20.dp),
                            painter = painterResource(id = item.iconId),
                            contentDescription = null
                        )
                    }
                }
            }

        }

        Box(
            modifier = modifier
                .height(290.dp)
                .clip(contentShape)
                .background(
                    color = bgColor,
                    shape = contentShape
                )
        ) {
            Image(
                modifier = modifier.fillMaxSize(),
                painter = icon,
                contentDescription = null
            )

            Column {
                Spacer(modifier.weight(1f))
                Text(
                    modifier = modifier.padding(20.dp),
                    text = item.previewText,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start
                )
            }
        }
    }

}