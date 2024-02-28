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
import androidx.compose.material3.MaterialTheme
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

@Composable
fun GenderStep(
    modifier: Modifier = Modifier,
    userName: String,
    items: List<Gender>,
    selectedItem: Gender?,
    itemClick: (Gender) -> Unit
) {
    Column(
        modifier = modifier
            .padding(top = 100.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextWithGradientPart(
            text = stringResource(id = R.string.hello),
            suffix = "!",
            commonTextColor = colorResource(id = R.color.title_color),
            textSize = 24.sp,
            fontWeight = FontWeight.Medium,
            colorfulTextAtEnd = userName
        )

        Text(
            modifier = modifier.padding(top = 8.dp),
            text = stringResource(id = R.string.gender_text),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = com.moonila.core.compose.R.color.common_text_color)
        )

        Spacer(modifier.height(12.dp))

        items.forEach {
            GenderItem(
                item = it,
                selected = it == selectedItem,
                onClick = {
                    itemClick(it)
                }
            )
        }
    }
}

@Composable
fun GenderItem(
    modifier: Modifier = Modifier,
    item: Gender,
    selected: Boolean,
    onClick: () -> Unit
) {

    Box {
        Row(
            modifier = modifier
                .padding(top = 12.dp)
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
                    .padding(top = 12.dp)
                    .fillMaxWidth()
                    .height(52.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier.weight(1f))
                Image(
                    modifier = modifier.size(24.dp),
                    painter = painterResource(id = com.moonila.core.compose.R.drawable.ic_radiobutton),
                    contentDescription = null
                )
            }
        }
    }

}