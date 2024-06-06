package features.profile.presentation.contract

import core.vm.contracts.UIContract
import features.profile.presentation.model.UserGender

data class ProfileViewState(
    val isLoading: Boolean = true,
    val notificationsState: NotificationsState = NotificationsState(),
    val userDataState: UserDataState = UserDataState()
): UIContract.State

data class NotificationsState(
    val first: String? = "09:00",
    val second: String? = "11:00",
    val third: String? = null
)

data class UserDataState(
    val name: String = "Maksim",
    val gender: UserGender = UserGender.entries.first(),
    val dateOfBirth: String = "",
    val timeOfBirth: String = "",
    val placeOfBirth: String = "Novosibirsk, Russia"
)