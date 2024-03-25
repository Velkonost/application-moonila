package features.practice.presentation

import core.vm.BaseViewModel
import features.practice.api.PracticeRepository
import features.practice.presentation.contract.PracticeAction
import features.practice.presentation.contract.PracticeEvent
import features.practice.presentation.contract.PracticeNavigation
import features.practice.presentation.contract.PracticeViewState

class PracticeViewModel
internal constructor(
    private val practiceRepository: PracticeRepository
) : BaseViewModel<PracticeViewState, PracticeAction, PracticeNavigation, PracticeEvent>(
    initialState = PracticeViewState()
) {
    override fun dispatch(action: PracticeAction) = when(action) {
        else -> {

        }
    }


}