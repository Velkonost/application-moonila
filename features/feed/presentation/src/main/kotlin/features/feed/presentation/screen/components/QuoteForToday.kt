package features.feed.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.feed.presentation.R
import core.compose.theme.PoppinsFontFamily

@Composable
fun ColumnScope.QuoteForToday(
    modifier: Modifier = Modifier,
    text: String,
    author: String
) {

    BlockTitle(text = stringResource(id = R.string.quote_for_today))

    Column(
        modifier = modifier
            .padding(top = 12.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .background(
                color = colorResource(id = R.color.quote_bg),
                shape = MaterialTheme.shapes.medium
            )
            .clip(MaterialTheme.shapes.medium)
    ) {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .height(160.dp),
            painter = painterResource(id = R.drawable.ic_quote_example),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = modifier
                .padding(top = 16.dp)
                .padding(horizontal = 20.dp),
            text = text,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = com.moonila.core.compose.R.color.light_color),
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Start
        )

        Row {
            Spacer(modifier.weight(1f))
            Text(
                modifier = modifier
                    .alpha(0.5f)
                    .padding(top = 10.dp, bottom = 20.dp)
                    .padding(horizontal = 20.dp),
                text = author,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                fontSize = 14.sp,
                textAlign = TextAlign.End
            )
        }
    }
}