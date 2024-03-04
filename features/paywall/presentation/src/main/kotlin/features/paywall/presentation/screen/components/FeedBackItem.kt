package features.paywall.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.paywall.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.paywall.presentation.model.Feedback

@Composable
fun LazyItemScope.FeedBackItem(
    modifier: Modifier = Modifier,
    item: Feedback
) {
    Column(
        modifier = modifier
            .fillParentMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = modifier
                .height(32.dp),
            painter = painterResource(id = R.drawable.ic_five_stars),
            contentDescription = null
        )

        Text(
            modifier = modifier
                .padding(top = 12.dp),
            text = stringResource(id = item.title),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = com.moonila.core.compose.R.color.light_color)
        )

        Text(
            modifier = modifier
                .padding(top = 12.dp)
                .padding(horizontal = 16.dp),
            text = stringResource(id = item.text),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            minLines = 4,
            maxLines = 4,
            textAlign = TextAlign.Center,
            color = colorResource(id = com.moonila.core.compose.R.color.light_color)
        )

        Text(
            modifier = modifier
                .padding(top = 12.dp)
                .padding(horizontal = 16.dp),
            text = stringResource(id = item.author),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = com.moonila.core.compose.R.color.light_color)
        )
    }
}