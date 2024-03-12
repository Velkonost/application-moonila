package features.mooninsight.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.moonila.features.mooninsight.presentation.R
import core.compose.components.AppButton
import core.compose.theme.PoppinsFontFamily
import core.model.MoonInsightType
import features.mooninsight.presentation.MoonInsightViewModel
import features.mooninsight.presentation.contract.MoonInsightAction
import features.mooninsight.presentation.contract.MoonInsightNavigation

@Composable
fun MoonInsightScreen(
    modifier: Modifier = Modifier,
    viewModel: MoonInsightViewModel
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    val bgColor = colorResource(
        id = when (state.type) {
            MoonInsightType.MoonDay -> R.color.moon_day_bg
            MoonInsightType.MoonSign -> R.color.moon_sign_bg
            MoonInsightType.MoonPhase -> R.color.moon_phase_bg
        }
    )

    val title = stringResource(
        id = when (state.type) {
            MoonInsightType.MoonDay -> R.string.moon_day
            MoonInsightType.MoonSign -> R.string.moon_sign
            MoonInsightType.MoonPhase -> R.string.moon_phase
        }
    )

    val icon = painterResource(
        id = when (state.type) {
            MoonInsightType.MoonDay -> R.drawable.ic_moon_day
            MoonInsightType.MoonSign -> R.drawable.ic_moon_sign
            MoonInsightType.MoonPhase -> R.drawable.ic_moon_phase
        }
    )

    val buttonText = stringResource(
        id = when (state.type) {
            MoonInsightType.MoonDay -> R.string.moon_day
            MoonInsightType.MoonSign -> R.string.moon_sign
            MoonInsightType.MoonPhase -> R.string.moon_phase
        }
    )

    Box {
        Image(
            modifier = modifier.fillMaxWidth(),
            painter = icon,
            contentDescription = null
        )

        Row(modifier = modifier.padding(top = 40.dp, start = 16.dp, end = 16.dp)) {
            Image(
                modifier = modifier
                    .size(24.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = {
                            viewModel.dispatch(MoonInsightNavigation.NavigateBack)
                        }
                    ),
                painter = painterResource(id = R.drawable.ic_cross),
                contentDescription = null
            )
        }

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = bgColor)
                .verticalScroll(rememberScrollState())
                .padding(bottom = 100.dp, top = 40.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Spacer(modifier.weight(1f))
                Text(
                    text = title,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                )
                Spacer(modifier.weight(1f))
            }
        }

        Column(modifier = modifier.fillMaxSize()) {
            Spacer(modifier.weight(1f))
            AppButton(label = buttonText) {
                viewModel.dispatch(MoonInsightAction.NextStepClick)
            }
        }
    }

}