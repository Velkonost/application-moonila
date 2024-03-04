package features.paywall.presentation.contract

import core.vm.contracts.UIContract
import features.paywall.presentation.model.Offer

sealed interface PaywallAction: UIContract.Action {

    data class OfferSelect(val value: Offer) : PaywallAction

}