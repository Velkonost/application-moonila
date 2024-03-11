package features.feed.presentation.contract

import core.vm.contracts.UIContract

data class FeedViewState(
    val isLoading: Boolean = false
): UIContract.State