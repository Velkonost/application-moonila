package features.feed.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.feed.presentation.R
import core.compose.theme.BonaNovaFontFamily
import core.compose.theme.PoppinsFontFamily
import features.feed.presentation.contract.AffirmationState

@Composable
fun Affirmation(
    modifier: Modifier = Modifier,
    affirmationState: AffirmationState
) {

    BlockTitle(text = stringResource(id = R.string.affirmation))

    Box(
        modifier = modifier
            .padding(top = 12.dp, start = 16.dp, end = 16.dp)
            .height(440.dp)
            .fillMaxWidth()
            .background(
                color = colorResource(id = R.color.affirmation_bg),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Image(
            modifier = modifier
                .fillMaxHeight()
                .align(Alignment.Center)
                .padding(vertical = 60.dp),
            painter = painterResource(id = R.drawable.ic_affirmation_bg),
            contentDescription = null
        )

        Row(
            modifier = modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier.weight(1f))
            Image(
                modifier = modifier.size(20.dp),
                painter = painterResource(id = affirmationState.titleIconId),
                contentDescription = null
            )
            Text(
                modifier = modifier
                    .padding(start = 8.dp, top = 2.dp)
                    .alpha(0.7f),
                text = affirmationState.title,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                fontSize = 14.sp,
            )
            Spacer(modifier.weight(1f))
        }

        Column(modifier = modifier.padding(20.dp)) {
            Spacer(modifier.weight(1f))
            Text(
                modifier = modifier,
                text = affirmationState.text,
                fontFamily = BonaNovaFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.affirmation_text_color),
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier.weight(1f))
        }

        Column(modifier = modifier.padding(20.dp)) {
            Spacer(modifier.weight(1f))
            Row {
                Spacer(modifier.weight(1f))
                Image(
                    modifier = modifier.height(36.dp),
                    painter = painterResource(id = R.drawable.ic_affirmation_share_instagram),
                    contentDescription = null
                )
                Spacer(modifier.weight(1f))
            }
        }

        Column(modifier = modifier.padding(20.dp)) {
            Spacer(modifier.weight(1f))
            Row {
                Spacer(modifier.weight(1f))
                Image(
                    modifier = modifier.size(36.dp),
                    painter = painterResource(id = R.drawable.ic_affirmation_share),
                    contentDescription = null
                )
            }
        }
    }

}