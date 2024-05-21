package features.profile.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.profile.presentation.R
import core.compose.components.AppButton
import core.compose.composable.orangeTextGradient
import core.compose.theme.BonaNovaFontFamily

@Composable
fun AnonymousBlock(
    modifier: Modifier = Modifier,
    onSignInClick: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
            .background(
                color = colorResource(id = R.color.anonymous_bg),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.anonymous_title),
            fontFamily = BonaNovaFontFamily,
            fontWeight = FontWeight.Bold,
            style = orangeTextGradient(fontSize = 24.sp)
        )

        Text(
            modifier = modifier.padding(top = 16.dp),
            text = stringResource(id = R.string.anonymous_text),
            fontSize = 14.sp,
            color = colorResource(id = com.moonila.core.compose.R.color.common_text_color),
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )

        AppButton(
            modifier = modifier.padding(top = 24.dp),
            label = stringResource(id = R.string.anonymous_btn),
            enabled = true,
            includeBottomPadding = false,
            includeHorizontalPadding = false,
            onClick = onSignInClick
        )
    }

}