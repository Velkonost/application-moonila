package features.mooninsight.presentation

import core.vm.BaseViewModel
import features.mooninsight.presentation.contract.MoonInsightAction
import features.mooninsight.presentation.contract.MoonInsightEvent
import features.mooninsight.presentation.contract.MoonInsightNavigation
import features.mooninsight.presentation.contract.MoonInsightViewState

class MoonInsightViewModel
internal constructor(
) : BaseViewModel<MoonInsightViewState, MoonInsightAction, MoonInsightNavigation, MoonInsightEvent>(
    initialState = MoonInsightViewState()
) {
    override fun dispatch(action: MoonInsightAction) {
        TODO("Not yet implemented")
    }

}
