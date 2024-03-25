package features.practice.presentation.contract

import core.vm.contracts.UIContract

data class PracticeViewState(
    val isLoading: Boolean = false
): UIContract.State