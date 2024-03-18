package features.selfknowledge.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.selfknowledge.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.selfknowledge.presentation.model.SelfKnowledgeItem
import features.selfknowledge.presentation.model.SelfKnowledgeItemPoint

@Composable
fun SelfKnowledgeItemView(
    modifier: Modifier = Modifier,
    item: SelfKnowledgeItem
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(
                color = colorResource(id = item.colorResId),
                shape = RoundedCornerShape(16.dp)
            )
    ) {

        Row {
            Spacer(modifier.weight(1f))
            Image(
                modifier = modifier.size(200.dp),
                painter = painterResource(id = item.iconId),
                contentDescription = null
            )
        }

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = stringResource(id = item.titleResId),
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                fontSize = 20.sp
            )

            Text(
                modifier = modifier.padding(top = 12.dp),
                text = item.generalText,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.cloudy_color),
                fontSize = 16.sp
            )

            Text(
                text = item.secondaryText,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                fontSize = 12.sp
            )

            Row(
                modifier = modifier.padding(top = 16.dp),
//                verticalAlignment = Alignment.CenterVertically
            ) {
                item.points.forEach {
                    PointView(item = it)
                }
            }

            Box(
                modifier = modifier
                    .alpha(0.5f)
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(
                        color = colorResource(id = item.dividerColorResId),
                        shape = MaterialTheme.shapes.medium
                    )
            )

            Text(
                modifier = modifier.padding(top = 16.dp),
                text = item.previewText,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.cloudy_color),
                fontSize = 16.sp,
                textAlign = TextAlign.Start
            )

        }
    }
}

@Composable
fun RowScope.PointView(
    modifier: Modifier = Modifier,
    item: SelfKnowledgeItemPoint
) {

    Column(
        modifier = modifier.weight(1f)
    ) {
        Image(
            modifier = modifier.size(24.dp),
            painter = painterResource(id = item.iconId),
            contentDescription = null
        )

        Text(
            modifier = modifier.padding(top = 8.dp),
            text = stringResource(id = item.titleResId),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.point_title_color),
            fontSize = 13.sp
        )

        Text(
            text = item.text,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.cloudy_color),
            fontSize = 14.sp
        )
    }

}