package features.profile.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.profile.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.profile.presentation.contract.NotificationsState

@Composable
fun ColumnScope.NotificationsBlock(
    modifier: Modifier = Modifier,
    notificationsState: NotificationsState,
    onSetClick: (Int) -> Unit,
    onClearClick: (Int) -> Unit
) {
    Row {
        Text(
            modifier = modifier.padding(top = 24.dp),
            text = stringResource(id = R.string.notifications_title),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = com.moonila.core.compose.R.color.common_text_color),
            fontSize = 16.sp,
        )
        Spacer(modifier = modifier.weight(1f))
    }

    Spacer(modifier = modifier.height(6.dp))
    NotificationItem(
        title = stringResource(id = R.string.calendar_notification),
        time = notificationsState.first
    ) {
        if (notificationsState.first.isNullOrEmpty()) {
            onSetClick.invoke(1)
        } else {
            onClearClick.invoke(1)
        }
    }
    NotificationItem(
        title = stringResource(id = R.string.affirmations_notification),
        time = notificationsState.second
    ) {
        if (notificationsState.second.isNullOrEmpty()) {
            onSetClick.invoke(2)
        } else {
            onClearClick.invoke(2)
        }
    }
    NotificationItem(
        title = stringResource(id = R.string.tip_notification),
        time = notificationsState.third
    ) {
        if (notificationsState.third.isNullOrEmpty()) {
            onSetClick.invoke(3)
        } else {
            onClearClick.invoke(3)
        }
    }

}

@Composable
fun NotificationItem(
    modifier: Modifier = Modifier,
    title: String,
    time: String?,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .height(60.dp)
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(12.dp),
                color = colorResource(id = R.color.settings_item_border)
            )
            .padding(vertical = 8.dp)
            .padding(start = 16.dp, end = 12.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = modifier.fillMaxHeight()) {
            Text(
                text = title,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = com.moonila.core.compose.R.color.common_text_color),
                fontSize = 12.sp,
            )
            Text(
                text = time ?: stringResource(id = R.string.notification_not_set),
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 18.sp,
            )
        }
        Spacer(modifier = modifier.weight(1f))

        Image(
            modifier = modifier
                .width(51.dp)
                .height(31.dp),
            painter = painterResource(id = if (time == null) R.drawable.ic_profile_toggle_off else R.drawable.ic_profile_toggle_on),
            contentDescription = null
        )
    }

}