package features.selfknowledge.presentation.screen

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import core.compose.NavRoute
import core.vm.navigation.NavigationScreen
import features.selfknowledge.presentation.SelfKnowledgeViewModel
import org.koin.androidx.compose.koinViewModel

object SelfKnowledgeNavRoute  : NavRoute<SelfKnowledgeViewModel> {

    override val route: String
        get() = NavigationScreen.SelfKnowledgeNavScreen.route

    @Composable
    override fun Content(viewModel: SelfKnowledgeViewModel) = SelfKnowledgeScreen(viewModel = viewModel)

    override val viewModel: SelfKnowledgeViewModel
        @Composable get() = koinViewModel()

}
