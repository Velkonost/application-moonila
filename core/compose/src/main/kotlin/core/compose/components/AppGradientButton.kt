package core.compose.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Brush
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
fun AppGradientButton(
    modifier: Modifier = Modifier,
    label: String,
    isLoading: Boolean = false,
    onClick: () -> Unit
) {

    val haptic = LocalHapticFeedback.current

    Button(
        modifier = modifier
            .fillMaxWidth()
            .consumeWindowInsets(PaddingValues(bottom = 36.dp))
            .imePadding()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        colorResource(id = R.color.orange_gradient_start),
                        colorResource(id = R.color.orange_gradient_end),
                    )
                ),
                shape = MaterialTheme.shapes.extraLarge
            )

            .height(56.dp),
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
                color = Color.White
            )
        } else {
            Text(
                text = label,
                style = MaterialTheme.typography.titleMedium,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
            )
        }
    }

}