package features.wisdom.presentation

import core.vm.BaseViewModel
import features.wisdom.api.WisdomRepository
import features.wisdom.presentation.contract.WisdomAction
import features.wisdom.presentation.contract.WisdomEvent
import features.wisdom.presentation.contract.WisdomNavigation
import features.wisdom.presentation.contract.WisdomViewState

class WisdomViewModel
internal constructor(
    private val wisdomRepository: WisdomRepository
) : BaseViewModel<WisdomViewState, WisdomAction, WisdomNavigation, WisdomEvent>(
    initialState = WisdomViewState()
) {
    override fun dispatch(action: WisdomAction) = when(action) {
        else -> {

        }
    }


}