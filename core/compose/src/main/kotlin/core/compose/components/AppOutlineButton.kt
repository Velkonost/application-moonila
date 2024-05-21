package core.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.core.compose.R
import core.compose.theme.PoppinsFontFamily

@Composable
fun AppOutlineButton(
    modifier: Modifier = Modifier,
    label: String,
    isLoading: Boolean = false,
    height: Int = 56,
    width: Float = 1f,
    fontSize: Int = 18,
    onClick: () -> Unit
) {
    val haptic = LocalHapticFeedback.current

    Button(
        modifier = modifier
            .fillMaxWidth(width)
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.light_color),
                shape = MaterialTheme.shapes.extraLarge
            )
            .height(height.dp),
        enabled = !isLoading,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        onClick = {
            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            onClick.invoke()
        }
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = colorResource(id = R.color.light_color)
            )
        } else {
            Text(
                text = label,
                style = MaterialTheme.typography.titleMedium,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.light_color),
                fontSize = fontSize.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}