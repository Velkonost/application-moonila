package features.feed.presentation.screen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.moonila.features.feed.presentation.R
import features.feed.presentation.contract.SignsOfTheDayState
import features.feed.presentation.screen.components.signsoftheday.ColorOfTheDay
import features.feed.presentation.screen.components.signsoftheday.LuckyMinerals
import features.feed.presentation.screen.components.signsoftheday.PlanetOfTheDay

@Composable
fun SignsOfTheDay(
    modifier: Modifier = Modifier,
    signsOfTheDayState: SignsOfTheDayState
) {

    BlockTitle(text = stringResource(id = R.string.signs_of_the_day))

    ColorOfTheDay(item = signsOfTheDayState.items[0])
    LuckyMinerals(item = signsOfTheDayState.items[1])
    PlanetOfTheDay(item = signsOfTheDayState.items[2])

}