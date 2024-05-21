package features.profile.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.profile.presentation.R
import core.compose.components.AppOutlineButton
import core.compose.composable.orangeTextGradient
import core.compose.theme.BonaNovaFontFamily
import core.compose.theme.PoppinsFontFamily

@Composable
fun UserDataBlock(
    modifier: Modifier = Modifier,
    userName: String,
    birthPlace: String,
    moonText: String,
    onEditProfileClick: () -> Unit
) {

    Box(
        modifier = modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
            .background(
                color = colorResource(id = R.color.user_data_bg),
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp))
    ) {

        Row {
            Spacer(modifier.weight(1f))
            Image(
                modifier = modifier.size(200.dp),
                painter = painterResource(id = R.drawable.ic_user_data_block),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = userName,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                fontSize = 20.sp
            )

            Text(
                modifier = modifier.padding(top = 12.dp),
                text = birthPlace,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontSize = 12.sp
            )

            Row(
                modifier = modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_profile_user_data_loonar),
                    contentDescription = null
                )

                Text(
                    modifier = modifier.padding(start = 8.dp),
                    text = moonText,
                    fontFamily = BonaNovaFontFamily,
                    fontWeight = FontWeight.Bold,
                    style = orangeTextGradient(fontSize = 18.sp)
                )
            }

            AppOutlineButton(
                modifier = modifier.padding(top = 24.dp),
                height = 36,
                width = 0.4f,
                fontSize = 14,
                label = stringResource(id = R.string.edit_profile),
                onClick = onEditProfileClick
            )
        }

    }
}