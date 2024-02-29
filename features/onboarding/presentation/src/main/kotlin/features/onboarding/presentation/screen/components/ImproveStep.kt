package features.onboarding.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.onboarding.presentation.R
import core.compose.components.TextWithGradientPart
import core.compose.theme.PoppinsFontFamily
import features.onboarding.presentation.model.Gender
import features.onboarding.presentation.model.Improve

@Composable
fun ImproveStep(
    modifier: Modifier = Modifier,
    userName: String,
    items: List<Improve>,
    selectedItems: List<Improve>,
    itemClick: (Improve) -> Unit
) {
    Column(
        modifier = modifier
            .padding(top = 100.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextWithGradientPart(
            text = stringResource(id = R.string.improve_title),
            commonTextColor = colorResource(id = R.color.title_color),
            textSize = 24.sp,
            fontWeight = FontWeight.Medium,
        )

        TextWithGradientPart(
            modifier = modifier.padding(top = 8.dp),
            text = stringResource(id = R.string.improve_text),
            commonTextColor = colorResource(id = com.moonila.core.compose.R.color.common_text_color),
            textSize = 14.sp,
            fontWeight = FontWeight.Normal,
            colorfulTextAtStart = userName
        )

        Spacer(modifier.height(12.dp))

        items.forEach {
            ImproveItem(
                item = it,
                selected = it in selectedItems,
                onClick = {
                    itemClick(it)
                }
            )
        }
    }
}

@Composable
fun ImproveItem(
    modifier: Modifier = Modifier,
    item: Improve,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .padding(top = 12.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(52.dp)
                .background(
                    color = colorResource(
                        id = if (selected) R.color.selected_item
                        else R.color.default_item
                    ),
                    shape = RoundedCornerShape(16.dp)
                )
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onClick
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier.weight(1f))
            Text(
                text = stringResource(id = item.text),
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = com.moonila.core.compose.R.color.common_text_color)
            )
            Spacer(modifier.weight(1f))
        }

        if (selected) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(52.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier.weight(1f))
                Image(
                    modifier = modifier
                        .padding(end = 14.dp)
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = null
                )
            }
        }
    }

}