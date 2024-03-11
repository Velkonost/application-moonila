package features.feed.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import features.feed.presentation.FeedViewModel

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
    viewModel: FeedViewModel
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    Column {

    }

}