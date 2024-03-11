package features.mooninsight.presentation.screen

import androidx.compose.runtime.Composable
import core.compose.NavRoute
import core.vm.navigation.NavigationScreen
import features.mooninsight.presentation.MoonInsightViewModel
import org.koin.androidx.compose.koinViewModel

object MoonInsightNavRoute : NavRoute<MoonInsightViewModel> {

    override val route: String
        get() = NavigationScreen.MoonInsightNavScreen.route

    @Composable
    override fun Content(viewModel: MoonInsightViewModel) = MoonInsightScreen(viewModel = viewModel)

    override val viewModel: MoonInsightViewModel
        @Composable get() = koinViewModel()


}