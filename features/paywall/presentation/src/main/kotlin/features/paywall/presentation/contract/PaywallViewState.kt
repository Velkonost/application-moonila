package features.paywall.presentation.contract

import core.vm.contracts.UIContract
import features.paywall.presentation.model.Feedback

data class PaywallViewState(
    val isLoading: Boolean = false,
    val feedbacks: List<Feedback> = Feedback.entries
): UIContract.State