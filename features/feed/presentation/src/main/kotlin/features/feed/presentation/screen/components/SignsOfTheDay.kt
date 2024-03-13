package features.feed.presentation.screen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.moonila.features.feed.presentation.R

@Composable
fun SignsOfTheDay(
    modifier: Modifier = Modifier
) {

    BlockTitle(text = stringResource(id = R.string.signs_of_the_day))

}