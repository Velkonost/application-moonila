package features.splash.presentation.contract

import core.vm.contracts.UIContract

data class SplashViewState(
    val startDestination: String? = null,
) : UIContract.State