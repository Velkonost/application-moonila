package features.profile.presentation.screen.components.settings

import android.widget.Space
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.profile.presentation.R
import core.compose.theme.PoppinsFontFamily
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SettingsSheet(
    modifier: Modifier = Modifier,
    modalSheetState: ModalBottomSheetState,
) {
    val scope = rememberCoroutineScope()
    BackHandler {
        scope.launch {
            modalSheetState.hide()
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetBackgroundColor = colorResource(id = com.moonila.core.compose.R.color.general_bg),
        sheetContent = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f),
            ) {
                SettingsHeader {
                    scope.launch {
                        modalSheetState.hide()
                    }
                }

                Spacer(modifier = modifier.height(16.dp))

                SettingsItem(
                    title = stringResource(id = R.string.restore_purchase),
                    icon = painterResource(id = R.drawable.ic_restore_purchase),
                    onClick = {

                    }
                )
                SettingsItem(
                    title = stringResource(id = R.string.feedback),
                    icon = painterResource(id = R.drawable.ic_feedback),
                    onClick = {

                    }
                )
                SettingsItem(
                    title = stringResource(id = R.string.rate_us),
                    icon = painterResource(id = R.drawable.ic_rate_us),
                    onClick = {

                    }
                )
                SettingsItem(
                    title = stringResource(id = R.string.how_it_works),
                    icon = painterResource(id = R.drawable.ic_how_it_works),
                    onClick = {

                    }
                )
                SettingsItem(
                    title = stringResource(id = R.string.term_of_service),
                    icon = painterResource(id = R.drawable.ic_term_of_service),
                    onClick = {

                    }
                )
                SettingsItem(
                    title = stringResource(id = R.string.privacy_policy),
                    icon = painterResource(id = R.drawable.ic_privacy_policy),
                    onClick = {

                    }
                )
            }
        }
    ) {}
}

@Composable
fun SettingsItem(
    modifier: Modifier = Modifier,
    title: String,
    icon: Painter,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(top = 8.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(12.dp),
                color = colorResource(id = R.color.settings_item_border)
            )
            .padding(horizontal = 12.dp, vertical = 16.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier.size(24.dp),
            painter = icon,
            contentDescription = null
        )
        Text(
            modifier = modifier.padding(start = 8.dp),
            text = title,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}