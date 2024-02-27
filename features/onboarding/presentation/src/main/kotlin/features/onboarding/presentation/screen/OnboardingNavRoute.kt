package features.onboarding.presentation.screen

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import core.compose.AnimatedBackStack
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

    override fun getEnterTransition(): (AnimatedBackStack.() -> EnterTransition?)? = OnboardingEnterTransition
}

val OnboardingEnterTransition: AnimatedBackStack.() -> EnterTransition? = {
    fadeIn(
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 10,
            easing = FastOutSlowInEasing
        )
    )

}
