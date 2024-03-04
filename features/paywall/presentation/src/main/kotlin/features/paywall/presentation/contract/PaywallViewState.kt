package features.paywall.presentation.contract

import core.vm.contracts.UIContract
import features.paywall.presentation.model.Feedback
import features.paywall.presentation.model.Offer

data class PaywallViewState(
    val isLoading: Boolean = false,
    val feedbacks: List<Feedback> = Feedback.entries,
    val offers: List<Offer> = Offer.entries,
    val selectedOffer: Offer = Offer.entries.first()
): UIContract.State