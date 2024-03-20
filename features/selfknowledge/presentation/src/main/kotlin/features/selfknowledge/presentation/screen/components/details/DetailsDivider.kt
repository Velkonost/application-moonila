package features.selfknowledge.presentation.screen.components.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun DetailsDivider(
    modifier: Modifier = Modifier,
    color: Color
) {
    Box(
        modifier = modifier
            .alpha(0.5f)
            .padding(top = 16.dp)
            .fillMaxWidth()
            .height(1.dp)
            .background(
                color = color,
                shape = MaterialTheme.shapes.medium
            )
    )
}