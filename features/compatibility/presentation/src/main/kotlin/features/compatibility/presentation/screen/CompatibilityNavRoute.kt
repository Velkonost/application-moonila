package features.compatibility.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import core.compose.NavRoute
import core.vm.navigation.NavigationScreen
import features.compatibility.presentation.CompatibilityViewModel
import org.koin.androidx.compose.koinViewModel

object CompatibilityNavRoute : NavRoute<CompatibilityViewModel> {

    override val route: String
        get() = NavigationScreen.CompatibilityNavScreen.route

    @Composable
    override fun Content(viewModel: CompatibilityViewModel) =
        CompatibilityScreen(viewModel = viewModel)

    @Composable
    override fun Content(viewModel: CompatibilityViewModel, forceHideBottomBar: MutableState<Boolean>) =
        CompatibilityScreen(viewModel = viewModel, forceHideBottomBar = forceHideBottomBar)

    override val viewModel: CompatibilityViewModel
        @Composable get() = koinViewModel()

}
