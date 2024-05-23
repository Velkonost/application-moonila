package features.profile.presentation

import core.vm.BaseViewModel
import features.profile.api.ProfileRepository
import features.profile.presentation.contract.ProfileAction
import features.profile.presentation.contract.ProfileEvent
import features.profile.presentation.contract.ProfileNavigation
import features.profile.presentation.contract.ProfileViewState

class ProfileViewModel
internal constructor(
    private val profileRepository: ProfileRepository
) : BaseViewModel<ProfileViewState, ProfileAction, ProfileNavigation, ProfileEvent>(
    initialState = ProfileViewState()
) {
    override fun dispatch(action: ProfileAction) = when(action) {
        is ProfileNavigation.NavigateBack -> emit(ProfileNavigation.NavigateBack)
        is ProfileAction.SetUpNotification -> obtainSetUpNotification(action.index, action.value)
        is ProfileAction.ClearNotification -> obtainSetUpNotification(action.index, null)
        else -> {

        }
    }

    private fun obtainSetUpNotification(index: Int, value: String?) {
        val notificationsState = with(viewState.value.notificationsState) {
            when(index) {
                1 -> copy(first = value)
                2 -> copy(second = value)
                else -> copy(third = value)
            }
        }

        emit(viewState.value.copy(notificationsState = notificationsState))
    }


}