package features.wisdom.presentation.screen.components.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.wisdom.presentation.R
import core.compose.theme.PoppinsFontFamily

@Composable
fun MediumFullImageItem(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    icon: Painter = painterResource(id = R.drawable.ic_news_of_the_day_sample),
    onClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {

    Box(
        modifier = modifier
            .width(250.dp)
            .height(270.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
    ) {
        Image(
            modifier = modifier.fillMaxSize(),
            painter = icon,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(modifier = modifier.padding(12.dp)) {
            Row {
                Spacer(modifier.weight(1f))
                Image(
                    modifier = modifier
                        .size(22.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = onFavoriteClick
                        ),
                    painter = painterResource(id = R.drawable.ic_wisdom_favorite_no_border),
                    contentDescription = null
                )
            }
            Spacer(modifier.weight(1f))

            Text(
                modifier = modifier
                    .padding(horizontal = 8.dp),
                text = title,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = com.moonila.core.compose.R.color.cloudy_color),
                fontSize = 18.sp,
                textAlign = TextAlign.Start
            )

            Text(
                modifier = modifier
                    .alpha(0.7f)
                    .padding(horizontal = 8.dp)
                    .padding(top = 8.dp),
                text = description,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                maxLines = 2,
                color = colorResource(id = com.moonila.core.compose.R.color.cloudy_color),
                fontSize = 14.sp,
                lineHeight = 20.sp,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start
            )
        }
    }

}