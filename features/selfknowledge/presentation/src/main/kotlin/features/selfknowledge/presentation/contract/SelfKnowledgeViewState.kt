package features.selfknowledge.presentation.contract

import core.vm.contracts.UIContract

data class SelfKnowledgeViewState(
    val isLoading: Boolean = false
): UIContract.State