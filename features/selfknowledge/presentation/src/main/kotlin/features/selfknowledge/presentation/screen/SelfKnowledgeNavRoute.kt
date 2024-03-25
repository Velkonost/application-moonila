package features.selfknowledge.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import core.compose.NavRoute
import core.vm.navigation.NavigationScreen
import features.selfknowledge.presentation.SelfKnowledgeViewModel
import org.koin.androidx.compose.koinViewModel

object SelfKnowledgeNavRoute : NavRoute<SelfKnowledgeViewModel> {

    override val route: String
        get() = NavigationScreen.SelfKnowledgeNavScreen.route

    @Composable
    override fun Content(viewModel: SelfKnowledgeViewModel) =
        SelfKnowledgeScreen(viewModel = viewModel)

    @Composable
    override fun Content(viewModel: SelfKnowledgeViewModel, forceHideBottomBar: MutableState<Boolean>) =
        SelfKnowledgeScreen(viewModel = viewModel, forceHideBottomBar = forceHideBottomBar)

    override val viewModel: SelfKnowledgeViewModel
        @Composable get() = koinViewModel()

}
