package features.compatibility.presentation.contract

import core.vm.contracts.UIContract

data class CompatibilityViewState(
    val isLoading: Boolean = false
): UIContract.State