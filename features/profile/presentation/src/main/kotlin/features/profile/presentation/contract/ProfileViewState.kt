package features.profile.presentation.contract

import core.vm.contracts.UIContract

data class ProfileViewState(
    val isLoading: Boolean = true
): UIContract.State