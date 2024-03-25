package features.wisdom.presentation.screen

import androidx.compose.runtime.Composable
import core.compose.NavRoute
import core.vm.navigation.NavigationScreen
import features.wisdom.presentation.WisdomViewModel
import org.koin.androidx.compose.koinViewModel

object WisdomNavRoute : NavRoute<WisdomViewModel> {

    override val route: String
        get() = NavigationScreen.WisdomNavScreen.route

    @Composable
    override fun Content(viewModel: WisdomViewModel) =
        WisdomScreen(viewModel = viewModel)

    override val viewModel: WisdomViewModel
        @Composable get() = koinViewModel()

}
