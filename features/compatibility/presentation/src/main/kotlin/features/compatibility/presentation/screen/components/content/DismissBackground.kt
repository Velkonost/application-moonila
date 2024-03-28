package features.compatibility.presentation.screen.components.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DismissState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.moonila.features.compatibility.presentation.R


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DismissBackground(
    modifier: Modifier = Modifier,
    dismissState: DismissState
) {
    val direction = dismissState.dismissDirection

    Row(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = colorResource(id = R.color.dismiss_bg),
                shape = RoundedCornerShape(16.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier.weight(1f))
        Image(
            modifier = modifier
                .padding(end = 12.dp)
                .size(24.dp),
            painter = painterResource(id = R.drawable.ic_compatibility_trash),
            contentDescription = null
        )
    }
}