package features.selfknowledge.presentation

import core.vm.BaseViewModel
import features.selfknowledge.api.SelfKnowledgeRepository
import features.selfknowledge.presentation.contract.SelfKnowledgeAction
import features.selfknowledge.presentation.contract.SelfKnowledgeEvent
import features.selfknowledge.presentation.contract.SelfKnowledgeNavigation
import features.selfknowledge.presentation.contract.SelfKnowledgeViewState

class SelfKnowledgeViewModel
internal constructor(
    private val selfKnowledgeRepository: SelfKnowledgeRepository
) : BaseViewModel<SelfKnowledgeViewState, SelfKnowledgeAction, SelfKnowledgeNavigation, SelfKnowledgeEvent>(
    initialState = SelfKnowledgeViewState()
) {
    override fun dispatch(action: SelfKnowledgeAction) = when(action) {
        else -> {

        }
    }


}