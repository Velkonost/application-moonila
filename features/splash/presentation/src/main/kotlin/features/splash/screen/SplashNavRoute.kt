package features.splash.screen

import androidx.compose.runtime.Composable
import core.compose.NavRoute
import core.vm.navigation.NavigationScreen
import features.splash.SplashViewModel
import org.koin.androidx.compose.koinViewModel

object SplashNavRoute : NavRoute<SplashViewModel> {

    override val route: String
        get() = NavigationScreen.SplashNavScreen.route

    @Composable
    override fun Content(viewModel: SplashViewModel) = SplashScreen(viewModel = viewModel)

    override val viewModel: SplashViewModel
        @Composable get() = koinViewModel()

}
