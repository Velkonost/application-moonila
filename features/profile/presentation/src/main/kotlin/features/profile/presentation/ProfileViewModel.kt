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
        else -> {

        }
    }


}