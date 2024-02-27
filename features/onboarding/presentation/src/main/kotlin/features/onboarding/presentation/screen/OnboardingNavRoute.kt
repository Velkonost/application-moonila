package features.onboarding.presentation.screen

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import core.compose.NavRoute
import core.vm.navigation.NavigationScreen
import features.onboarding.presentation.OnboardingViewModel
import org.koin.androidx.compose.koinViewModel

object OnboardingNavRoute : NavRoute<OnboardingViewModel> {

    override val route: String
        get() = NavigationScreen.OnboardingNavScreen.route

    @Composable
    override fun Content(viewModel: OnboardingViewModel) = OnboardingScreen(viewModel = viewModel)

    override val viewModel: OnboardingViewModel
        @Composable get() = koinViewModel()

}
