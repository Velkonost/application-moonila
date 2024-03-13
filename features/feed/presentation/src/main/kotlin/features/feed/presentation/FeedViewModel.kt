package features.feed.presentation

import core.vm.BaseViewModel
import features.feed.presentation.contract.FeedAction
import features.feed.presentation.contract.FeedEvent
import features.feed.presentation.contract.FeedNavigation
import features.feed.presentation.contract.FeedViewState
import features.feed.presentation.model.MoonTipContent
import features.feed.presentation.model.MoonTipsItem

class FeedViewModel
internal constructor(
) : BaseViewModel<FeedViewState, FeedAction, FeedNavigation, FeedEvent>(
    initialState = FeedViewState()
) {
    override fun dispatch(action: FeedAction) = when (action) {
        is FeedAction.MoonInsightClick -> emit(FeedNavigation.NavigateToMoonInsight(action.value))
        is FeedAction.MoonTipsClick -> obtainMoonTipsClick(action.value)
    }

    private fun obtainMoonTipsClick(value: MoonTipsItem) {
        val moonTipsState = viewState.value.moonTipsState.copy(
            selectedItem = MoonTipContent(
                type = value,
                text = "Scelerisque quam egestas dictum vulputate etiam at. Purus porttitor sed nulla in dui felis urna arcu eget. Lectus fermentum pharetra ut in fermentum. Arcu faucibus viverra gravida sed pellentesque pharetra dolor. Dolor laoreet dolor arcu augue molestie ac platea. Neque ac tortor."
            )
        )
        emit(viewState.value.copy(moonTipsState = moonTipsState))
    }

}
