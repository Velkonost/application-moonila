package features.wisdom.presentation.contract

import core.vm.contracts.UIContract

data class WisdomViewState(
    val isLoading: Boolean = false
): UIContract.State