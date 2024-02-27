package features.paywall.presentation.contract

import core.vm.contracts.UIContract

data class PaywallViewState(
    val isLoading: Boolean = false
): UIContract.State