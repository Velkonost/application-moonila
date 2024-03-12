package features.feed.presentation.contract

import core.model.MoonInsightType
import core.vm.contracts.UIContract

sealed interface FeedAction: UIContract.Action {

    data class MoonInsightClick(val value: MoonInsightType) : FeedAction

}