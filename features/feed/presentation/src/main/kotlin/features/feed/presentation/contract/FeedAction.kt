package features.feed.presentation.contract

import core.model.MoonInsightType
import core.vm.contracts.UIContract
import features.feed.presentation.model.MoonTipsItem

sealed interface FeedAction: UIContract.Action {

    data class MoonInsightClick(val value: MoonInsightType) : FeedAction

    data class MoonTipsClick(val value: MoonTipsItem) : FeedAction

    data object NextMonthClick : FeedAction

    data object PrevMonthClick : FeedAction

    data object NextDayClick : FeedAction

    data object PrevDayClick : FeedAction

}