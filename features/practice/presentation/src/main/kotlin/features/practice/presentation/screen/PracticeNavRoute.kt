package features.practice.presentation.screen

import androidx.compose.runtime.Composable
import core.compose.NavRoute
import core.vm.navigation.NavigationScreen
import features.practice.presentation.PracticeViewModel
import org.koin.androidx.compose.koinViewModel

object PracticeNavRoute : NavRoute<PracticeViewModel> {

    override val route: String
        get() = NavigationScreen.PracticeNavScreen.route

    @Composable
    override fun Content(viewModel: PracticeViewModel) =
        PracticeScreen(viewModel = viewModel)

    override val viewModel: PracticeViewModel
        @Composable get() = koinViewModel()

}
