package features.profile.presentation.contract

import core.vm.contracts.UIContract

data class ProfileViewState(
    val isLoading: Boolean = true,
    val notificationsState: NotificationsState = NotificationsState()
): UIContract.State

data class NotificationsState(
    val first: String? = "09:00",
    val second: String? = "11:00",
    val third: String? = null
)