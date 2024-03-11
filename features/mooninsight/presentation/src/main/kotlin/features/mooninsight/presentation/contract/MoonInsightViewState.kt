package features.mooninsight.presentation.contract

import core.vm.contracts.UIContract

data class MoonInsightViewState(
    val isLoading: Boolean = false
): UIContract.State