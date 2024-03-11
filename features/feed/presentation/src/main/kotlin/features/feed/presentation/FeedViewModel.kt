package features.feed.presentation

import core.vm.BaseViewModel
import features.feed.presentation.contract.FeedAction
import features.feed.presentation.contract.FeedEvent
import features.feed.presentation.contract.FeedNavigation
import features.feed.presentation.contract.FeedViewState

class FeedViewModel
internal constructor(
) : BaseViewModel<FeedViewState, FeedAction, FeedNavigation, FeedEvent>(
    initialState = FeedViewState()
) {
    override fun dispatch(action: FeedAction) {
        TODO("Not yet implemented")
    }

}
