package features.paywall.presentation.screen

import androidx.compose.runtime.Composable
import core.compose.NavRoute
import core.vm.navigation.NavigationScreen
import features.paywall.presentation.PaywallViewModel
import org.koin.androidx.compose.koinViewModel

object PaywallNavRoute : NavRoute<PaywallViewModel> {

    override val route: String
        get() = NavigationScreen.PaywallNavScreen.route

    @Composable
    override fun Content(viewModel: PaywallViewModel) = PaywallScreen(viewModel = viewModel)

    override val viewModel: PaywallViewModel
        @Composable get() = koinViewModel()

}
