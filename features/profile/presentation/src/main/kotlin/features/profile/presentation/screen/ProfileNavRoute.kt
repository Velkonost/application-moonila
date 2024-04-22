package features.profile.presentation.screen

import androidx.compose.runtime.Composable
import core.compose.NavRoute
import core.vm.navigation.NavigationScreen
import features.profile.presentation.ProfileViewModel
import org.koin.androidx.compose.koinViewModel

object ProfileNavRoute : NavRoute<ProfileViewModel> {

    override val route: String
        get() = NavigationScreen.ProfileNavScreen.route

    @Composable
    override fun Content(viewModel: ProfileViewModel) =
        ProfileScreen(viewModel = viewModel)

    override val viewModel: ProfileViewModel
        @Composable get() = koinViewModel()

}
