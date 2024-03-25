package features.feed.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import core.compose.NavRoute
import core.vm.navigation.NavigationScreen
import features.feed.presentation.FeedViewModel
import org.koin.androidx.compose.koinViewModel

object FeedNavRoute : NavRoute<FeedViewModel> {

    override val route: String
        get() = NavigationScreen.FeedNavScreen.route

    @Composable
    override fun Content(viewModel: FeedViewModel) =
        FeedScreen(viewModel = viewModel)

    @Composable
    override fun Content(viewModel: FeedViewModel, forceHideBottomBar: MutableState<Boolean>) =
        FeedScreen(viewModel = viewModel, forceHideBottomBar = forceHideBottomBar)

    override val viewModel: FeedViewModel
        @Composable get() = koinViewModel()


}