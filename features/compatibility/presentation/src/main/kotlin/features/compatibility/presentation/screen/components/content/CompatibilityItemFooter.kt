package features.compatibility.presentation.screen.components.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.moonila.features.compatibility.presentation.R

@Composable
fun CompatibilityItemFooter(
    modifier: Modifier = Modifier,
    firstMoonIconResId: Int,
    secondMoonIconResId: Int,
    firstSignIconResId: Int,
    secondSignIconResId: Int
) {

    Row(
        modifier = modifier.padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            Image(
                modifier = modifier
                    .offset(x = 20.dp)
                    .size(32.dp)
                    .border(
                        width = 2.dp,
                        color = colorResource(id = R.color.compatibility_item_bg),
                        shape = CircleShape
                    )
                    .padding(1.dp),
                painter = painterResource(id = secondMoonIconResId),
                contentDescription = null
            )
            Image(
                modifier = modifier

                    .size(32.dp)
                    .border(
                        width = 2.dp,
                        color = colorResource(id = R.color.compatibility_item_bg),
                        shape = CircleShape
                    )
                    .padding(1.dp),
                painter = painterResource(id = firstMoonIconResId),
                contentDescription = null
            )
        }
        Spacer(modifier.weight(1f))
        Box {
            Image(
                modifier = modifier
                    .size(32.dp),
                painter = painterResource(id = secondSignIconResId),
                contentDescription = null
            )
            Image(
                modifier = modifier
                    .offset(x = (-28).dp)
                    .size(32.dp),
                painter = painterResource(id = firstSignIconResId),
                contentDescription = null
            )
        }
    }
}