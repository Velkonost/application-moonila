package features.selfknowledge.presentation.contract

import core.vm.contracts.UIContract

data class SelfKnowledgeViewState(
    val isLoading: Boolean = false,
    val userName: String = "Maksim Mironov",
    val userData: String = "Born May 11, 1994 at 10:13 am,\nNovosibirsk, Russia"
): UIContract.State