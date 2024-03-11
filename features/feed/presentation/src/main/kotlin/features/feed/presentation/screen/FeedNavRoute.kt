package features.feed.presentation.screen

import androidx.compose.runtime.Composable
import core.compose.NavRoute
import core.vm.navigation.NavigationScreen
import features.feed.presentation.FeedViewModel
import org.koin.androidx.compose.koinViewModel

object FeedNavRoute : NavRoute<FeedViewModel> {

    override val route: String
        get() = NavigationScreen.FeedNavScreen.route

    @Composable
    override fun Content(viewModel: FeedViewModel) = FeedScreen(viewModel = viewModel)

    override val viewModel: FeedViewModel
        @Composable get() = koinViewModel()


}