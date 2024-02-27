package features.paywall.presentation

import core.vm.BaseViewModel
import features.paywall.presentation.contract.PaywallAction
import features.paywall.presentation.contract.PaywallEvent
import features.paywall.presentation.contract.PaywallNavigation
import features.paywall.presentation.contract.PaywallViewState


class PaywallViewModel
internal constructor(
) : BaseViewModel<PaywallViewState, PaywallAction, PaywallNavigation, PaywallEvent>(
    initialState = PaywallViewState()
) {

    override fun dispatch(action: PaywallAction) = when (action) {
        else -> {}
    }

}