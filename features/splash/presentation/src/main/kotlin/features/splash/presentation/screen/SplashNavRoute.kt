package features.splash.presentation.screen

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import core.compose.AnimatedBackStack
import core.compose.NavRoute
import core.vm.navigation.NavigationScreen
import features.splash.presentation.SplashViewModel
import org.koin.androidx.compose.koinViewModel

object SplashNavRoute : NavRoute<SplashViewModel> {

    override val route: String
        get() = NavigationScreen.SplashNavScreen.route

    @Composable
    override fun Content(viewModel: SplashViewModel) = SplashScreen(viewModel = viewModel)

    override val viewModel: SplashViewModel
        @Composable get() = koinViewModel()

    override fun getExitTransition(): (AnimatedBackStack.() -> ExitTransition?) = SplashExitTransition

}


val SplashExitTransition: AnimatedBackStack.() -> ExitTransition? = {
    fadeOut(
        animationSpec = tween(
            durationMillis = 280,
            delayMillis = 20,
            easing = androidx.compose.animation.core.FastOutSlowInEasing
        )
    )
}